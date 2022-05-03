package com.securanalyst.repos;

import com.securanalyst.entity.Visits;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public abstract class VisitsRepository implements JpaRepository <Visits, Long> {
    @PersistenceContext
    private final EntityManager entityManager;

    public VisitsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    public Visits mergeAndSave(Visits visits){
        visits = entityManager.merge(visits);
        return save(visits);
    }
}
