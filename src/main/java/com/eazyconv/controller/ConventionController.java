package com.eazyconv.controller;

import com.eazyconv.model.Convention;
import com.eazyconv.service.ConventionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conventions")
public class ConventionController {

    private final ConventionService conventionService;

    public ConventionController(ConventionService conventionService) {
        this.conventionService = conventionService;
    }

    @PostMapping
    public ResponseEntity<Convention> createConvention(@RequestBody Convention convention) {
        return ResponseEntity.ok(conventionService.saveConvention(convention));
    }

    @GetMapping
    public ResponseEntity<List<Convention>> getAllConventions() {
        return ResponseEntity.ok(conventionService.getAllConventions());
    }
}
