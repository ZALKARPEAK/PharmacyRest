package com.example.pharmacyrest.Service.impl;

import com.example.pharmacyrest.Entity.Pharmacy;
import com.example.pharmacyrest.Entity.Worker;
import com.example.pharmacyrest.Repo.PharmacyRepo;
import com.example.pharmacyrest.Repo.WorkerRepo;
import com.example.pharmacyrest.Service.WorkerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepo workerRepo;
    private final PharmacyRepo pharmacyRepo;

    @Override
    public void createWorker(Worker worker, Long pharmacyId){
        Pharmacy pharmacy = pharmacyRepo.findById(pharmacyId).orElseThrow(EntityNotFoundException::new);
        worker.setPharmacy(pharmacy);
        workerRepo.save(worker);
    }

    @Override
    public void deleteWorkerById(Long workerId) {
        Worker worker = workerRepo.findById(workerId).orElseThrow(EntityNotFoundException::new);
        worker.setPharmacy(null);
        workerRepo.deleteById(workerId);
    }

    @Override
    public Worker getWorkerById(Long workerId, Long pharmacyId) {
        return workerRepo.findById(workerId).orElseThrow(() -> new RuntimeException("Id not found " + workerId));
    }

    @Override
    public Worker updateWorkerById(Long workerId, Worker newWorker, Long pharmacyId) {
        Worker worker = workerRepo.findById(workerId).orElseThrow(() -> new RuntimeException("Id not found " + workerId));
        worker.setName(newWorker.getName());
        worker.setAddress(newWorker.getAddress());
        worker.setEmail(newWorker.getEmail());
        worker.setSalary(newWorker.getSalary());
        worker.setDateOfBirth(newWorker.getDateOfBirth());
        return worker;
    }

    @Override
    public List<Worker> getAllWorkerByPharmacyId(Long pharmacyId) {
        return workerRepo.getAllWorkerByPharmacyId(pharmacyId);
    }

    @Override
    public List<Worker> findAllByOrderBySalaryAsc() {
        return workerRepo.findAllByOrderBySalaryAsc();
    }

    @Override
    public List<Worker> findAllByOrderBySalaryDesc() {
        return workerRepo.findAllByOrderBySalaryDesc();
    }
}
