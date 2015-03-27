package net.engine.introUI;

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

public class GameIntroUI {

	
	public static void runUI(){
		
	  	GridPane helpGrid = new GridPane();
    	BorderPane helpPane = new BorderPane();
    	
    	helpGrid.setAlignment(Pos.CENTER);
    	

    	
    	helpGrid.setHgap(10);
    	helpGrid.setVgap(10);
    	helpGrid.setPadding(new Insets(0, 10, 0, 10));
    	
        
        Label label1 = new Label("Take Cover Objectives");
        Label label2 = new Label("Gather Items for an emergency kit.");
        Label label3 = new Label("You have 10 spots for items.");
        Label label4 = new Label("Find the best areas to take cover in.");
        Label label5 = new Label("Thirty seconds per scenario except for the first one.");
        Label label7 = new Label("");
        Label label6 = new Label("( Click me to continue )");
        
    	GridPane.setHalignment(label1, HPos.CENTER);
    	GridPane.setHalignment(label2, HPos.CENTER);
    	GridPane.setHalignment(label3, HPos.CENTER);
    	GridPane.setHalignment(label4, HPos.CENTER);
    	GridPane.setHalignment(label5, HPos.CENTER);
    	GridPane.setHalignment(label6, HPos.CENTER);
    	GridPane.setHalignment(label7, HPos.CENTER);


        helpGrid.add(label1,0,0);
        helpGrid.add(label2,0,1);
        helpGrid.add(label3,0,2);
        helpGrid.add(label4,0,3);
        helpGrid.add(label5,0,4);
        helpGrid.add(label7,0,5);
        helpGrid.add(label6,0,6);
    	helpGrid.setStyle("-fx-background-color:rgba(0, 0, 0, 0.5)");
        
    	
    	helpPane.setCenter(helpGrid);
    	helpPane.setPadding(new Insets(150,150,150,150));

		Scene scene1 = new Scene(helpPane,Start.sceneStartWidth,Start.sceneStartHeight);
		scene1.getStylesheets().add(RoadIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());

		


		
		
		
		
		
		

		label6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
            	Start.primaryStage.setScene(Engine.controlScene);
            	
            	
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

		Start.primaryStage.setScene(scene1);
		
	}
	
}
