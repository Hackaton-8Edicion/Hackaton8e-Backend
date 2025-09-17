package hackaton8e_sanitas.group8.treatment.dtos;

import java.time.LocalDate;

public record TreatmentResponseDTO(
        Long id_treatment,
        Long medication_id,
        int dosage,
        boolean indefinite,
        LocalDate startDate,
        LocalDate endDate,
        boolean active
) {
}