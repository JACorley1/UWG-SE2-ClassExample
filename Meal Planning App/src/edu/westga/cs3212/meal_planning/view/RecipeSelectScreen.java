package edu.westga.cs3212.meal_planning.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import edu.westga.cs3212.meal_planning.Main;
import edu.westga.cs3212.meal_planning.model.Recipe;
import edu.westga.cs3212.meal_planning.model.RecipeManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Codebehind for the RecipeSelectScreen.
 * 
 * @author jcorley
 */
public class RecipeSelectScreen {
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private ListView<Recipe> recipeList;
   
	/** Set the category for recipes to select.
	 * 
	 * @precondition category != null
	 * @postcondition none
	 * 
	 * @param category category of recipe available to select.
	 */
	public void setCategory(String category) {
		if (category == null) {
			throw new IllegalArgumentException("Category must not be null.");
		}
	   	RecipeManager recipeManager = RecipeStore.getRecipeManager();
		List<Recipe> recipesWithCategory = recipeManager.getRecipesWithCategory(category);
		ObservableList<Recipe> items = this.recipeList.getItems();
		items.addAll(recipesWithCategory);
	}

    @FXML
    void selectRecipe(MouseEvent event) throws IOException {
    	Recipe recipe = this.recipeList.getSelectionModel().getSelectedItem();
    	if (recipe != null) {
	    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.RECIPE_VIEW_SCREEN));
			loader.load();
			((RecipeViewScreen) loader.getController()).setRecipe(recipe);
			Scene recipeViewScreen = new Scene(loader.getRoot());
			currentStage.setScene(recipeViewScreen);
    	}
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.CATEGORY_SELECT_SCREEN));
		loader.load();
		Scene categorySelectScreen = new Scene(loader.getRoot());
		currentStage.setScene(categorySelectScreen);
    }

    @FXML
    void initialize() {
        assert this.recipeList != null : "fx:id=\"recipeList\" was not injected: check your FXML file 'RecipeSelectScreen.fxml'.";
    }

}
