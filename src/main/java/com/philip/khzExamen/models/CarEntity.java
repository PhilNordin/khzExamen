package com.philip.khzExamen.models;

import com.philip.khzExamen.repositories.CarRepository;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
public class CarEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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
    private int location; // Give each location a number (Stockholm 1, Malmö 2, Gothenburg 3, Umeå 4)
    private LocalDate maintenance;
    private int doors;
    private boolean terrain;


    public CarEntity(long id, String brand, String model, String description, int seats, float mileage, int year, String color, String regNumber, boolean availability, float rentalRate, int rentalId, int location, LocalDate maintenance, int doors, boolean terrain) {
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
        this.doors = doors;
        this.terrain = terrain;
    }

    public CarEntity(){

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
// Constructors, getters, setters, and other methods

    
}
