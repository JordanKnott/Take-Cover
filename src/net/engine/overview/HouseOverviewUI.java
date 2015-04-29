package net.engine.overview;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import net.Start;
import net.engine.Engine;
import net.engine.introUI.HouseIntroUI;
import net.engine.introUI.ScenarioSelect;

public class HouseOverviewUI {

	
	
	public static void runOverview(){
			
    	GridPane helpGrid = new GridPane();
    	BorderPane helpPane = new BorderPane();
    	helpGrid.setAlignment(Pos.CENTER);
    	helpGrid.setHgap(10);
    	helpGrid.setVgap(10);
    	helpGrid.setPadding(new Insets(0, 10, 0, 10));
    	
        
        Label label1 = new Label("House Scenario Overview");
      //  label4.setStyle("-fx-text-color:rgba(0, 0, 255, 0.7)");
        Label label2 = new Label("Correct Items Collected - "  + Engine.score.returnItems());
        Label label3 = new Label("Correct Items Needed - 10");

        //Label label4 = new Label("Click Me to see detailed overview");
       // label4.setStyle("-fx-text-color:rgba(0, 0, 255, 0.7)");
        Label label5 = new Label("");
        Label label6 = new Label("(Click me to continue)");
        
    	GridPane.setHalignment(label1, HPos.CENTER);
    	GridPane.setHalignment(label2, HPos.CENTER);
    	GridPane.setHalignment(label3, HPos.CENTER);
    	//GridPane.setHalignment(label4, HPos.CENTER);
    	GridPane.setHalignment(label5, HPos.CENTER);
    	GridPane.setHalignment(label6, HPos.CENTER);
    	label1.setAlignment(Pos.CENTER_LEFT);
    	label2.setAlignment(Pos.CENTER_LEFT);
    	label3.setAlignment(Pos.CENTER_LEFT);
    	//label4.setAlignment(Pos.CENTER_LEFT);
    	label5.setAlignment(Pos.CENTER_LEFT);
    	label6.setAlignment(Pos.CENTER_LEFT);

        helpGrid.add(label1,0,0);
        helpGrid.add(label2,0,1);
        helpGrid.add(label3,0,2);
       // helpGrid.add(label4,0,3);
        helpGrid.add(label5,0,3);
        helpGrid.add(label6,0,4);
    	helpGrid.setStyle("-fx-background-color:rgba(0, 0, 0, 0.5)");
        
    	
    	helpPane.setCenter(helpGrid);
    	helpPane.setPadding(new Insets(150,150,150,150));

		Scene intro = new Scene(helpPane,Start.sceneStartWidth,Start.sceneStartHeight);
		intro.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
		
		label6.setOnKeyPressed(new EventHandler<KeyEvent>(){
	    	public void handle(KeyEvent mainMenuHandler){
	    		DetailedOverviewUI.runOverview();
	    	}
		});		
		label6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {

            	DetailedOverviewUI.runOverview();
            	
            }

    	});
		label6.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {

            	label6.setEffect(Engine.returnEnteredEffect());
            	
            }

    	});
		label6.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
            	label6.setEffect(null);

            	
            	
            }

    	});
		Start.primaryStage.setScene(intro);
	}
	
}
