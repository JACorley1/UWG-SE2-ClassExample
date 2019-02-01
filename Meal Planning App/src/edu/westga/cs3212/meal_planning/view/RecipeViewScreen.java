package edu.westga.cs3212.meal_planning.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs3212.meal_planning.Main;
import edu.westga.cs3212.meal_planning.model.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/** Codebehind for the RecipeViewScreen.
 * 
 * @author jcorley
 */
public class RecipeViewScreen {    @FXML
    private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Label name;
    @FXML private Label prepTime;
    @FXML private Label cookTime;
    @FXML private ListView<String> ingredientList;
    @FXML private ListView<String> instructions;
	private Recipe recipe;
   
	/** Create a new RecipeViewScreen with the specified recipe.
	 * 
	 * @precondition recipe != null
	 * @postcondition none
	 * 
	 * @param recipe recipe to view.
	 */
	public void setRecipe(Recipe recipe) {
		if (recipe == null) {
			throw new IllegalArgumentException("Recipe must not be null.");
		}
	   	this.recipe = recipe;
	   	this.name.setText(this.recipe.getName());
	   	this.prepTime.setText(Double.toString(this.recipe.getTimeToPrep()));
	   	this.cookTime.setText(Double.toString(this.recipe.getTimeToCook()));
	   	this.ingredientList.getItems().setAll(this.recipe.getIngredients());
	   	this.instructions.getItems().setAll(this.recipe.getInstructions());
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
        assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'RecipeViewScreen.fxml'.";
        assert this.prepTime != null : "fx:id=\"prepTime\" was not injected: check your FXML file 'RecipeViewScreen.fxml'.";
        assert this.cookTime != null : "fx:id=\"cookTime\" was not injected: check your FXML file 'RecipeViewScreen.fxml'.";
        assert this.ingredientList != null : "fx:id=\"ingredientList\" was not injected: check your FXML file 'RecipeViewScreen.fxml'.";
        assert this.instructions != null : "fx:id=\"instructions\" was not injected: check your FXML file 'RecipeViewScreen.fxml'.";
    }

}
