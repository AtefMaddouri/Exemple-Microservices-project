package tn.esprit.stockms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stockms.entities.Stock;
import tn.esprit.stockms.services.IStockService;
import tn.starter.shared.dto.StockDto;
import tn.starter.shared.dto.StockDtoTest;
import tn.starter.shared.generiqueservice.GenericController;

import java.util.Map;

@RestController
@RequestMapping("stock")
public class StockController extends GenericController<StockDtoTest,Stock,Long> {

    @Autowired
    IStockService stockService;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("welcome")
    public String welcome(){
        return "welcome " + applicationName;
    }




}
