package com.codeflix.VideoCatalog.application.usecase.category.findall;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

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
public class FindAllCategoryUseCaseTests {
    @InjectMocks
    private FindAllCategoryUseCase useCase;
    
    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase() {
        useCase = new FindAllCategoryUseCase(repository);
    }

    @Test
    @DisplayName("it should ensure category usecase returns all finded categories")
    public void executeReturnsFindAllCategory() {
        List<Category> categories = Arrays.asList(
            new Category("any_name_1", "any_description_1"),
            new Category("any_name_2", "any_description_2"),
            new Category("any_name_3", "any_description_3")
        );
        when(repository.findAll())
            .thenReturn(categories);
        // Another way to do that:
        // doReturn(categories)
        //     .when(repository)
        //     .findAll();

        List<CategoryOutputData> actual = useCase.execute();
        repository.findAll();

        assertThat(categories).isNotNull();
        assertThat(categories).hasSize(3);
        assertThat(actual).isNotNull();
        assertThat(actual).hasSize(3);
    }
}
