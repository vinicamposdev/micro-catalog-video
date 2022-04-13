package com.codeflix.VideoCatalog.application.usecase.category.update;

import com.codeflix.VideoCatalog.domain.entity.Category;
import com.codeflix.VideoCatalog.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateCategoryUseCase implements IUpdateCategoryUseCase {

    private ICategoryRepository repository;

    @Override
    public void execute(Category category) {
        repository.update(category);        
    }
}
