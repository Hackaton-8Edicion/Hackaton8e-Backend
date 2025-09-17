package hackaton8e_sanitas.group8.medication;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
