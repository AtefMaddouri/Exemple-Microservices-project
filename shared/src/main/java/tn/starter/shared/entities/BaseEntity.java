package tn.starter.shared.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.MappedSuperclass;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity implements Serializable {
    @Id
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    LocalDate createdAt;
    LocalDate updatedAt;
}