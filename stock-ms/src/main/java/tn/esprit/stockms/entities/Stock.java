package tn.esprit.stockms.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.starter.shared.entities.BaseEntity;

import javax.persistence.Entity;
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stock extends BaseEntity {

    String zone;


}
