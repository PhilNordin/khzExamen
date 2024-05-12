package com.philip.khzExamen.repositories;

import com.philip.khzExamen.models.Entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {
    List<CarEntity> findByBrand(String brand);

    List<CarEntity> findByModel(String model);

    List<CarEntity> findByAvailability(boolean availability);

    List<CarEntity> findByLocation(int location);

    List<CarEntity> findByYearGreaterThanEqual(int year);

    List<CarEntity> findByRentalRateLessThanEqual(float rentalRate);

    List<CarEntity> findByColor(String color);

    @Override
    List<CarEntity> findAll();
}