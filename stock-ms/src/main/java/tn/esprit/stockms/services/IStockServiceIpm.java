package tn.esprit.stockms.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import tn.esprit.stockms.entities.Stock;
import tn.esprit.stockms.repositories.StockRepository;
import tn.starter.shared.generiqueservice.IGenericServiceImp;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class IStockServiceIpm extends IGenericServiceImp<Stock,Long> implements IStockService {

    private final StockRepository stockRepository;



    @Override
    @Transactional
    public Stock patchUpdate(Map<Object, Object> fields, long id) {

        Stock stock = stockRepository.findById(id).orElse(null);
        Assert.notNull(stock,"product not found with this id: "+id);

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Stock.class, (String) key);
            field.setAccessible(true);

            log.info(key + " " +field.getType()+"  "+value);

            if(field.getType().equals(LocalDate.class)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
                LocalDate localDate = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, stock , localDate);
            }else {
                ReflectionUtils.setField(field, stock , value);
            }



        });

        return stock;
    }
}
