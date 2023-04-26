package tn.esprit.productms.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.productms.repositories.ProductRepository;

@Service
public class IProductServiceIpm implements IProductService{

    //@Autowired
    ProductRepository productRepository;
}
