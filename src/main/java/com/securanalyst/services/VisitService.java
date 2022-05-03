package com.securanalyst.services;

import com.securanalyst.entity.Visits;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import java.util.Optional;

public interface VisitService {
    Visits save(Visits visits);
    Page<Visits> findAll(Pageable pageable);
    Optional<Visits> findOne(Long id);
    void delete(Long id);
}

