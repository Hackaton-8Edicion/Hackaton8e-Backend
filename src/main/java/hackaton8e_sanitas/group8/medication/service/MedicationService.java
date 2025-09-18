package hackaton8e_sanitas.group8.medication.service;

import hackaton8e_sanitas.group8.medication.MedicationEntity;
import hackaton8e_sanitas.group8.medication.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationEntity saveMedication(MedicationEntity medication) {
        return medicationRepository.save(medication);
    }
}
