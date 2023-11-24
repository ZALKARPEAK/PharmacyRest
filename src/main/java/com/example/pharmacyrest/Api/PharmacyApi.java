package com.example.pharmacyrest.Api;


import com.example.pharmacyrest.Entity.Medicines;
import com.example.pharmacyrest.Entity.Pharmacy;
import com.example.pharmacyrest.Service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PharmacyMain")
@RequiredArgsConstructor
public class PharmacyApi {

    private final PharmacyService pharmacyService;

    @PostMapping("/create")
    public ResponseEntity<String> createPharmacy(@RequestBody Pharmacy pharmacy) {
        pharmacyService.createPharmacy(pharmacy);
        return new ResponseEntity<>("Pharmacy created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{pharmacyId}")
    public ResponseEntity<String> deletePharmacyById(@PathVariable Long pharmacyId) {
        pharmacyService.deletePharmacyById(pharmacyId);
        return new ResponseEntity<>("Pharmacy deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{pharmacyId}")
    public ResponseEntity<Pharmacy> getPharmacyById(@PathVariable Long pharmacyId) {
        Pharmacy pharmacy = pharmacyService.getPharmacyById(pharmacyId);
        return new ResponseEntity<>(pharmacy, HttpStatus.OK);
    }

    @PutMapping("/update/{pharmacyId}")
    public ResponseEntity<Pharmacy> updatePharmacyById(@PathVariable Long pharmacyId, @RequestBody Pharmacy newPharmacy) {
        Pharmacy updatedPharmacy = pharmacyService.updatePharmacyById(pharmacyId, newPharmacy);
        return new ResponseEntity<>(updatedPharmacy, HttpStatus.OK);
    }

    @GetMapping("/medicines/{pharmacyId}")
    public ResponseEntity<List<Medicines>> getAllMedicinesByPharmacyId(@PathVariable Long pharmacyId) {
        List<Medicines> medicinesList = pharmacyService.getAllMedicinesByPharmacyId(pharmacyId);
        return new ResponseEntity<>(medicinesList, HttpStatus.OK);
    }

    @GetMapping("/byWorker/{workerId}")
    public ResponseEntity<Pharmacy> getPharmacyByWorkersId(@PathVariable Long workerId) {
        Pharmacy pharmacy = pharmacyService.getPharmacyByWorkersId(workerId);
        return new ResponseEntity<>(pharmacy, HttpStatus.OK);
    }
}
