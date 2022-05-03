package com.securanalyst.services;

import com.securanalyst.entity.Owner;
import com.securanalyst.repos.OwnerRepository;
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
public class OwnerServiceImpl implements OwnerService {

    private final Logger log = LoggerFactory.getLogger(OwnerServiceImpl.class);
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner save(Owner owner) {
        log.debug("Request to save Owner : {}", owner);
        return ownerRepository.mergeAndSave(owner);
    }

    @Override
    @ReadOnly
    @Transactional
    public Page<Owner> findAll(Pageable pageable) {
        log.debug("Request to get all Owners");
        return ownerRepository.findAll(pageable);
    }

    @Override
    public Optional<Owner> findOne(Long id) {
        log.debug("Request to find Owner : {}", id);
        return ownerRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
    log.debug("Request to delete Owner: {} ", id);
    ownerRepository.deleteById(id);
    }
}
