package tn.esprit.productms.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.starter.shared.entities.BaseEntity;


import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends BaseEntity {

    LocalDate createdAt;
    LocalDate updatedAt;

    String name;

    Long stockId;

}
