package com.philip.khzExamen.models.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer_entity")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id")
    private OrderEntity order;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;




    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column (name = "personal_number")
    private String personalNumber;
    @Column(name = "gender")
    private String gender;


    @Column (name = "address")
    private String address;

    public CustomerEntity(){

    }



    public CustomerEntity(OrderEntity order, Long id, String firstName, String lastName, String phoneNumber, String personalNumber, String gender, String address) {
        this.order = order;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.personalNumber = personalNumber;
        this.gender = gender;
        this.address = address;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public Long getCustomerId() {
        return id;
    }

    public void setCustomerId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}