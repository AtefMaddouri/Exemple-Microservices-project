package tn.esprit.productms.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import tn.esprit.productms.feignClients.IStockServicesFeignClient;
import tn.starter.shared.dto.ProductDto;
import tn.starter.shared.dto.ProductDtoTest;
import tn.starter.shared.dto.StockDto;
import tn.starter.shared.dto.StockDtoTest;

@Aspect
@Component
@RequiredArgsConstructor
public class CustomInterceptor {

    private final IStockServicesFeignClient stockServicesFeignClient;

    @Around("execution(public Object tn.starter.shared.generiqueservice.*.*(..))")
    public Object mapStockWithDTO(ProceedingJoinPoint pjp ) throws Throwable {
        Object o = pjp.proceed();

        Assert.isInstanceOf(ProductDtoTest.class,o);
        ProductDtoTest dto = (ProductDtoTest) o;
        if(dto.getStockId()!= 0) {
            StockDtoTest stockDto =stockServicesFeignClient.getStockById(dto.getStockId());
            dto.setStockDtoTest(stockDto);
        }
        return dto;
    }
}
