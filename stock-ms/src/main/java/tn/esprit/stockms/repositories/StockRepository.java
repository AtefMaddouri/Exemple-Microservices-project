package tn.esprit.stockms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stockms.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}