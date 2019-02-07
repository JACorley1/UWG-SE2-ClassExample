package edu.westga.cs3212.meal_planning.model;

import java.util.ArrayList;
import java.util.List;

/** Store information for a single Recipe
 * 
 * @author jcorley
 */
public class Recipe {
	private String name;
	private List<String> categories;
	private double timeToCook;
	private double timeToPrep;
	private List<String> ingredients;
	private List<String> instructions;
	private int servings;

	/** Create a new recipe with the provided information.
	 * 
	 * @precondition name != null && 
	 * 				 categories != null && !categories.contains(null) &&
	 * 				 timeToCook >= 0.0 && 
	 * 				 timeToPrep >= 0.0 && 
	 * 				 ingredients != null &&  !ingredients.contains(null) &&
	 * 				 instructions != null &&  !instructions.contains(null) &&
	 * 				 servings >= 0
	 * @postcondition getName() == name &&
	 * 				  getCategories() == categories &&
	 * 				  getTimeToCook() == timeToCook &&
	 * 				  getTimeToPrep() == timeToPrep &&
	 * 				  getIngredients() == ingredients &&
	 * 				  getInstructions() == instructions &&
	 * 				  getServings() == servings
	 * 
	 * @param name name for the recipe
	 * @param timeToCook time to cook for the recipe
	 * @param timeToPrep time to prep for the recipe
	 * @param categories list of categories for the recipe
	 * @param ingredients list of ingredients for the recipe
	 * @param instructions list of instructions for the recipe
	 * @param servings number of people the recipe serves
	 */
	public Recipe(String name, List<String> categories, double timeToCook, double timeToPrep, List<String> ingredients, List<String> instructions, int servings) {
		if (name == null) {
			throw new IllegalArgumentException("name must not be null");
		}
		if (categories == null) {
			throw new IllegalArgumentException("categories must not be null");
		}
		if (this.checkForNull(categories)) {
			throw new IllegalArgumentException("categories must not contain null");
		}
		if (timeToCook < 0.0) {
			throw new IllegalArgumentException("timeToCook must not be negative");
		}
		if (timeToPrep < 0.0) {
			throw new IllegalArgumentException("timeToPrep must not be negative");
		}
		if (ingredients == null) {
			throw new IllegalArgumentException("ingredients must not be null");
		}
		if (this.checkForNull(ingredients)) {
			throw new IllegalArgumentException("ingredients must not contain null");
		}
		if (instructions == null) {
			throw new IllegalArgumentException("instructions must not be null");
		}
		if (this.checkForNull(instructions)) {
			throw new IllegalArgumentException("instructions must not contain null");
		}
		if (servings < 0.0) {
			throw new IllegalArgumentException("servings must not be negative");
		}
		this.name = name;
		this.timeToCook = timeToCook;
		this.timeToPrep = timeToPrep;
		this.servings = servings;
		this.categories = new ArrayList<String>();
		this.categories.addAll(categories);
		this.ingredients = new ArrayList<String>();
		this.ingredients.addAll(ingredients);
		this.instructions = new ArrayList<String>();
		this.instructions.addAll(instructions);
	}
	
	private boolean checkForNull(List<String> list) {
		for (String currentString : list) {
			if (currentString == null) {
				return true;
			}
		}
		return false;
	}

	/** Return the time to cook the recipe
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the time to cook the recipe
	 */
	public double getTimeToCook() {
		return this.timeToCook;
	}

	/** Return the number of people the recipe serves
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of people the recipe serves
	 */
	public double getServings() {
		return this.servings;
	}

	/** Return the time to prep the recipe
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the time to prep the recipe
	 */
	public double getTimeToPrep() {
		return this.timeToPrep;
	}


	/** Return the ingredients for the recipe
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the ingredients for the recipe
	 */
	public List<String> getIngredients() {
		return this.ingredients;
	}


	/** Return the instructions for the recipe
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the instructions for the recipe
	 */
	public List<String> getInstructions() {
		return this.instructions;
	}

	/** Return the name of the recipe
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the recipe
	 */
	public String getName() {
		return this.name;
	}

	
	/** Return the categories of the recipe
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the categories of the recipe
	 */
	public List<String> getCategories() {
		return this.categories;
	}
	
	@Override
	public String toString() {
		return this.name + " (prep: " + this.timeToPrep + " hrs, cook: " + this.timeToCook + " hrs, serves: " + this.servings + " people)";
	}

}
