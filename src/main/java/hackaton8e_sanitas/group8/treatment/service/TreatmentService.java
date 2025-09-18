package hackaton8e_sanitas.group8.treatment.service;

import hackaton8e_sanitas.group8.treatment.dtos.TreatmentRequestDTO;
import hackaton8e_sanitas.group8.treatment.dtos.TreatmentResponseDTO;

import java.util.List;

public interface TreatmentService {
    List<TreatmentResponseDTO> getAllTreatmentsByUser(Long userId);

    TreatmentResponseDTO getTreatmentById(Long id);

    TreatmentResponseDTO createTreatment(TreatmentRequestDTO treatmentDto, Long userId);

    TreatmentResponseDTO updateTreatment(Long id, TreatmentRequestDTO treatmentDto);

    void deleteTreatment(Long id);
}