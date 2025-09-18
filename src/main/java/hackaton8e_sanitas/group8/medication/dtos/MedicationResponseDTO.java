package hackaton8e_sanitas.group8.medication.dtos;

import hackaton8e_sanitas.group8.medication.MedicationType;

public record MedicationResponseDTO(
    Long id,
    String name,
    String description,
    Integer quantity,
    String units,
    MedicationType type
) {
}
