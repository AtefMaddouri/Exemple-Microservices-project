package tn.starter.shared.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDto {
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String zone;

}
