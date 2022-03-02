package com.codeflix.VideoCatalog.domain;

import java.util.UUID;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Category {
	private UUID id;
	private String name;
	private String descriptio;
	private Boolean isActive = true;

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescriptio() {
		return this.descriptio;
	}

	public void setDescriptio(String descriptio) {
		this.descriptio = descriptio;
	}

	public Boolean isIsActive() {
		return this.isActive;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public Boolean activate() {
		return this.isActive = true;
	}

	public Boolean deactivate() {
		return this.isActive = false;
	}
}
