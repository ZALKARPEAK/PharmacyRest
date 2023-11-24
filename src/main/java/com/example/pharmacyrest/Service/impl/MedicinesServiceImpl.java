package com.example.pharmacyrest.Service.impl;

import com.example.pharmacyrest.Entity.Medicines;
import com.example.pharmacyrest.Entity.Pharmacy;
import com.example.pharmacyrest.Repo.MedicinesRepo;
import com.example.pharmacyrest.Repo.PharmacyRepo;
import com.example.pharmacyrest.Service.MedicinesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicinesServiceImpl implements MedicinesService {

    private final MedicinesRepo medicinesRepo;
    private final PharmacyRepo pharmacyRepo;

    @Override
    public void createMedicines(Medicines medicines, Long pharmacyId) {
        Pharmacy pharmacy = pharmacyRepo.findById(pharmacyId).orElseThrow(() ->
                new RuntimeException("Pharmacy not found " + pharmacyId));
        medicines.setPharmacy(pharmacy);
        medicinesRepo.save(medicines);
    }

    @Override
    public void deleteMedicinesById(Long medicinesId) {
        Medicines medicines = medicinesRepo.findById(medicinesId).orElseThrow(() ->
                new RuntimeException("Medicines not found " + medicinesId));
        medicines.setPharmacy(null);
        medicinesRepo.deleteById(medicinesId);
    }

    @Override
    public Medicines getMedicinesById(Long medicinesId, Long pharmacyId) {
        return medicinesRepo.findById(medicinesId).orElseThrow(() -> new RuntimeException("Id not found " + medicinesId));
    }

    @Override
    public Medicines updateMedicinesById(Long medicinesId, Medicines newMedicines, Long pharmacyId) {
        Medicines medicines = medicinesRepo.findById(medicinesId).orElseThrow(() ->
                new RuntimeException("Id not found " + medicinesId));
        medicines.setName(newMedicines.getName());
        medicines.setPrice(newMedicines.getPrice());
        medicinesRepo.save(medicines);
        return medicines;
    }

    @Override
    public List<Medicines> findAllByOrderByPriceAsc() {
        return null;
    }

    public List<Medicines> findAllByOrderByPriceAsc(long id){
        return medicinesRepo.findAllByPharmacyOrderByPriceAsc(id);
    }

    public List<Medicines> findAllByOrderByPriceDesc(){
        return medicinesRepo.findAllByOrderByPriceAsc();
    }
}
