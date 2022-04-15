package com.codeflix.VideoCatalog.infrastructure.persistence;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.codeflix.VideoCatalog.domain.entity.Category;
import com.codeflix.VideoCatalog.domain.exception.NotNullException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryPersistence {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column
    @NotNull(message = "name can not be null")
    @NotBlank(message = "name can not be blank")
    private String name;
    
    @Column
    private String description;
    
    @Column
    private Boolean isActive = true;

    public static CategoryPersistence from(Category category) {
        if (category == null) {
            throw new NotNullException();
        }

        return new CategoryPersistence(
            category.getId(), 
            category.getName(), 
            category.getDescription(), 
            category.getIsActive()
        );

    }

    public Category fromThis() {
        return new Category(
            getId(),
            getName(),
            getDescription()
        );
    }
}
