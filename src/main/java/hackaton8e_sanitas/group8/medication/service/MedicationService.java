package hackaton8e_sanitas.group8.medication.service;

import hackaton8e_sanitas.group8.medication.dtos.MedicationRequestDTO;
import hackaton8e_sanitas.group8.medication.dtos.MedicationResponseDTO;

import java.util.List;

public interface MedicationService {
    List<MedicationResponseDTO> getAllMedicationsByUser(Long userId);
    MedicationResponseDTO getMedicationById(Long userId, Long medicationId);
    MedicationResponseDTO createMedication(Long userId, MedicationRequestDTO dto);
    MedicationResponseDTO updateMedication(Long userId, Long medicationId, MedicationRequestDTO dto);
    void deleteMedication(Long userId, Long medicationId);
}
