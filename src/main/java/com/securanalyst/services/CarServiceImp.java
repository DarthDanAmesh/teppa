package com.securanalyst.services;

import com.securanalyst.entity.Car;
import com.securanalyst.repos.CarRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.Optional;

@Singleton
@Transactional

public class CarServiceImp implements CarService {
    private final Logger log = LoggerFactory.getLogger(CarServiceImp.class);
    private final CarRepository carRepository;


    public CarServiceImp(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        log.debug("Request to save Car : {}", car);
        return carRepository.mergeAndSave(car);
    }

    @Transactional
    @ReadOnly
    @Override
    public Page<Car> findAll(Pageable pageable) {
        log.debug("Request to find Car: ");
        return carRepository.findAll(pageable);
    }

    @Override
    public Optional<Car> findOne(Long id) {
        log.debug("Request to find car: {}", id);
        return carRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete car: {} ", id);
        carRepository.deleteById(id);
    }
}
