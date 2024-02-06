package tn.starter.shared.dto;


import lombok.*;

import java.time.LocalDate;


@Builder
public record  ProductDto (LocalDate createdAt, LocalDate updatedAt, String name, StockDto stockDto){
}
