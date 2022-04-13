package com.codeflix.VideoCatalog.application.usecase.category.findall;

import java.util.List;
import java.util.stream.Collectors;

import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;
import com.codeflix.VideoCatalog.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindAllCategoryUseCase implements IFindAllCategoryUseCase {
    private ICategoryRepository repository;

    @Override
    public List<CategoryOutputData> execute() {
        var list = repository.findAll();
        return list.stream()
            .map(c -> CategoryOutputData.fromDomain(c))
            .collect(Collectors.toList());
    }
}
