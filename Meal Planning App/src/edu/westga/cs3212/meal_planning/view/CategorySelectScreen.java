package edu.westga.cs3212.meal_planning.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs3212.meal_planning.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** Codebehind for the CategorySelectScreen.
 * 
 * @author jcorley
 */
public class CategorySelectScreen {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private ListView<String> categoryList;

    @FXML
    void selectCategory(MouseEvent event) throws IOException {
    	String category = this.categoryList.getSelectionModel().getSelectedItem();
    	if (category != null) {
	    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.RECIPE_SELECT_SCREEN));
			loader.load();
			((RecipeSelectScreen) loader.getController()).setCategory(category);
			Scene recipeSelectScreen = new Scene(loader.getRoot());
			currentStage.setScene(recipeSelectScreen);
    	}
    }

    @FXML
    void initialize() {
        assert this.categoryList != null : "fx:id=\"categoryList\" was not injected: check your FXML file 'CategorySelectScreen.fxml'.";

        this.categoryList.getItems().addAll(RecipeStore.getRecipeManager().getCategories());
    }

}
