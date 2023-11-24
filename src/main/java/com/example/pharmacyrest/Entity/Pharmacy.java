package com.example.pharmacyrest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacy {
    @Id
    @GeneratedValue(generator = "pharmacy_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "pharmacy_gen",sequenceName = "pharmacy_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "pharmacy")
    private List<Medicines> medicines;
    @OneToMany(mappedBy = "pharmacy")
    private List<Worker> workers;
}
