package tn.esprit.productms.services;

import tn.esprit.productms.entities.Product;
import tn.starter.shared.dto.ProductDto;

import java.util.Map;

public interface IProductService{// extends IGenericService<Product,Long> {
    Product patchUpdate(Map<Object, Object> fields, long id);

    ProductDto getProductById(Long id);

}
