package edu.westga.cs3212.meal_planning.test.model.recipe_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.meal_planning.model.Recipe;
import edu.westga.cs3212.meal_planning.model.RecipeManager;

class TestGetRecipesWithCategory {

	@Test
	void test1() {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		Recipe recipe1 = new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
		recipes.add(recipe1);
		
		Recipe recipe2 = new Recipe("eggplant parmesan", List.of("pasta", "italian", "vegetarian"), 3.0, 4.0, List.of("eggplant", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 4);
		recipes.add(recipe2);
		
		RecipeManager manager = new RecipeManager(recipes);
		
		List<Recipe> result = manager.getRecipesWithCategory("pasta");
		
		assertEquals(2, result.size());
		assertSame(recipe1, result.get(0));
		assertSame(recipe2, result.get(1));
	}

	@Test
	void test2() {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		Recipe recipe1 = new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
		recipes.add(recipe1);
		
		Recipe recipe2 = new Recipe("eggplant parmesan", List.of("pasta", "italian", "vegetarian"), 3.0, 4.0, List.of("eggplant", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 4);
		recipes.add(recipe2);
		
		RecipeManager manager = new RecipeManager(recipes);
		
		List<Recipe> result = manager.getRecipesWithCategory("vegetarian");
		
		assertEquals(1, result.size());
		assertSame(recipe2, result.get(0));
	}

}
