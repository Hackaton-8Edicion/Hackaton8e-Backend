package hackaton8e_sanitas.group8.medication.dtos;

import hackaton8e_sanitas.group8.medication.MedicationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record MedicationRequestDTO(
    @NotBlank(message = "Medication name is required")
    @Size(min = 2, max = 100, message = "Medication name must be between 2 and 100 characters")
    String name,

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    String description,

    Integer quantity,

    String units,

    MedicationType type
) {

}
