package com.securanalyst.services;

import com.securanalyst.entity.Visits;
import com.securanalyst.repos.VisitsRepository;
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
public class VisitServiceImp implements VisitService {

    private final Logger log = LoggerFactory.getLogger(VisitServiceImp.class);

    private final VisitsRepository visitsRepository;

    public VisitServiceImp(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }
    @Override
    public Visits save(Visits visits) {
        log.debug("Request to save; {}", visits);
        return visitsRepository.mergeAndSave(visits);
    }
    @Override
    @ReadOnly
    @Transactional
    public Page<Visits> findAll(Pageable pageable) {
        log.debug("Request to find all Visits ");
        return visitsRepository.findAll(pageable);
    }

    @Override
    public Optional<Visits> findOne(Long id) {
        log.debug("Request to find Visit: {}", id);
        return visitsRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete: {}", id);
    }
}
