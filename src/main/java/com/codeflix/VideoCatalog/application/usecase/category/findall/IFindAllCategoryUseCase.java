package com.codeflix.VideoCatalog.application.usecase.category.findall;

import java.util.List;

import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;

public interface IFindAllCategoryUseCase {
    List<CategoryOutputData> execute();
}
