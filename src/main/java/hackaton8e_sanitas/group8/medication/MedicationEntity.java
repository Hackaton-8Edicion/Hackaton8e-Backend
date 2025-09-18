package hackaton8e_sanitas.group8.medication;

import hackaton8e_sanitas.group8.treatment.TreatmentEntity;
import hackaton8e_sanitas.group8.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "medications")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MedicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_medication;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TreatmentEntity> treatments;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity", nullable = true)
    private Integer quantity;

    @Column(name = "units", nullable = true)
    private String units;

    @Column(name = "type", nullable = true)
    @Enumerated(EnumType.STRING)
    private MedicationType type;
}
