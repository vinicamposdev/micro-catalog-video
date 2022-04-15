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
public class CategoryEndpoint implements ICategoryEndpoint {

    private ICreateCategoryUseCase createUseCase;
    private IFindAllCategoryUseCase findAllUseCase;
    private IFindByIdCategoryUseCase findByIdUseCase;
    private IRemoveCategoryUseCase removeUseCase;
    private IUpdateCategoryUseCase updateUseCase;

    @Override
    public CategoryOutputData create(CreateCategoryInputData input) {
        var category = createUseCase.execute(input);
        return category;
    }

    @Override
    public List<CategoryOutputData> findAll() {
        return findAllUseCase.execute();
    }

    @Override
    public CategoryOutputData findById(UUID id) {
        return findByIdUseCase.execute(id);
    }

    @Override
    public void removeById(UUID id) {
        removeUseCase.execute(id);
    }

    @Override
    public void update(UUID id, UpdateCategoryInputData input) {
        updateUseCase.execute(id, input);        
    }
}
