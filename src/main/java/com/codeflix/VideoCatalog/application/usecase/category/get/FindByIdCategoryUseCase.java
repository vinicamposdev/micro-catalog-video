package com.codeflix.VideoCatalog.application.usecase.category.get;

import java.util.UUID;

import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;
import com.codeflix.VideoCatalog.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindByIdCategoryUseCase implements IFindByIdCategoryUseCase {
    
    private ICategoryRepository repository;

    @Override
    public CategoryOutputData execute(UUID id) throws Exception {
        return repository.findById(id)
            .map(CategoryOutputData::fromDomain)
            .orElseThrow(() -> new Exception("Category not found"));
    }
}
