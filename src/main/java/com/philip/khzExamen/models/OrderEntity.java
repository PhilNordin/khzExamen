package com.philip.khzExamen.models;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @ManyToOne
    @JoinColumn(name = "order_id")
    private CarEntity car;

    private LocalDate startDate;
    private LocalDate endDate;
    private float totalPrice;
    private boolean active;

    // Constructors, getters, setters, and other methods

    public OrderEntity(long id) {
        this.id = id;
    }

    public OrderEntity(long id, OrderEntity order, CarEntity car, LocalDate startDate, LocalDate endDate, float totalPrice, boolean active) {
        this.car = car;
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.active = active;
    }

    // Getters and setters

    public OrderEntity(long id, CarEntity car, LocalDate startDate, LocalDate endDate, float totalPrice, boolean active) {
        this.id = id;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}