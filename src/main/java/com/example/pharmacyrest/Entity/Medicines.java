package com.example.pharmacyrest.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicines {
    @Id
    @GeneratedValue(generator = "medicines_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "medicines_gen",sequenceName = "medicines_seq",allocationSize = 1)
    private Long id;
    private String name;
    @PositiveOrZero
    private int price;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    private Pharmacy pharmacy;
}
