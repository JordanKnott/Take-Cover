package net.engine.overview;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import net.Start;
import net.engine.Engine;
import net.engine.introUI.HouseIntroUI;
import net.engine.introUI.RoadIntroUI;
import net.engine.introUI.ScenarioSelect;
import net.engine.introUI.ScoreIntroUI;

public class House2OverviewUI {
	
	private static Scene intro;
	
	
	
	public static void runInfo(){
		
		GridPane helpGrid = new GridPane();
    	BorderPane helpPane = new BorderPane();
    	helpGrid.setAlignment(Pos.CENTER);
    	helpGrid.setHgap(10);
    	helpGrid.setVgap(10);
    	helpGrid.setPadding(new Insets(0, 10, 0, 10));
    	
        
        Label label1 = new Label("Rooms that have no exterior (outside) walls");
        Label label2 = new Label("and have no windows are the safest.");
        Label label3 = new Label("Tornados come from the southwest and travel");
        Label label4 = new Label("towards the northeast so having as much");
        Label label5 = new Label("walls between you and the tornado is a good thing.");

        Label label6 = new Label("(Click me to continue)");
        
    	GridPane.setHalignment(label1, HPos.CENTER);
    	GridPane.setHalignment(label2, HPos.CENTER);
    	GridPane.setHalignment(label3, HPos.CENTER);
    	GridPane.setHalignment(label4, HPos.CENTER);
    	GridPane.setHalignment(label5, HPos.CENTER);
    	GridPane.setHalignment(label6, HPos.CENTER);
    	label1.setAlignment(Pos.CENTER);
    	label2.setAlignment(Pos.CENTER);
    	label3.setAlignment(Pos.CENTER);
    	label4.setAlignment(Pos.CENTER);
    	label5.setAlignment(Pos.CENTER);
    	
    	label1.setId("statusLabel");
    	label2.setId("statusLabel");
    	label3.setId("statusLabel");
    	label4.setId("statusLabel");
    	label5.setId("statusLabel");
    	label6.setId("statusLabel");
    	
    	label6.setAlignment(Pos.CENTER);

        helpGrid.add(label1,0,0);
        helpGrid.add(label2,0,1);
        helpGrid.add(label3,0,2);
        helpGrid.add(label4,0,3);
        helpGrid.add(label5,0,4);
        helpGrid.add(label6,0,5);
    	helpGrid.setStyle("-fx-background-color:rgba(0, 0, 0, 0.5)");
        
    	
    	helpPane.setCenter(helpGrid);
    	helpPane.setPadding(new Insets(150,150,150,150));

		Scene intro = new Scene(helpPane,Start.sceneStartWidth,Start.sceneStartHeight);
		if(Engine.gridSize < 15){
			intro.getStylesheets().add(RoadIntroUI.class.getResource("/net/assets/menu/MainMenuSmall.css").toString());

		}else{		
			intro.getStylesheets().add(RoadIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
		}
		

		label6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {

            	Start.primaryStage.setScene(House2OverviewUI.intro);    	
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
	
	
	public static void runOverview(){
		
    	GridPane helpGrid = new GridPane();
    	BorderPane helpPane = new BorderPane();
    	helpGrid.setAlignment(Pos.CENTER);
    	helpGrid.setHgap(10);
    	helpGrid.setVgap(10);
    	helpGrid.setPadding(new Insets(0, 10, 0, 10));
    	
        
        Label label1 = new Label("This is a overview of the best areas to take cover in.");
        Label label2 = new Label("Green - Safest");
        Label label3 = new Label("Yellow - Semi Safe");
        Label label4 = new Label("Red - Not Safe");
        
		String overviewImagePath =  House2OverviewUI.class.getResource("/net/assets/overview/HouseSafeRoomRating.jpg").toString();
		
	    Image overviewImage = new Image(overviewImagePath);
	    ImageView iView = new ImageView(overviewImage);
	    iView.setFitHeight(256);
	    iView.setFitWidth(512);
        Label label6 = new Label("(Click me to continue)");
        
    	GridPane.setHalignment(label1, HPos.CENTER);
    	GridPane.setHalignment(label2, HPos.CENTER);
    	GridPane.setHalignment(label3, HPos.CENTER);
    	GridPane.setHalignment(label4, HPos.CENTER);
    	GridPane.setHalignment(iView, HPos.CENTER);
    	GridPane.setHalignment(label6, HPos.CENTER);
    	label1.setAlignment(Pos.CENTER);
    	label2.setAlignment(Pos.CENTER);
    	label3.setAlignment(Pos.CENTER);
    	label4.setAlignment(Pos.CENTER);
    	
    	
    	label1.setId("statusLabel");
    	label2.setId("statusLabel");
    	label3.setId("statusLabel");
    	label4.setId("statusLabel");
    	label6.setId("statusLabel");
    	
    	label6.setAlignment(Pos.CENTER);

        helpGrid.add(label1,0,0);
        helpGrid.add(label2,0,1);
        helpGrid.add(label3,0,2);
        helpGrid.add(label4,0,3);
        helpGrid.add(iView,0,4);
        helpGrid.add(label6,0,5);
    	helpGrid.setStyle("-fx-background-color:rgba(0, 0, 0, 0.5)");
        
    	
    	helpPane.setCenter(helpGrid);
    	helpPane.setPadding(new Insets(150,150,150,150));

		intro = new Scene(helpPane,Start.sceneStartWidth,Start.sceneStartHeight);
		intro.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
		

		label6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {

            	ScenarioSelect.runUI();     	
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
		Start.primaryStage.setScene(House2OverviewUI.intro); 
	}
}
