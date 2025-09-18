package hackaton8e_sanitas.group8.treatment.service;

import hackaton8e_sanitas.group8.treatment.dtos.TreatmentRequestDTO;
import hackaton8e_sanitas.group8.treatment.dtos.TreatmentResponseDTO;

import java.util.List;

public interface TreatmentService {
    List<TreatmentResponseDTO> getAllTreatmentsByUser(String username);

    TreatmentResponseDTO getTreatmentById(Long id);

    TreatmentResponseDTO createTreatment(TreatmentRequestDTO treatmentDto, String username);

    TreatmentResponseDTO updateTreatment(Long id, TreatmentRequestDTO treatmentDto);

    void deleteTreatment(Long id);
}

