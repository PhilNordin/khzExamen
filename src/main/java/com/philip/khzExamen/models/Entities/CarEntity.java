package com.philip.khzExamen.models.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CarEntity {

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
    private int location;
    private LocalDate maintenance;
    private int doors;
    private boolean terrain;
    private String type;
    private int capacity;
    private LocalDate availabilityStartDate;

    public CarEntity(LocalDate availabilityStartDate, LocalDate availabilityEndDate) {
        this.availabilityStartDate = availabilityStartDate;
        this.availabilityEndDate = availabilityEndDate;
    }

    public LocalDate getAvailabilityStartDate() {
        return availabilityStartDate;
    }

    public void setAvailabilityStartDate(LocalDate availabilityStartDate) {
        this.availabilityStartDate = availabilityStartDate;
    }

    public LocalDate getAvailabilityEndDate() {
        return availabilityEndDate;
    }

    public void setAvailabilityEndDate(LocalDate availabilityEndDate) {
        this.availabilityEndDate = availabilityEndDate;
    }

    private LocalDate availabilityEndDate;
    private String image;
    private String sideFrontImg;
    private String frontImg;

    public CarEntity(String sideFrontImg, String frontImg, String sideImg, String sideBackImg, String insideImg) {
        this.sideFrontImg = sideFrontImg;
        this.frontImg = frontImg;
        this.sideImg = sideImg;
        this.sideBackImg = sideBackImg;
        this.insideImg = insideImg;
    }

    private String sideImg;
    private String sideBackImg;

    public String getSideFrontImg() {
        return sideFrontImg;
    }

    public void setSideFrontImg(String sideFrontImg) {
        this.sideFrontImg = sideFrontImg;
    }

    public String getFrontImg() {
        return frontImg;
    }

    public void setFrontImg(String frontImg) {
        this.frontImg = frontImg;
    }

    public String getSideImg() {
        return sideImg;
    }

    public void setSideImg(String sideImg) {
        this.sideImg = sideImg;
    }

    public String getSideBackImg() {
        return sideBackImg;
    }

    public void setSideBackImg(String sideBackImg) {
        this.sideBackImg = sideBackImg;
    }

    public String getInsideImg() {
        return insideImg;
    }

    public void setInsideImg(String insideImg) {
        this.insideImg = insideImg;
    }

    private String insideImg;







    public CarEntity(String sideFrontImg, String frontImg, String sideImg, String sideBackImg, String insideImg, String image, long id, String type, int capacity, String brand, String model, String description, int seats, float mileage, int year, String color, String regNumber, boolean availability, float rentalRate, int rentalId, int location, LocalDate maintenance, int doors, boolean terrain) {
        this.id = id;
        this.capacity = capacity;
        this.type = type;
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
        this.image = image;
        this.sideFrontImg = sideFrontImg;
        this.frontImg = frontImg;
        this.sideImg = sideImg;
        this.sideBackImg = sideBackImg;
        this.insideImg = insideImg;

    }



    public CarEntity() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}