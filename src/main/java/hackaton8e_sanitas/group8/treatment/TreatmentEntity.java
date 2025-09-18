package hackaton8e_sanitas.group8.treatment;


import jakarta.persistence.*;
import lombok.*;

import hackaton8e_sanitas.group8.medication.MedicationEntity;
import hackaton8e_sanitas.group8.user.UserEntity;

import java.time.LocalDate;

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
    
    @ManyToOne
    @JoinColumn(name = "medication_id", nullable = false)
    private MedicationEntity medication;
    
    @Column(name = "dosage", nullable = false)
    private String dosage;

    @Column(name = "dosage_unit", nullable = false)
    private Double dosageUnit;

    @Column(name = "indefinite", nullable = false)
    private boolean indefinite;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = true)
    private LocalDate endDate;

    @Column(name = "active", nullable = false)
    private boolean active;
}
