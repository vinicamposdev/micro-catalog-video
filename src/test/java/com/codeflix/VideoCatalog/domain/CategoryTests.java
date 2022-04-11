package com.codeflix.VideoCatalog.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
	@DisplayName("it should ensure category throws domain exception when name is null")
	void throwDomainExeptionWhenNameIsNull() {
		assertThrows(DomainException.class, () -> new Category(null, "any_description"));
	}

	@Test
	@DisplayName("it should ensure category throws domain exception when name is empty")
	void throwDomainExeptionWhenNameIsBlank() {
		assertThrows(DomainException.class, () -> new Category("", "any_description"));
	}

	@Test
	@DisplayName("it should ensure that a category is created with name, description and isActive set to true")
	void createCategoryWithNameDescription() {
		final Category entity = new Category("any_name", "any_description");

		assertNotNull(entity);
		assertEquals(entity.getName(), "any_name");
		assertEquals(entity.getDescription(),"any_description");
		assertTrue((entity.getIsActive()));
	}

	@Test
	@DisplayName("it should ensure that method deactivate returns isActive false")
	void createCategoryAndIsDeactivateTrue() {
		final Category entity = new Category("any_name", "any_description"); 

		entity.deactivate();

		assertNotNull(entity);
		assertFalse((entity.getIsActive()));
	}

	@Test
	@DisplayName("it should ensure that method update returns updated values")
	void createCategoryAndUpdate() {
		final Category entity = new Category("any_name", "any_description");

		entity.update("any_name_updated", "any_description_updated", false);

		assertNotNull(entity);
		assertEquals(entity.getName(), "any_name_updated");
		assertEquals(entity.getDescription(),"any_description_updated");
		assertFalse((entity.getIsActive()));
	}
}
