package hackaton8e_sanitas.group8.medication.service;

import hackaton8e_sanitas.group8.medication.MedicationEntity;
import hackaton8e_sanitas.group8.medication.dtos.MedicationMapper;
import hackaton8e_sanitas.group8.medication.dtos.MedicationRequestDTO;
import hackaton8e_sanitas.group8.medication.dtos.MedicationResponseDTO;
import hackaton8e_sanitas.group8.medication.repository.MedicationRepository;
import hackaton8e_sanitas.group8.user.UserEntity;
import hackaton8e_sanitas.group8.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepository medicationRepository;
    private final UserRepository userRepository;
    private final MedicationMapper medicationMapper;

    @Override
    public List<MedicationResponseDTO> getAllMedicationsByUser(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));

        return medicationRepository.findByUser(user).stream()
                .map(medicationMapper::toResponseDto)
                .toList();
    }

    @Override
    public MedicationResponseDTO getMedicationById(Long userId, Long medicationId) {
        MedicationEntity medication = medicationRepository.findById(medicationId)
                .orElseThrow(() -> new EntityNotFoundException("Medication not found with id " + medicationId));

        if (!medication.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("Medication does not belong to this user");
        }

        return medicationMapper.toResponseDto(medication);
    }

    @Override
    public MedicationResponseDTO createMedication(Long userId, MedicationRequestDTO dto) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));

        MedicationEntity entity = medicationMapper.toEntity(dto);
        entity.setUser(user);

        return medicationMapper.toResponseDto(medicationRepository.save(entity));
    }

    @Override
    public MedicationResponseDTO updateMedication(Long userId, Long medicationId, MedicationRequestDTO dto) {
        MedicationEntity medication = medicationRepository.findById(medicationId)
                .orElseThrow(() -> new EntityNotFoundException("Medication not found with id " + medicationId));

        if (!medication.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("Medication does not belong to this user");
        }

        medication.setName(dto.name());
        medication.setDescription(dto.description());
        medication.setQuantity(dto.quantity());
        medication.setUnits(dto.units());
        medication.setType(dto.type());

        return medicationMapper.toResponseDto(medicationRepository.save(medication));
    }

    @Override
    public void deleteMedication(Long userId, Long medicationId) {
        MedicationEntity medication = medicationRepository.findById(medicationId)
                .orElseThrow(() -> new EntityNotFoundException("Medication not found with id " + medicationId));

        if (!medication.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("Medication does not belong to this user");
        }

        medicationRepository.delete(medication);
    }
}
