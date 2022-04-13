package com.codeflix.VideoCatalog.application.usecase.category.get;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;
import com.codeflix.VideoCatalog.domain.entity.Category;
import com.codeflix.VideoCatalog.domain.repository.ICategoryRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class FindByIdCategoryUseCaseTests {
    @InjectMocks
    private FindByIdCategoryUseCase useCase;
    
    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase() {
        useCase = new FindByIdCategoryUseCase(repository);
    }

    @Test
    @DisplayName("it should ensure FindByIdCategoryUsecase returns a category for a given id")
    public void executeReturnsFindAllCategory() {
        Category category = new Category("any_name_1", "any_description_1");
        Optional<Category> opCategory = Optional.of(category);
        when(repository.findById(category.getId()))
            .thenReturn(opCategory);
        // Another way to do that:
        // doReturn(opCategory)
        //     .when(category)
        //     .findById(category.getId());

        CategoryOutputData actual = useCase.execute(category.getId());
        repository.findById(category.getId());

        assertThat(category).isNotNull();
        assertThat(actual).isNotNull();
    }
}
