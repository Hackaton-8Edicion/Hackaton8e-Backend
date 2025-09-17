package hackaton8e_sanitas.group8.user.repository;

import hackaton8e_sanitas.group8.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
