package tn.esprit.productms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import tn.esprit.productms.entities.Product;
import tn.esprit.productms.services.IProductService;
import tn.starter.shared.dto.ProductDto;
import tn.starter.shared.generiqueservice.GenericController;

import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController extends GenericController<Product,Long> {

    private final IProductService productService;

    @Value("${spring.app.value}")
    private String value;
    @GetMapping("welcome")
    public String welcome(){
        return "welcome " + value;
    }



    @PatchMapping("{id}")
    public Product patchUpdate(@RequestBody Map<Object,Object> fields, @PathVariable long id){
        return productService.patchUpdate(fields,id);
    }

    @GetMapping("getProductById/{id}")
    public ProductDto getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }

}
