package hackaton8e_sanitas.group8.medication.controller;

import hackaton8e_sanitas.group8.medication.MedicationEntity;
import hackaton8e_sanitas.group8.medication.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medications")
@RequiredArgsConstructor
public class MedicationController {

    private final MedicationService medicationService;

    @PostMapping
    public ResponseEntity<MedicationEntity> createMedication(@RequestBody MedicationEntity medication) {
        MedicationEntity savedMedication = medicationService.saveMedication(medication);
        return new ResponseEntity<>(savedMedication, HttpStatus.CREATED);
    }
}
