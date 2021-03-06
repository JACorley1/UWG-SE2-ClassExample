package edu.westga.cs3212.meal_planning.view;

import java.util.ArrayList;
import java.util.List;

import edu.westga.cs3212.meal_planning.model.Recipe;
import edu.westga.cs3212.meal_planning.model.RecipeManager;

/** Control access to the RecipeManager for the gui. Implements a version of the Singleton pattern 
 * to ensure only one recipeManager exists, and all views reference the same recipeManage.
 * 
 * @author jcorley
 */
class RecipeStore {
	private static RecipeManager recipeManager = null;
	private static String currentCategory = null;

	/** Loads the list of recipes for the application from the appropriate source.
	 * NOTE: This method currently loads a hard-coded set of recipes for testing 
	 * purposes, but should eventually load the recipes from the server.
	 * 
	 * @return list of recipes
	 */
	protected static List<Recipe> loadRecipes() {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		Recipe recipe1 = new Recipe("lasagna", List.of("pasta", "italian"), 1.0, 2.0, List.of("meat", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 2);
		recipes.add(recipe1);
		
		Recipe recipe2 = new Recipe("eggplant parmesan", List.of("pasta", "italian", "vegetarian"), 3.0, 4.0, List.of("eggplant", "noodles", "sauce", "cheese"), List.of("Combine ingredients", "Cook ingredients"), 4);
		recipes.add(recipe2);

		return recipes;
	}

	/** Gets a reference to the RecipeManager. If there is no RecipeManager, also
	 * creates the RecipeManager.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a reference to the RecipeManager
	 */
	public static RecipeManager getRecipeManager() {
		if (RecipeStore.recipeManager == null) {
			RecipeStore.recipeManager = new RecipeManager(RecipeStore.loadRecipes());
		}
		return RecipeStore.recipeManager;
	}

	   
	/** Set the category for recipes to select.
	 * 
	 * @precondition category != null
	 * @postcondition initializes the category of recipes available on the recipe select screen
	 * 
	 * @param category category of recipe available to select.
	 */
	public static void setCurrentCategory(String category) {
		if (category == null) {
			throw new IllegalArgumentException("Category must not be null.");
		}
		RecipeStore.currentCategory = category;
	}
	public static String getCurrentCategory() {
		return RecipeStore.currentCategory;
	}

}
