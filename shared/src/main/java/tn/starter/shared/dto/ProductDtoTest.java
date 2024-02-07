package tn.starter.shared.dto;


import lombok.*;

import java.time.LocalDate;


<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductDtoTest{
    private LocalDate createdAt, updatedAt;
    private String name;
=======
@Builder
public record  ProductDto (LocalDate createdAt, LocalDate updatedAt, String name, StockDto stockDto){
>>>>>>> 4bbe3f7bf06aa0addb59e57c54fca6ffacc8e0da
}
