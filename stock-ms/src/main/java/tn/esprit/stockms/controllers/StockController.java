package tn.esprit.stockms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stockms.entities.Stock;
import tn.esprit.stockms.services.IStockService;
import tn.starter.shared.generiqueservice.GenericController;

import java.util.Map;

@RestController
@RequestMapping("stock")
public class StockController extends GenericController<Stock,Long> {

    @Autowired
    IStockService stockService;

    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    @PatchMapping("{id}")
    public Stock patchUpdate(@RequestBody Map<Object,Object> fields, @PathVariable long id){
        return stockService.patchUpdate(fields,id);
    }

}
