package tn.esprit.productms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.productms.services.IProductService;

@RestController
@RequestMapping("stock")
public class StockController {

    @Autowired
    IProductService productService;

    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }

}
