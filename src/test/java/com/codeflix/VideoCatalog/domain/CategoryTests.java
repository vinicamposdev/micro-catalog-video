package com.codeflix.VideoCatalog.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryTests {

	@Test
	@DisplayName("it should create a category with name, description and isActive set to true")
	void createCategoryWithNameDescription() throws Exception {
		final Category entity = new Category("any_name", "any_description");

		assertNotNull(entity);
		assertEquals(entity.getName(), "any_name");
		assertEquals(entity.getDescription(),"any_description");
		assertTrue((entity.getIsActive()));
	}
}
