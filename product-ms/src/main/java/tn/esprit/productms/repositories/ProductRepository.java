package tn.esprit.productms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.productms.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}