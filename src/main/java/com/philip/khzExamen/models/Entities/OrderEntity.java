package com.philip.khzExamen.models.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity user;

    private LocalDate startDate;
    private LocalDate endDate;
    private float totalPrice;
    private boolean active;

    // Default
    public OrderEntity() {}

    public OrderEntity(CarEntity car, CustomerEntity customer, UserEntity user, LocalDate startDate, LocalDate endDate, float totalPrice, boolean active) {
        this.car = car;
        this.customer = customer;
        this.user = user;
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

    public OrderEntity(long id, CarEntity car, CustomerEntity customer, UserEntity user, LocalDate startDate, LocalDate endDate, float totalPrice, boolean active) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.active = active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }




}