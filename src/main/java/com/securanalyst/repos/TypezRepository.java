package com.securanalyst.repos;

import com.securanalyst.entity.Typez;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.model.Page;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.awt.print.Pageable;

@Repository
public abstract class TypezRepository implements JpaRepository<Typez, Long> {
    @PersistenceContext
    private final EntityManager entityManager;

    protected TypezRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    public Typez mergeAndSave(Typez typez){
        typez = entityManager.merge(typez);
        return save(typez);
    }

}
