package com.eazyconv.service;

import com.eazyconv.model.Convention;
import com.eazyconv.repository.ConventionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConventionService {

    private final ConventionRepository conventionRepository;

    public ConventionService(ConventionRepository conventionRepository) {
        this.conventionRepository = conventionRepository;
    }

    public Convention saveConvention(Convention convention) {
        return conventionRepository.save(convention);
    }

    public List<Convention> getAllConventions() {
        return conventionRepository.findAll();
    }
}
