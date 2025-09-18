package hackaton8e_sanitas.group8.medication.repository;

import hackaton8e_sanitas.group8.medication.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> {
}
