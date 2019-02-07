package edu.westga.cs3212.meal_planning.model;

import java.util.ArrayList;
import java.util.List;

/** Manage storage and access for the collection of recipes in the system.
 * 
 * @author jcorley
 */
public final class RecipeManager {
	private List<Recipe> recipes;
	
	/** Creates a new RecipeManager with the specified list of recipes.
	 * 
	 * @precondition recipes != null
	 * @postcondition getRecipes().containsAll(recipes)
	 * 
	 * @param recipes the list of all recipes in the system.
	 */
	public RecipeManager(List<Recipe> recipes) {
		if (recipes == null) {
			throw new IllegalArgumentException("Recipes must not be null");
		}
		this.recipes = recipes;
	}
	
	/** Get a list of all recipes stored in the system.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a list of all recipes stored in the system.
	 */
	public List<Recipe> getRecipes() {
		return this.recipes;
	}
	
	/** Returns a list of all categories in the system.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a list of all categories in the system
	 */
	public List<String> getCategories() {
		ArrayList<String> categories = new ArrayList<String>();
		
		for (Recipe recipe : this.recipes) {
			this.addCategoriesFromRecipe(categories, recipe);
		}
		
		return categories;
	}

	private void addCategoriesFromRecipe(ArrayList<String> categories, Recipe recipe) {
		for (String currentCategory : recipe.getCategories()) {
			if (!categories.contains(currentCategory)) {
				categories.add(currentCategory);
			}
		}
	}
	
	/** Get a list of all recipes with the specified category.
	 * Note: null is allowed for category, but no result will be 
	 * returned as a Recipe may not have null as a category.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param category category of recipe being searched for
	 * 
	 * @return a list of all recipes with the specified category
	 */
	public List<Recipe> getRecipesWithCategory(String category) {
		ArrayList<Recipe> recipesWithCategory = new ArrayList<Recipe>();
		
		for (Recipe currentRecipe : this.recipes) {
			if (currentRecipe.getCategories().contains(category)) {
				recipesWithCategory.add(currentRecipe);
			}
		}
		
		return recipesWithCategory;
	}

}
