package edu.westga.cs3212.meal_planning.test.model.recipe_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.meal_planning.model.Recipe;
import edu.westga.cs3212.meal_planning.model.RecipeManager;

class TestConstructor {

	@Test
	void testRecipesIsNull() {
		assertThrows(
						IllegalArgumentException.class, 
						()->{
								new RecipeManager(null);
						}
					);
	}

	@Test
	void testCreateManagerWithNoRecipes() {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		RecipeManager result = new RecipeManager(recipes);
		
		List<Recipe> recipesList = result.getRecipes();
		assertEquals(0, recipesList.size());
	}

	@Test
	void testCreateManagerWithOneRecipe() {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		Recipe recipe1 = new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
		recipes.add(recipe1);
		
		RecipeManager result = new RecipeManager(recipes);
		
		List<Recipe> recipesList = result.getRecipes();
		assertEquals(1, recipesList.size());
		assertSame(recipe1, recipesList.get(0));
	}

	@Test
	void testCreateManagerWithSeveralRecipes() {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		Recipe recipe1 = new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
		recipes.add(recipe1);
		
		Recipe recipe2 = new Recipe("eggplant parmesan", List.of("pasta", "italian", "vegetarian"), 3.0, 4.0, List.of("eggplant", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 4);
		recipes.add(recipe2);
		
		RecipeManager result = new RecipeManager(recipes);
		
		List<Recipe> recipesList = result.getRecipes();
		assertEquals(2, recipesList.size());
		assertSame(recipe1, recipesList.get(0));
		assertSame(recipe2, recipesList.get(1));
	}

}
