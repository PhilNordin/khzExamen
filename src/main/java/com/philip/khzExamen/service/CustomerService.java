package com.philip.khzExamen.service;

import com.philip.khzExamen.models.Entities.CustomerEntity;
import com.philip.khzExamen.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//    public CustomerEntity getCustomerByNameAndEmail(String name, String email) {
//        return customer.findByNameAndEmail(name, email);
//    }

    public void saveCustomer(CustomerEntity customer) {
        customerRepository.save(customer);
    }
}
