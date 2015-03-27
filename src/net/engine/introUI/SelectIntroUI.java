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

public class SelectIntroUI{

public static void runIntro(){
		
  	GridPane helpGrid = new GridPane();
  	BorderPane helpPane = new BorderPane();
  	
  	
  	
  	
  	helpGrid.setAlignment(Pos.CENTER);
  	

  	
  	helpGrid.setHgap(10);
  	helpGrid.setVgap(10);
  	helpGrid.setPadding(new Insets(0, 10, 0, 10));
  	
      
      Label label1 = new Label("There are three scenarios. Inside each you must find");
      Label label2 = new Label("the safest place to take cover. Tornados come");
      Label label3 = new Label("from the southwest towards northeast.");
      Label label4 = new Label("The safest rooms are interior room with no windows, with");
      Label label5 = new Label("as much building between it and the tornado. ");
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
	

	Scene intro = new Scene(helpPane,Start.sceneStartWidth,Start.sceneStartHeight);
	intro.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	
	Start.primaryStage.setScene(intro);
	}
	
	
}
