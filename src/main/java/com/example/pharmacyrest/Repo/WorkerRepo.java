package com.example.pharmacyrest.Repo;

import com.example.pharmacyrest.Entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepo extends JpaRepository<Worker, Long> {
    List<Worker> getAllWorkerByPharmacyId(Long pharmacyId);
    List<Worker> findAllByOrderBySalaryAsc();
    List<Worker> findAllByOrderBySalaryDesc();
}
