package tn.esprit.productms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.productms.entities.Product;
import tn.esprit.productms.services.IProductService;
import tn.starter.shared.dto.ProductDto;
import tn.starter.shared.generiqueservice.GenericController;

import java.util.Map;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController extends GenericController<Product,Long> {

    private final IProductService productService;

    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
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
