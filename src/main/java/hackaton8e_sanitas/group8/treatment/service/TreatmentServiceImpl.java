package hackaton8e_sanitas.group8.treatment.service;

import hackaton8e_sanitas.group8.medication.MedicationEntity;
import hackaton8e_sanitas.group8.medication.repository.MedicationRepository;
import hackaton8e_sanitas.group8.treatment.TreatmentEntity;
import hackaton8e_sanitas.group8.treatment.dtos.TreatmentMapper;
import hackaton8e_sanitas.group8.treatment.dtos.TreatmentRequestDTO;
import hackaton8e_sanitas.group8.treatment.dtos.TreatmentResponseDTO;
import hackaton8e_sanitas.group8.treatment.repository.TreatmentRepository;
import hackaton8e_sanitas.group8.user.UserEntity;
import hackaton8e_sanitas.group8.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final UserRepository userRepository;
    private final MedicationRepository medicationRepository;


    @Override
    public List<TreatmentResponseDTO> getAllTreatmentsByUser(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        return treatmentRepository.findByUser(user).stream()
                .map(TreatmentMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    
    @Override
    public TreatmentResponseDTO getTreatmentById(Long id) {
        TreatmentEntity treatment = treatmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Treatment not found with id: " + id));
        return TreatmentMapper.toResponseDto(treatment);
    }

    @Override
    public TreatmentResponseDTO createTreatment(TreatmentRequestDTO treatmentDto, Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        MedicationEntity medication = medicationRepository.findById(treatmentDto.medicationId())
                .orElseThrow(() -> new EntityNotFoundException("Medication not found with id: " + treatmentDto.medicationId()));

        TreatmentEntity newTreatment = TreatmentMapper.toEntity(treatmentDto, user, medication);
        TreatmentEntity savedTreatment = treatmentRepository.save(newTreatment);
        return TreatmentMapper.toResponseDto(savedTreatment);
    }

    @Override
    public TreatmentResponseDTO updateTreatment(Long id, TreatmentRequestDTO treatmentDto) {
        TreatmentEntity existingTreatment = treatmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Treatment not found with id: " + id));

        // Actualizar campos
        existingTreatment.setDosage(String.valueOf(treatmentDto.dosage()));
        existingTreatment.setIndefinite(treatmentDto.indefinite());
        existingTreatment.setStartDate(treatmentDto.startDate());
        existingTreatment.setEndDate(treatmentDto.endDate());
        existingTreatment.setActive(treatmentDto.active());

        // Si el ID del medicamento cambia, actualizar la relación
        if (!existingTreatment.getMedication().getId_medication().equals(treatmentDto.medicationId())){
            MedicationEntity newMedication = medicationRepository.findById(treatmentDto.medicationId())
                    .orElseThrow(() -> new EntityNotFoundException("Medication not found with id: " + treatmentDto.medicationId()));
            existingTreatment.setMedication(newMedication);
        }

        TreatmentEntity updatedTreatment = treatmentRepository.save(existingTreatment);
        return TreatmentMapper.toResponseDto(updatedTreatment);
    }

    @Override
    public void deleteTreatment(Long id) {
        if (!treatmentRepository.existsById(id)) {
            throw new EntityNotFoundException("Treatment not found with id: " + id);
        }
        treatmentRepository.deleteById(id);
    }

}
