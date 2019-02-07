package edu.westga.cs3212.meal_planning.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.meal_planning.model.Recipe;

class TestConstructor {

	@Test
	void testNameIsNull() {
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new Recipe(null, List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
						}
					);
	}

	@Test
	void testCategoriesIsNull() {
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new Recipe("lasagna", null, 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
						}
					);
	}

	@Test
	void testCategoriesContainsNull() {
		ArrayList<String> categories = new ArrayList<String>();
		categories.add(null);
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new Recipe("lasagna", categories, 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
						}
					);
	}

	@Test
	void testIngredientsIsNull() {
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, null, List.of("Combine ingredients", "Cook ingredients"), 2);
						}
					);
	}

	@Test
	void testIngredientsContainsNull() {
		ArrayList<String> ingredients = new ArrayList<String>();
		ingredients.add(null);
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, ingredients, List.of("Combine ingredients", "Cook ingredients"), 2);
						}
					);
	}

	@Test
	void testInstructionsIsNull() {
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), null, 2);
						}
					);
	}

	@Test
	void testInstructionsContainsNull() {
		ArrayList<String> instructions = new ArrayList<String>();
		instructions.add(null);
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), instructions, 2);
						}
					);
	}

	@Test
	void testTimeToCookIsNegative() {
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new Recipe("lasagna", List.of("pasta", "italian"), -1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
						}
					);
	}

	@Test
	void testTimeToPrepIsNegative() {
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new Recipe("lasagna", List.of("pasta", "italian"), 1.0, -1.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
						}
					);
	}

	@Test
	void testServingsIsNegative() {
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), -1);
						}
					);
	}

	@Test
	void testCreateValidRecipe() {
		Recipe result = new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);

		assertEquals("lasagna", result.getName());
		assertEquals(1.0, result.getTimeToCook());
		assertEquals(2.0, result.getTimeToPrep());
		assertEquals(2, result.getServings());
		
		List<String> categories = result.getCategories();
		assertEquals(2, categories.size());
		assertEquals("pasta", categories.get(0));
		assertEquals("italian", categories.get(1));
		
		List<String> ingredients = result.getIngredients();
		assertEquals(4, ingredients.size());
		assertEquals("meat", ingredients.get(0));
		assertEquals("noodles", ingredients.get(1));
		assertEquals("sauce", ingredients.get(2));
		assertEquals("cheese", ingredients.get(3));
		
		List<String> instructions = result.getInstructions();
		assertEquals(2, instructions.size());
		assertEquals("Combine ingredients", instructions.get(0));
		assertEquals("Cook ingredients", instructions.get(1));
	}

}
