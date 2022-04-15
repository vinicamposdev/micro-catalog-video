package com.codeflix.VideoCatalog.api.category;

import java.util.List;
import java.util.UUID;

import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;
import com.codeflix.VideoCatalog.application.usecase.category.create.CreateCategoryInputData;
import com.codeflix.VideoCatalog.application.usecase.category.create.ICreateCategoryUseCase;
import com.codeflix.VideoCatalog.application.usecase.category.findall.IFindAllCategoryUseCase;
import com.codeflix.VideoCatalog.application.usecase.category.get.IFindByIdCategoryUseCase;
import com.codeflix.VideoCatalog.application.usecase.category.remove.IRemoveCategoryUseCase;
import com.codeflix.VideoCatalog.application.usecase.category.update.IUpdateCategoryUseCase;
import com.codeflix.VideoCatalog.application.usecase.category.update.UpdateCategoryInputData;

public class CategoryEndpoint implements ICategoryEndpoint{
    private ICreateCategoryUseCase createCategoryUseCase;
    private IUpdateCategoryUseCase updateCategoryUseCase;
    private IRemoveCategoryUseCase deleteCategoryUseCase;
    private IFindAllCategoryUseCase findAllCategoryUseCase;
    private IFindByIdCategoryUseCase findCategoryByIdUseCase;

    @Override
    public CategoryOutputData create(CreateCategoryInputData input) {
        return createCategoryUseCase.execute(input);
    }

    @Override
    public List<CategoryOutputData> findAll() {
        return findAllCategoryUseCase.execute();
    }

    @Override
    public CategoryOutputData findById(UUID id) {
        return findCategoryByIdUseCase.execute(id);
    }

    @Override
    public void delete(UUID id) {
        deleteCategoryUseCase.execute(id);
    }

    @Override
    public void update(UUID id, UpdateCategoryInputData input) {
        updateCategoryUseCase.execute(id, input);
    }
    
}
