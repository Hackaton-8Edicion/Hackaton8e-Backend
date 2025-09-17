package hackaton8e_sanitas.group8.treatment;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import hackaton8e_sanitas.group8.user.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "treatments")
@AllArgsConstructor @NoArgsConstructor
@Data
@Builder
public class TreatmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "medication_id", nullable = false)
    // private Medication medication; 

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "active", nullable = false)
    private boolean active;
}
