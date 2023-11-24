package com.example.pharmacyrest.Service;

import com.example.pharmacyrest.Entity.Worker;

import java.util.List;

public interface WorkerService {
    void createWorker(Worker worker, Long pharmacyId);
    void deleteWorkerById(Long workerId);
    Worker getWorkerById(Long workerId, Long pharmacyId);
    Worker updateWorkerById(Long workerId, Worker newWorker, Long pharmacyId);
    List<Worker> getAllWorkerByPharmacyId(Long pharmacyId);
    List<Worker> findAllByOrderBySalaryAsc();
    List<Worker> findAllByOrderBySalaryDesc();
}
