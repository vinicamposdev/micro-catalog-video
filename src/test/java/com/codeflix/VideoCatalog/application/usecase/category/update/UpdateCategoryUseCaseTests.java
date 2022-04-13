package com.codeflix.VideoCatalog.application.usecase.category.update;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        Category category = new Category("any_name", "any_description");
        
        doNothing()
            .when(repository)
            .remove(category.getId());
        
        useCase.execute(category);
        repository.update(category);

        assertThat(category).isNotNull();
        verify(repository, times(2)).update(category);
    }
}
