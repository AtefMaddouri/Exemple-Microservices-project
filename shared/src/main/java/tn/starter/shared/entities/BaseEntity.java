package tn.starter.shared.entities;



import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    long id;
    LocalDate createdAt;
    LocalDate updatedAt;
}