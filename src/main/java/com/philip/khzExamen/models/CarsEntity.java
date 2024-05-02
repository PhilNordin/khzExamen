package com.philip.khzExamen.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class CarsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    private String description;
    private int seats;
    private float mileage;
    private int year;
    private String color;
    private String regNumber;
    private boolean availability;
    private float rentalRate;
    private int rentalId;
    private int location; // ge varje location ett nummer ( sthlm 1, malmö 2, GBG 3, Umeå 4)
    private LocalDate maintenance;
    private int doors;
    private boolean terrain;


    public CarsEntity
            (long id, String brand, String model, String description, int seats,
             float mileage, int year, String color, String regNumber, boolean availability,
             float rentalRate, int rentalId, int location, LocalDate maintenance, CarsEntity car,
             int doors, boolean terrain ) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.seats = seats;
        this.mileage = mileage;
        this.year = year;
        this.color = color;
        this.regNumber = regNumber;
        this.availability = availability;
        this.rentalRate = rentalRate;
        this.rentalId = rentalId;
        this.location = location;
        this.maintenance = maintenance;
        this.car = car;
        this.doors = doors;
        this.terrain = terrain;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public LocalDate getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(LocalDate maintenance) {
        this.maintenance = maintenance;
    }

    public CarsEntity getCar() {
        return car;
    }

    public void setCar(CarsEntity car) {
        this.car = car;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isTerrain() {
        return terrain;
    }

    public void setTerrain(boolean terrain) {
        this.terrain = terrain;
    }

    @ManyToOne()
    @JoinColumn(name = "cars_id")
    private CarsEntity car;

    public CarsEntity() {}

}
