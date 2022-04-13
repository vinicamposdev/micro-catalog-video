package com.codeflix.VideoCatalog.application.usecase.category.remove;

import java.util.UUID;

import com.codeflix.VideoCatalog.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RemoveCategoryUseCase implements IRemoveCategoryUseCase {

    private ICategoryRepository repository;

    @Override
    public void execute(UUID id) {
        repository.remove(id);        
    }
}
