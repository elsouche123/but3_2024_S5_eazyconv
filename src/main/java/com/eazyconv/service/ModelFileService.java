package com.eazyconv.service;

import com.eazyconv.model.ModelFile;
import com.eazyconv.repository.ModelFileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelFileService {
    private final ModelFileRepository repository;

    public ModelFileService(ModelFileRepository repository) {
        this.repository = repository;
    }

    public ModelFile saveFile(String name, String type, byte[] data) {
        ModelFile file = new ModelFile();
        file.setName(name);
        file.setType(type);
        file.setData(data);
        return repository.save(file);
    }

    public Optional<ModelFile> getFile(Long id) {
        return repository.findById(id);
    }
}
