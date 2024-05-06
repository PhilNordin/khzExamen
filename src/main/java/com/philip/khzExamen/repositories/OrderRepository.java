package com.philip.khzExamen.repositories;

import com.philip.khzExamen.models.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}

