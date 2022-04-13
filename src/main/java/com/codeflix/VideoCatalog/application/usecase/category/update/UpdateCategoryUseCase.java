package com.codeflix.VideoCatalog.application.usecase.category.update;

import java.util.UUID;

import com.codeflix.VideoCatalog.application.exception.NotFoundException;
import com.codeflix.VideoCatalog.domain.entity.Category;
import com.codeflix.VideoCatalog.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateCategoryUseCase implements IUpdateCategoryUseCase {

    private ICategoryRepository repository;

    @Override
    public void execute(UUID id, UpdateCategoryInputData input) {
        Category category = repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Category not found"));
        category.update(
            input.getName(),
            input.getDescription(),
            input.getIsActive()
        );
        repository.update(category);        
    }
}
