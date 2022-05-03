package com.securanalyst.services;

import com.securanalyst.entity.Car;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import java.util.Optional;

public interface CarService {
    Car save(Car car);
    Page<Car> findAll(Pageable pageable);
    Optional<Car> findOne(Long id);
    void delete(Long id);
}

