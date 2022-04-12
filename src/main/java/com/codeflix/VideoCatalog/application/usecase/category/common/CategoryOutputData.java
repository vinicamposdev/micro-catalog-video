package com.codeflix.VideoCatalog.application.usecase.category.common;

import java.util.UUID;

import com.codeflix.VideoCatalog.domain.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryOutputData {
    private UUID id;
    private String name;
    private String description;
    private Boolean isActive;

    public static CategoryOutputData fromDomain(Category domain) {
        return new CategoryOutputData(
            domain.getId(),
            domain.getName(),
            domain.getDescription(),
            domain.getIsActive()
        );
    }
}
