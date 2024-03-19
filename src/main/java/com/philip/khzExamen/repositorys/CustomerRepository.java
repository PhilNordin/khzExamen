package com.philip.khzExamen.repositorys;

import com.philip.khzExamen.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}