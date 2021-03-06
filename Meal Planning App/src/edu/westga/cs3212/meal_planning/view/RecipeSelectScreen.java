package edu.westga.cs3212.meal_planning.view;

import java.io.IOException;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import edu.westga.cs3212.meal_planning.model.Recipe;
import edu.westga.cs3212.meal_planning.model.RecipeManager;

/** Codebehind for the RecipeSelectScreen.
 * 
 * @author jcorley
 */
public class RecipeSelectScreen {
	
    @FXML private ListView<Recipe> recipes;

	/** Opens the Recipe View Screen if a valid (not null) recipe has been selected.
	 * 
	 * @param event event generated by the associated javafx control
	 * 
	 * @throws IOException thrown if the fxml for the RecipeViewScreen is not available or improperly formatted.
	 */
    @FXML
    void selectRecipe(MouseEvent event) throws IOException {
    	Recipe recipe = this.recipes.getSelectionModel().getSelectedItem();
    	if (recipe != null) {
	    	ScreenUtilities.openRecipeViewScreen(event, recipe);
    	}
    }

	/** Opens the home screen (CategorySelectScreen).
	 * 
	 * @param event event generated by the associated javafx control
	 * 
	 * @throws IOException thrown if the fxml for the CategorySelectScreen is not available or improperly formatted.
	 */
    @FXML
    void goToHome(ActionEvent event) throws IOException {
    	ScreenUtilities.openCategorySelectScreen(event);
    }

    /**Automated setup run when JavaFX engine generates this controller. 
     * Verifies all javafx controls are initialized.
     * Initializes the list of recipes for the current category.
     */
    @FXML
    void initialize() {
        assert this.recipes != null : "fx:id=\"recipeList\" was not injected: check your FXML file 'RecipeSelectScreen.fxml'.";
        
	   	RecipeManager recipeManager = RecipeStore.getRecipeManager();
	   	String category = RecipeStore.getCurrentCategory();
		List<Recipe> recipesWithCategory = recipeManager.getRecipesWithCategory(category);
		ObservableList<Recipe> items = this.recipes.getItems();
		items.addAll(recipesWithCategory);
    }

}
