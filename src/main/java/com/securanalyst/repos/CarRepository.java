package com.securanalyst.repos;

import com.securanalyst.entity.Car;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public abstract class CarRepository implements JpaRepository<Car, Long> {
    @PersistenceContext
    private final EntityManager entityManager;

    public CarRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Car mergeAndSave(Car car){
        car = entityManager.merge(car);
        return save(car);
    }
}
