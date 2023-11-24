package com.example.pharmacyrest.Api;

import com.example.pharmacyrest.Entity.Worker;
import com.example.pharmacyrest.Service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/WorkerMain")
@RequiredArgsConstructor
public class WorkerApi {

    private final WorkerService workerService;

    @PostMapping("/create/{pharmacyId}")
    public ResponseEntity<String> createWorker(@RequestBody Worker worker, @PathVariable Long pharmacyId) {
        workerService.createWorker(worker, pharmacyId);
        return new ResponseEntity<>("Worker created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{workerId}")
    public ResponseEntity<String> deleteWorkerById(@PathVariable Long workerId) {
        workerService.deleteWorkerById(workerId);
        return new ResponseEntity<>("Worker deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{workerId}/{pharmacyId}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long workerId, @PathVariable Long pharmacyId) {
        Worker worker = workerService.getWorkerById(workerId, pharmacyId);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @PutMapping("/update/{workerId}/{pharmacyId}")
    public ResponseEntity<Worker> updateWorkerById(@PathVariable Long workerId, @RequestBody Worker newWorker,
                                                   @PathVariable Long pharmacyId) {
        Worker updatedWorker = workerService.updateWorkerById(workerId, newWorker, pharmacyId);
        return new ResponseEntity<>(updatedWorker, HttpStatus.OK);
    }

    @GetMapping("/getAllByPharmacyId/{pharmacyId}")
    public ResponseEntity<List<Worker>> getAllWorkerByPharmacyId(@PathVariable Long pharmacyId) {
        List<Worker> workerList = workerService.getAllWorkerByPharmacyId(pharmacyId);
        return new ResponseEntity<>(workerList, HttpStatus.OK);
    }

    @GetMapping("/getAllBySalaryAsc")
    public ResponseEntity<List<Worker>> getAllBySalaryAsc() {
        List<Worker> workerList = workerService.findAllByOrderBySalaryAsc();
        return new ResponseEntity<>(workerList, HttpStatus.OK);
    }

    @GetMapping("/getAllBySalaryDesc")
    public ResponseEntity<List<Worker>> getAllBySalaryDesc() {
        List<Worker> workerList = workerService.findAllByOrderBySalaryDesc();
        return new ResponseEntity<>(workerList, HttpStatus.OK);
    }
}
