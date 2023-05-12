package tn.esprit.productms.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.starter.shared.dto.StockDto;


@FeignClient("STOCK-MS")
public interface IStockServicesFeignClient {
    @GetMapping("/stock/{id}")
    StockDto getStockById(@PathVariable Long id);

}
