package com.securanalyst.services;

import com.securanalyst.entity.Owner;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import java.util.Optional;

public interface OwnerService {
    Owner save(Owner owner);
    Page<Owner> findAll(Pageable pageable);
    Optional<Owner> findOne(Long id);
    void delete (Long id);
}

