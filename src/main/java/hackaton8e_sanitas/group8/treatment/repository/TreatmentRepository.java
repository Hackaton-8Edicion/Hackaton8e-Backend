package hackaton8e_sanitas.group8.treatment.repository;

import hackaton8e_sanitas.group8.treatment.TreatmentEntity;
import hackaton8e_sanitas.group8.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<TreatmentEntity, Long> {
    List<TreatmentEntity> findByUser(UserEntity user);
}
