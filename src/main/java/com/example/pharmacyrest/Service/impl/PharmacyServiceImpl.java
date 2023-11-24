package com.example.pharmacyrest.Service.impl;

import com.example.pharmacyrest.Entity.Medicines;
import com.example.pharmacyrest.Entity.Pharmacy;
import com.example.pharmacyrest.Repo.PharmacyRepo;
import com.example.pharmacyrest.Service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {

    private final PharmacyRepo pharmacyRepo;
    @Override
    public void createPharmacy(Pharmacy pharmacy) {
        pharmacyRepo.save(pharmacy);
    }

    @Override
    public void deletePharmacyById(Long pharmacyId) {
        pharmacyRepo.deleteById(pharmacyId);
    }

    @Override
    public Pharmacy getPharmacyById(Long pharmacyId) {
        return pharmacyRepo.findById(pharmacyId).orElseThrow(() -> new RuntimeException("Id not found " + pharmacyId));
    }

    @Override
    public Pharmacy updatePharmacyById(Long pharmacyId, Pharmacy newPharmacy) {
        Pharmacy pharmacy = pharmacyRepo.findById(pharmacyId).orElseThrow(() -> new RuntimeException("Id not found " + pharmacyId));
        pharmacy.setName(newPharmacy.getName());
        pharmacy.setAddress(newPharmacy.getAddress());
        return pharmacy;
    }

    @Override
    public List<Medicines> getAllMedicinesByPharmacyId(Long pharmacyId){
        return pharmacyRepo.getAllMedicinesByPharmacyId(pharmacyId);
    }

    @Override
    public Pharmacy getPharmacyByWorkersId(Long workerId){
        return pharmacyRepo.getPharmacyByWorkersId(workerId);
    }

}
