package com.philip.khzExamen.repositories;

import com.philip.khzExamen.models.Entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {



    List<CarEntity> findByBrand(String brand);
    List<CarEntity> findById(long id);


    List<CarEntity> findByModel(String model);

    List<CarEntity> findByAvailability(boolean availability);

    List<CarEntity> findByLocation(int location);


    List<CarEntity> findByColor(String color);
    List<CarEntity> findByType(String type);
    List<CarEntity> findByCapacity(CarEntity capacity);


    /*
    List<CarEntity> sortByCapacity(int capacity);

     */




    @Override
    List<CarEntity> findAll();
}