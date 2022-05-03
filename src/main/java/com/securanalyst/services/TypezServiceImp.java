package com.securanalyst.services;

import com.securanalyst.entity.Typez;
import com.securanalyst.repos.TypezRepository;
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
public class TypezServiceImp implements TypezService {

    private final Logger log = LoggerFactory.getLogger(TypezServiceImp.class);

    private final TypezRepository typezRepository;

    public TypezServiceImp(TypezRepository typezRepository) {
        this.typezRepository = typezRepository;
    }

    @Override
    public Typez save(Typez typez) {
        log.debug("Request to save Type: {}", typez);
        return typezRepository.mergeAndSave(typez);
    }

    @Override
    @ReadOnly
    @Transactional
    public Page<Typez> findAll(Pageable pageable) {
        log.debug("Request to retreive Types: ");
        return typezRepository.findAll(pageable);
    }

    @Override
    public Optional<Typez> findOne(Long id) {
        log.debug("Find Type: {}", id);
        return typezRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete Request for: {}", id);
    }
}