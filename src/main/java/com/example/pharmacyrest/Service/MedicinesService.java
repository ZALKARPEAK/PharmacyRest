package com.example.pharmacyrest.Service;

import com.example.pharmacyrest.Entity.Medicines;

import java.util.List;

public interface MedicinesService {
    void createMedicines(Medicines medicines, Long pharmacyId);

    void deleteMedicinesById(Long medicinesId);

    Medicines getMedicinesById(Long medicinesId, Long pharmacyId);

    Medicines updateMedicinesById(Long medicinesId, Medicines newMedicines, Long pharmacyId);

    List<Medicines> findAllByOrderByPriceAsc();

    List<Medicines> findAllByOrderByPriceDesc();
    List<Medicines> findAllByOrderByPriceAsc(long id);
}
