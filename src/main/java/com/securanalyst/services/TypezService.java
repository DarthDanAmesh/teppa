package com.securanalyst.services;

import com.securanalyst.entity.Typez;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.transaction.Transactional;
import java.util.Optional;

public interface TypezService {
    Typez save (Typez typez);
    Page<Typez> findAll(Pageable pageable);
    Optional<Typez> findOne(Long id);
    void delete(Long id);

}

