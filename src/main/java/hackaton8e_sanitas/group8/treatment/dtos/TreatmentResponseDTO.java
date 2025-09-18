package hackaton8e_sanitas.group8.treatment.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TreatmentResponseDTO(
        Long id_treatment,
        Long medication_id,
        String dosage,
        Double dosage_unit,
        boolean indefinite,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate startDate,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate endDate,
        boolean active
) {
}