package hackaton8e_sanitas.group8.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
@Data
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 15)
    private String username;

    @Column(name = "name", nullable = false, unique = true, length = 15)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 60)
    private String email;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "cardnumber", nullable = false, length = 60)
    private String cardnumber;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
