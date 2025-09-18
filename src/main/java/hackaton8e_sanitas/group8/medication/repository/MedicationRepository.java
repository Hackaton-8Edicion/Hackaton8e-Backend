package hackaton8e_sanitas.group8.medication.repository;

import hackaton8e_sanitas.group8.medication.MedicationEntity;
import hackaton8e_sanitas.group8.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> {
    List<MedicationEntity> findByUser(UserEntity userEntity);
}
