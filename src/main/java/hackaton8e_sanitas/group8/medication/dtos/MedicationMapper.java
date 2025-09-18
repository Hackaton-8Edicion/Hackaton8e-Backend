package hackaton8e_sanitas.group8.medication.dtos;

import hackaton8e_sanitas.group8.medication.MedicationEntity;
import org.springframework.stereotype.Component;

@Component
public class MedicationMapper {
    public MedicationEntity toEntity(MedicationRequestDTO dto) {
        if (dto == null) return null;

        return MedicationEntity.builder()
                .name(dto.name())
                .description(dto.description())
                .quantity(dto.quantity())
                .units(dto.units())
                .type(dto.type())
                .build();
    }

    public MedicationResponseDTO toResponseDto(MedicationEntity entity) {
        if (entity == null) return null;

        return new MedicationResponseDTO(
                entity.getId_medication(),
                entity.getName(),
                entity.getDescription(),
                entity.getQuantity(),
                entity.getUnits(),
                entity.getType()
        );
    }
}
