package tn.esprit.productms.services;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.starter.shared.dto.StockDto;

@EnableFeignClients

@FeignClient("STOCK-MS")
public interface IStockServicesFeignClient {
  /*  @Roll
    @Retry
    @circuitreaker*/
    @GetMapping("/stock/{id}")
    StockDto getStockById(@PathVariable Long id);

}
