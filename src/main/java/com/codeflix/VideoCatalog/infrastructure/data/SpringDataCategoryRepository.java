package com.codeflix.VideoCatalog.infrastructure.data;

import java.util.UUID;

import com.codeflix.VideoCatalog.infrastructure.persistence.CategoryPersistence;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataCategoryRepository extends CrudRepository<CategoryPersistence, UUID>{
    
}
