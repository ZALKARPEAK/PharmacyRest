package com.example.pharmacyrest.Service;

import com.example.pharmacyrest.Entity.Medicines;
import com.example.pharmacyrest.Entity.Pharmacy;

import java.util.List;

public interface PharmacyService {
    void createPharmacy(Pharmacy pharmacy);
    void deletePharmacyById(Long pharmacyId);
    Pharmacy getPharmacyById(Long pharmacyId);
    Pharmacy updatePharmacyById(Long pharmacyId, Pharmacy newPharmacy);
    List<Medicines> getAllMedicinesByPharmacyId(/*@Param("pharmacyId") */Long pharmacyId);
    Pharmacy getPharmacyByWorkersId(Long workerId);
}
