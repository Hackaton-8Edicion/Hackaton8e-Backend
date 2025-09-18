package hackaton8e_sanitas.group8.medication.controller;

import hackaton8e_sanitas.group8.medication.dtos.MedicationRequestDTO;
import hackaton8e_sanitas.group8.medication.dtos.MedicationResponseDTO;
import hackaton8e_sanitas.group8.medication.service.MedicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api-endpoint}/users/{userId}/medications")
@RequiredArgsConstructor
public class MedicationController {

    private final MedicationService medicationService;

    @GetMapping
    public ResponseEntity<List<MedicationResponseDTO>> getAll(@PathVariable Long userId) {
        return ResponseEntity.ok(medicationService.getAllMedicationsByUser(userId));
    }

    @GetMapping("/{medicationId}")
    public ResponseEntity<MedicationResponseDTO> getOne(
            @PathVariable Long userId,
            @PathVariable Long medicationId) {
        return ResponseEntity.ok(medicationService.getMedicationById(userId, medicationId));
    }

    @PostMapping
    public ResponseEntity<MedicationResponseDTO> create(
            @PathVariable Long userId,
            @Valid @RequestBody MedicationRequestDTO dto) {
        return new ResponseEntity<>(medicationService.createMedication(userId, dto), HttpStatus.CREATED);
    }

    @PutMapping("/{medicationId}")
    public ResponseEntity<MedicationResponseDTO> update(
            @PathVariable Long userId,
            @PathVariable Long medicationId,
            @Valid @RequestBody MedicationRequestDTO dto) {
        return ResponseEntity.ok(medicationService.updateMedication(userId, medicationId, dto));
    }

    @DeleteMapping("/{medicationId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long userId,
            @PathVariable Long medicationId) {
        medicationService.deleteMedication(userId, medicationId);
        return ResponseEntity.noContent().build();
    }
}
