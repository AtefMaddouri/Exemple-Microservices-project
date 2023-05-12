package tn.starter.shared.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String name;
    private StockDto stockDto;
}
