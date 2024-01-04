package tn.esprit.productms.entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.starter.shared.entities.BaseEntity;


import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends BaseEntity {

    String name;
    long qte;

    long stockId;

}
