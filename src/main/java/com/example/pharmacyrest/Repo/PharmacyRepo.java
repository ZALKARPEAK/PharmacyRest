package com.example.pharmacyrest.Repo;


import com.example.pharmacyrest.Entity.Medicines;
import com.example.pharmacyrest.Entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Long> {

    Pharmacy getPharmacyByWorkersId(Long workerId);
    @Query("select m from Medicines m WHERE m.pharmacy.id = :pharmacyId")
    List<Medicines> getAllMedicinesByPharmacyId(@Param("pharmacyId") Long pharmacyId);
}
