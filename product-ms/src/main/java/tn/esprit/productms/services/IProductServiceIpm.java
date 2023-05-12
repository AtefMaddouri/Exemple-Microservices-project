package tn.esprit.productms.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import tn.esprit.productms.entities.Product;
import tn.esprit.productms.repositories.ProductRepository;
import tn.starter.shared.dto.ProductDto;
import tn.starter.shared.generiqueservice.IGenericServiceImp;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class IProductServiceIpm extends IGenericServiceImp<Product,Long>  implements IProductService{

    private final ProductRepository productRepository;
    private final IStockServicesFeignClient iStockServicesFeignClient;




    @Override
    @Transactional
    public Product patchUpdate(Map<Object, Object> fields, long id) {

        Product product = productRepository.findById(id).orElse(null);
        Assert.notNull(product,"product not found with this id: "+id);

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Product.class, (String) key);
            field.setAccessible(true);

            log.info(key + " " +field.getType()+"  "+value);

            if(field.getType().equals(LocalDate.class)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
                LocalDate localDate = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, product , localDate);
            }else {
                ReflectionUtils.setField(field, product , value);
            }



        });

        return product;
    }

    @Override
    public ProductDto getProductById(Long id) {

        Product product = productRepository.findById(id).orElse(null);
        Assert.notNull(product,"No Product Found with this id :"+id);

        ProductDto productDto = ProductDto.builder()
                .name(product.getName())
                .stockDto(iStockServicesFeignClient.getStockById(product.getStockId()))
                .build();

        return productDto;
    }
}
