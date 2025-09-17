package hackaton8e_sanitas.group8.medication;

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
