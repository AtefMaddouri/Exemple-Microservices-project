package tn.starter.shared.dto;


import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductDtoTest{
    private LocalDate createdAt, updatedAt;
    private String name;
}
