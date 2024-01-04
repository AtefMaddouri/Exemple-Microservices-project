package tn.starter.shared.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
public record StockDto (LocalDate createdAt, LocalDate updatedAt, String zone) {}

