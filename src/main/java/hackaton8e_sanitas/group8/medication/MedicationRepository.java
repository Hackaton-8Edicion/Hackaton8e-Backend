package hackaton8e_sanitas.group8.medication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> {
}
