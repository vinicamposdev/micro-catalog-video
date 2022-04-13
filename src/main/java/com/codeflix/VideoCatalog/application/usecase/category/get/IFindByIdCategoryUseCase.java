package com.codeflix.VideoCatalog.application.usecase.category.get;

import java.util.UUID;

import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;


public interface IFindByIdCategoryUseCase {
    CategoryOutputData execute(UUID id);
}
