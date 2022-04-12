package com.codeflix.VideoCatalog.application.usecase.category.create;

import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;
import com.codeflix.VideoCatalog.domain.repository.ICategoryRepository;
import com.codeflix.VideoCatalog.domain.entity.Category;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateCategoryUseCase implements ICreateCategoryUseCase {
    
    private ICategoryRepository repository;
    
    @Override
    public CategoryOutputData execute(CreateCategoryInputData input) {
        var created = repository.create(toDomain(input));
        return CategoryOutputData.fromDomain(created);
    }

    private Category toDomain(CreateCategoryInputData input) {
        return new Category(
            input.getName(),
            input.getDescription(),
            input.getIsActive()
        );
    }
}
