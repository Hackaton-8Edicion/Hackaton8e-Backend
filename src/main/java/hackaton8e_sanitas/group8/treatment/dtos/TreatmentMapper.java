package hackaton8e_sanitas.group8.treatment.dtos;

import hackaton8e_sanitas.group8.medication.MedicationEntity;
import hackaton8e_sanitas.group8.treatment.TreatmentEntity;
import hackaton8e_sanitas.group8.user.UserEntity;

public class TreatmentMapper {

    public static TreatmentResponseDTO toResponseDto(TreatmentEntity entity) {
        if (entity == null) {
            return null;
        }

        // Convierte LocalDateTime a LocalDate para el DTO
        java.time.LocalDate startDate = entity.getStartDate() != null ? entity.getStartDate().toLocalDate() : null;
        java.time.LocalDate endDate = entity.getEndDate() != null ? entity.getEndDate().toLocalDate() : null;

        // Extrae el ID del medicamento de la entidad de medicación anidada
        Long medicationId = entity.getMedication() != null ? entity.getMedication().getId_medication() : null;

        return new TreatmentResponseDTO(
                entity.getId(),
                medicationId, // Usa solo el ID del medicamento
                Integer.parseInt(entity.getDosage()), // La entidad tiene String, el DTO espera int
                entity.isIndefinite(),
                startDate,
                endDate,
                entity.isActive()
        );
    }

    public static TreatmentEntity toEntity(TreatmentRequestDTO dto, UserEntity user, MedicationEntity medication) {
        if (dto == null) {
            return null;
        }

        // Convierte LocalDate a LocalDateTime para la entidad
        java.time.LocalDateTime startDateTime = dto.startDate() != null ? dto.startDate().atStartOfDay() : null;
        java.time.LocalDateTime endDateTime = dto.endDate() != null ? dto.endDate().atStartOfDay() : null;

        return TreatmentEntity.builder()
                .user(user)
                .medication(medication)
                .dosage(String.valueOf(dto.dosage())) // La entidad espera String, el DTO tiene int
                .indefinite(dto.indefinite())
                .startDate(startDateTime)
                .endDate(endDateTime)
                .active(dto.active())
                .build();
    }
}
