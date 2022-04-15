package com.codeflix.VideoCatalog.infrastructure.mysql;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import com.codeflix.VideoCatalog.domain.entity.Category;
import com.codeflix.VideoCatalog.infrastructure.data.SpringDataCategoryRepository;
import com.codeflix.VideoCatalog.infrastructure.persistence.CategoryPersistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class MySQLCategoryRepositoryImplTests {
    @InjectMocks
    private MySQLCategoryRepositoryImpl repository;
    
    @Mock
    private SpringDataCategoryRepository springDataCategoryRepository;

    @Test
    @DisplayName("it should ensure MySQLCategoryRepositoryImpl returns created category")
    public void executeReturnsCreatedCategory() {
        Category expected = new Category("any_name", "any_description");
        Category input = new Category("any_name", "any_description");
        
        doReturn(CategoryPersistence.from(expected))
            .when(springDataCategoryRepository)
            .save(any(CategoryPersistence.class));
        
        Category actual = repository.create(input);

        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual).hasFieldOrPropertyWithValue("description", expected.getDescription());

    }


    @Test
    @DisplayName("it should ensure MySQLCategoryRepositoryImpl returns finded categories")
    public void executeReturnsFindAllCategories() {
        Category entity1 = new Category("any_name_1", "any_description_1");
        Category entiry2 = new Category("any_name_2", "any_description_2");
        List <CategoryPersistence> expected = new ArrayList<CategoryPersistence>();
        expected.add(CategoryPersistence.from(entity1));
        expected.add(CategoryPersistence.from(entiry2));

        doReturn(expected)
            .when(springDataCategoryRepository)
            .findAll();
        List<Category> actual = repository.findAll();

        assertThat(actual).isNotNull();
        assertThat(actual).isNotEmpty();
        assertThat(actual).hasSize(2);
    }
}
   