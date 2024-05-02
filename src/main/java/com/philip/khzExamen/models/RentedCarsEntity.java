package com.philip.khzExamen.models;

import jakarta.persistence.*;

@Entity
@Table(name ="rentedCars")
public class RentedCarsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn (name = "cars_id")
    private CarsEntity cars;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private RentedCarsEntity rental;


}
