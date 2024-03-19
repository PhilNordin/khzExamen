package com.philip.khzExamen.repositorys;

import com.philip.khzExamen.models.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Long> {
}