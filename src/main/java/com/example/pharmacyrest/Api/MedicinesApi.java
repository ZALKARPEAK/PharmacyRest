package com.example.pharmacyrest.Api;

import com.example.pharmacyrest.Entity.Medicines;
import com.example.pharmacyrest.Service.MedicinesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MedicinesMain/{pharmacyId}")
@RequiredArgsConstructor
public class MedicinesApi {

    private final MedicinesService medicinesService;

    @PostMapping("/create")
    public ResponseEntity<String> createMedicines(@RequestBody Medicines medicines, @PathVariable("pharmacyId") Long pharmacyId) {
        medicinesService.createMedicines(medicines, pharmacyId);
        return new ResponseEntity<>("Medicines created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{medicinesId}")
    public ResponseEntity<String> deleteMedicinesById(@PathVariable Long medicinesId) {
        medicinesService.deleteMedicinesById(medicinesId);
        return new ResponseEntity<>("Medicines deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{medicinesId}")
    public ResponseEntity<Medicines> getMedicinesById(@PathVariable Long medicinesId,  @PathVariable("pharmacyId") Long pharmacyId) {
        Medicines medicines = medicinesService.getMedicinesById(medicinesId, pharmacyId);
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @PutMapping("/update/{medicinesId}")
    public ResponseEntity<Medicines> updateMedicinesById(@PathVariable Long medicinesId,
                                                         @RequestBody Medicines newMedicines,
                                                         @PathVariable("pharmacyId") Long pharmacyId) {
        Medicines updatedMedicines = medicinesService.updateMedicinesById(medicinesId, newMedicines, pharmacyId);
        return new ResponseEntity<>(updatedMedicines, HttpStatus.OK);
    }

    @GetMapping("/getAllByPriceAsc")
    public ResponseEntity<List<Medicines>> getAllByPriceAsc(@PathVariable long pharmacyId) {
        List<Medicines> medicinesList = medicinesService.findAllByOrderByPriceAsc(pharmacyId);
        return new ResponseEntity<>(medicinesList, HttpStatus.OK);
    }

    @GetMapping("/getAllByPriceDesc")
    public ResponseEntity<List<Medicines>> getAllByPriceDesc(@PathVariable String pharmacyId) {
        List<Medicines> medicinesList = medicinesService.findAllByOrderByPriceDesc();
        return new ResponseEntity<>(medicinesList, HttpStatus.OK);
    }
}
