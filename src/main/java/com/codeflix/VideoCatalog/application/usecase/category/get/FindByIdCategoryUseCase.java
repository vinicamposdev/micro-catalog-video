package com.codeflix.VideoCatalog.application.usecase.category.get;

import java.util.UUID;

import com.codeflix.VideoCatalog.application.exception.NotFoundException;
import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;
import com.codeflix.VideoCatalog.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindByIdCategoryUseCase implements IFindByIdCategoryUseCase {
    
    private ICategoryRepository repository;

    @Override
    public CategoryOutputData execute(UUID id) {
        return repository.findById(id)
            .map(CategoryOutputData::fromDomain)
            .orElseThrow(() -> new NotFoundException("Category not found"));
    }
}
