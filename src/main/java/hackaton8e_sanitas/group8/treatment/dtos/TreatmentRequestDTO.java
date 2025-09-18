package hackaton8e_sanitas.group8.treatment.dtos;

import java.time.LocalDate;

public record TreatmentRequestDTO(
        Long medicationId,
        String dosage,
        Double dosageUnit,
        boolean indefinite,
        LocalDate startDate,
        LocalDate endDate,
        boolean active
) {}