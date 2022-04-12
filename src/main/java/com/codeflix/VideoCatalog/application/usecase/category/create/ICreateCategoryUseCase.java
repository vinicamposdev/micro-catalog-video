package com.codeflix.VideoCatalog.application.usecase.category.create;

import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;

public interface ICreateCategoryUseCase {
    CategoryOutputData execute(CreateCategoryInputData input);
}
