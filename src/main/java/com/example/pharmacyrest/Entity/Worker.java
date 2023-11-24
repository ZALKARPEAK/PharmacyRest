package com.example.pharmacyrest.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(generator = "company_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "company_gen",sequenceName = "company_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private int salary;
    private String address;
    private int dateOfBirth;

    @ManyToOne
    @JsonIgnore
    private Pharmacy pharmacy;
}
