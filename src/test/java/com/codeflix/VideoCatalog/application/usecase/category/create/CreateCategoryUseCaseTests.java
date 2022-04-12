package com.codeflix.VideoCatalog.application.usecase.category.create;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;
import com.codeflix.VideoCatalog.application.usecase.category.create.CreateCategoryInputData;
import com.codeflix.VideoCatalog.application.usecase.category.create.CreateCategoryUseCase;
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
public class CreateCategoryUseCaseTests {
    @InjectMocks
    private CreateCategoryUseCase useCase;
    
    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase() {
        useCase = new CreateCategoryUseCase(repository);
    }

    @Test
    @DisplayName("it should ensure category usecase returns created category")
    public void executeReturnsCreatedCategory() {
        Category category = new Category("any_name", "any_description");
        
        when(repository.create(any(Category.class)))
            .thenReturn(category);
        
        CreateCategoryInputData input = new CreateCategoryInputData(
            category.getName(),
            category.getDescription(),
            category.getIsActive()
        );
        CategoryOutputData actual = useCase.execute(input);
        repository.create(category);

        assertThat(actual.getName()).isEqualTo(category.getName());
    }
}
