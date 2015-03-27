package net.engine.introUI;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import net.Start;
import net.engine.Engine;
import net.engine.resourceHandlers.MainMenuImageHandler;

public class HouseIntroUI {
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
		intro.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
		

		label6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {

            	Start.primaryStage.setScene(HouseIntroUI.intro);    	
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
	
	public static void runIntro(){
		
		/*BorderPane bPane = new BorderPane();
		MainMenuImageHandler iHandle = new MainMenuImageHandler();
		ImageView title = new ImageView();
		title.setImage(iHandle.title);
		
		GridPane gPane = new GridPane();
		bPane.setTop(title);
		bPane.setAlignment(title, Pos.TOP_CENTER);
		
		Label tArea = new Label();
		tArea.setWrapText(true);
	
		
		tArea.setText("You are in the middle of school and suddenly you hear the\ntornado siren over the intercom.\n You must find the best room within the school to \"Take Cover\" in. ");
		GridPane.setHalignment(tArea, HPos.CENTER);
		
		gPane.add(tArea, 0, 0);
		
		bPane.setCenter(gPane);
		bPane.setAlignment(gPane, Pos.CENTER);
		bPane.setOnKeyPressed(new EventHandler<KeyEvent>(){
	    	public void handle(KeyEvent mainMenuHandler){
	    		if(mainMenuHandler.getCode() == KeyCode.SPACE){
	    			Engine.loadSchoolLevel();
	    		}
	    	}
		});
		*/
		
    	GridPane helpGrid = new GridPane();
    	BorderPane helpPane = new BorderPane();
    	
    	helpGrid.setAlignment(Pos.CENTER);
    	

    	
    	helpGrid.setHgap(10);
    	helpGrid.setVgap(10);
    	helpGrid.setPadding(new Insets(0, 10, 0, 10));
    	
        
        Label label1 = new Label("You are inside your house when");
        Label label2 = new Label("you hear tornado sirens outside.");
        Label label3 = new Label("Find cover as quick as you can!");
        Label label4 = new Label("Find the safest room in your");
        Label label5 = new Label("house to \"Take Cover\"!");
        Label label6 = new Label("( Click me to continue )");
        
    	GridPane.setHalignment(label1, HPos.CENTER);
    	GridPane.setHalignment(label2, HPos.CENTER);
    	GridPane.setHalignment(label3, HPos.CENTER);
    	GridPane.setHalignment(label4, HPos.CENTER);
    	GridPane.setHalignment(label5, HPos.CENTER);
    	GridPane.setHalignment(label6, HPos.CENTER);



        helpGrid.add(label1,0,0);
        helpGrid.add(label2,0,1);
        helpGrid.add(label3,0,2);
        helpGrid.add(label4,0,3);
        helpGrid.add(label5,0,4);
        helpGrid.add(label6,0,5);
    	helpGrid.setStyle("-fx-background-color:rgba(0, 0, 0, 0.5)");
        
    	
    	helpPane.setCenter(helpGrid);
    	helpPane.setPadding(new Insets(150,150,150,150));

    	intro = new Scene(helpPane,Start.sceneStartWidth,Start.sceneStartHeight);
		intro.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
		
		label6.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent t) {
	        	Engine.loadHouse2Level();
	        	
	        	
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
		runInfo();
		
	}
	
	
	
}