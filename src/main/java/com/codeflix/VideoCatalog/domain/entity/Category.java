package com.codeflix.VideoCatalog.domain.entity;

import java.util.UUID;

import com.codeflix.VideoCatalog.domain.exception.NotBlankException;
import com.codeflix.VideoCatalog.domain.exception.NotNullException;

public class Category {
    private UUID id;
    private String name;
    private String description;
    private Boolean isActive = true;

    public Category(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category(String name, String description) {
        this.id = UUID.randomUUID();
        this.setName(name);
        this.setDescription(description);
    }

    public Category(String name, String description, Boolean isActive) {
        this.id = UUID.randomUUID();
        this.setName(name);
        this.setDescription(description);
        if (isActive) this.activate(); 
        else this.deactivate();
    }


    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id; 
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null) throw new NotNullException("name is marked non-null but is null");
        if (name.isEmpty()) throw new NotBlankException("name is marked non-blank but is blank");
        this.name = name;
    }

    public void update(String name, String description, Boolean isActive) {
        this.setName(name);
        this.setDescription(description);
        if (isActive != null && isActive != this.getIsActive()) {
            if (isActive == true) this.activate();
            else this.deactivate();
        }
    }
}