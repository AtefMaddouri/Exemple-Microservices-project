package tn.esprit.stockms.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductDto {

    LocalDate createdAt;
    LocalDate updatedAt;

    String name;

    StockDto stockDto;
}
