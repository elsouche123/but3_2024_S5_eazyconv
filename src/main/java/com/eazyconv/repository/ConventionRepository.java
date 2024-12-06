package com.eazyconv.repository;

import com.eazyconv.model.Convention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConventionRepository extends JpaRepository<Convention, Long> {
}
