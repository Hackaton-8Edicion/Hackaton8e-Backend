package hackaton8e_sanitas.group8.treatment.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TreatmentRequestDTO(
        Long medicationId,
        String dosage,
        Double dosageUnit,
        boolean indefinite,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate startDate,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate endDate,
        boolean active
) {}