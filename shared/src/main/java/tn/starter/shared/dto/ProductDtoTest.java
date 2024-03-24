package tn.starter.shared.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;



@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductDtoTest{
    private long id, stockId, qte;
    private LocalDate createdAt, updatedAt;
    private String name;
    private StockDtoTest stockDtoTest;
//@Builder
//public record  ProductDto (LocalDate createdAt, LocalDate updatedAt, String name, StockDto stockDto){
}
