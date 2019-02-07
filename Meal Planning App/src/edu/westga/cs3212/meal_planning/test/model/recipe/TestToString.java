package edu.westga.cs3212.meal_planning.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.meal_planning.model.Recipe;

class TestToString {

	@Test
	void testValidRecipe() {
		Recipe recipe = new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
		
		String result = recipe.toString();
		
		assertEquals("lasagna (prep: 2.0 hrs, cook: 1.0 hrs, serves: 2 people)", result);
	}

}
