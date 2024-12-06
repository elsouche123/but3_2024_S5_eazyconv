package com.eazyconv.controller;

import com.eazyconv.model.ModelFile;
import com.eazyconv.service.ModelFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class ModelFileController {

    private final ModelFileService modelFileService;

    public ModelFileController(ModelFileService modelFileService) {
        this.modelFileService = modelFileService;
    }

    // Endpoint pour uploader un fichier
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            modelFileService.saveFile(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Could not upload file: " + e.getMessage());
        }
    }

    // Endpoint pour récupérer un fichier
    @GetMapping("/{id}")
    public ResponseEntity<ModelFile> getFile(@PathVariable Long id) {
        return modelFileService.getFile(id)
                .map(file -> ResponseEntity.ok(file))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }
}
