package com.codeflix.VideoCatalog.application.usecase.category.remove;

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
public class RemoveCategoryUseCaseTests {
    @InjectMocks
    private RemoveCategoryUseCase useCase;
    
    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase() {
        useCase = new RemoveCategoryUseCase(repository);
    }

    @Test
    @DisplayName("it should ensure category remove usecase put a end to a category on returns")
    public void executeReturnsRemove() {
        Category category = new Category("any_name", "any_description");
        
        doNothing()
            .when(repository)
            .remove(category.getId());
        
        useCase.execute(category.getId());
        repository.remove(category.getId());

        assertThat(category).isNotNull();
        verify(repository, times(2)).remove(category.getId());
    }
}
