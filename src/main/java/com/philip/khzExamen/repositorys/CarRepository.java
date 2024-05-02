package com.philip.khzExamen.repositorys;

import com.philip.khzExamen.models.CarsEntity;
import com.philip.khzExamen.service.CarsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarsEntity,Long> {
    CarsEntity findById(long id);
    CarsEntity findByBrand(String brand);
    CarsEntity findByAvailability(boolean available);
    List<CarsEntity> findAll();
}