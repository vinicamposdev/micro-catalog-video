package com.codeflix.VideoCatalog.application.usecase.category.update;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

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
public class UpdateCategoryUseCaseTests {
    @InjectMocks
    private UpdateCategoryUseCase useCase;
    
    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase() {
        useCase = new UpdateCategoryUseCase(repository);
    }

    @Test
    @DisplayName("it should ensure category update usecase updates a category on returns")
    public void executeReturnsUpdatedCategory() {
        Category category = new Category("any_name_1", "any_description_1");
        Category expected = new Category("any_name_2", "any_description_2");
        Optional<Category> opCategory = Optional.of(category);
        when(repository.findById(category.getId()))
            .thenReturn(opCategory);
        UpdateCategoryInputData input = new UpdateCategoryInputData();
        input.setName(expected.getName());
        input.setDescription(expected.getDescription());
        input.setIsActive(expected.getIsActive());
        category.update(
            input.getName(), 
            input.getDescription(), 
            input.getIsActive()
        );
        doNothing()
            .when(repository)
            .update(category);

        useCase.execute(category.getId(), input);

        assertThat(category).isNotNull();
        assertThat(expected).isNotNull();
        assertThat(category.getName()).isEqualTo(expected.getName());
    }
}
