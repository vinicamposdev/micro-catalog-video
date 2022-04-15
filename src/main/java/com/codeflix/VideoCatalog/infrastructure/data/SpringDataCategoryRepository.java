package com.codeflix.VideoCatalog.infrastructure.data;

import java.util.UUID;

import com.codeflix.VideoCatalog.infrastructure.persistence.CategoryPersistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCategoryRepository extends JpaRepository<CategoryPersistence, UUID>{
    
}
