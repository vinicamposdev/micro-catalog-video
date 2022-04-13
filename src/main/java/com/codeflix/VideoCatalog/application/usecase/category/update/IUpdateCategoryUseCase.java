package com.codeflix.VideoCatalog.application.usecase.category.update;

import com.codeflix.VideoCatalog.domain.entity.Category;

public interface IUpdateCategoryUseCase {
    void execute(Category category);
}
