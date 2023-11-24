package com.example.pharmacyrest.Repo;

import com.example.pharmacyrest.Entity.Medicines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicinesRepo extends JpaRepository<Medicines, Long> {
    List<Medicines> findAllByOrderByPriceAsc();

    @Query("select m from Medicines m join m.pharmacy p where p.id = :id order by m.price asc")
    List<Medicines> findAllByPharmacyOrderByPriceAsc(@Param("id") long id);

}
