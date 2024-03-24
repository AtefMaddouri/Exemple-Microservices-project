package tn.starter.shared.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StockDtoTest{
    private long id;
        private LocalDate createdAt, updatedAt;
        private String zone;

}

