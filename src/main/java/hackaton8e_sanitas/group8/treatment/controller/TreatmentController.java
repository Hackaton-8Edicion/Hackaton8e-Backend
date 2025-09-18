package hackaton8e_sanitas.group8.treatment.controller;

import hackaton8e_sanitas.group8.treatment.dtos.TreatmentRequestDTO;
import hackaton8e_sanitas.group8.treatment.dtos.TreatmentResponseDTO;
import hackaton8e_sanitas.group8.treatment.service.TreatmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api-endpoint}/treatments")
public class TreatmentController {

    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TreatmentResponseDTO>> getAllTreatmentsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(treatmentService.getAllTreatmentsByUser(userId));
    }

    @GetMapping("/{treatmentId}")
    public ResponseEntity<TreatmentResponseDTO> getTreatmentById(@PathVariable Long treatmentId) {
        return ResponseEntity.ok(treatmentService.getTreatmentById(treatmentId));
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<TreatmentResponseDTO> createTreatment(@RequestBody TreatmentRequestDTO treatmentDto, @PathVariable Long userId) {
        return ResponseEntity.ok(treatmentService.createTreatment(treatmentDto, userId));
    }

    @PutMapping("/{treatmentId}")
    public ResponseEntity<TreatmentResponseDTO> updateTreatment(@PathVariable Long treatmentId, @RequestBody TreatmentRequestDTO treatmentDto) {
        return ResponseEntity.ok(treatmentService.updateTreatment(treatmentId, treatmentDto));
    }

    @DeleteMapping("/{treatmentId}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable Long treatmentId) {
        treatmentService.deleteTreatment(treatmentId);
        return ResponseEntity.noContent().build();
    }
}
