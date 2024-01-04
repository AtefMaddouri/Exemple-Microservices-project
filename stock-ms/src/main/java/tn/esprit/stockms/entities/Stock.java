package tn.esprit.stockms.entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.starter.shared.entities.BaseEntity;


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stock extends BaseEntity {

    String zone;


}
