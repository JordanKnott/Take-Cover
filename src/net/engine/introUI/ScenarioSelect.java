package net.engine.introUI;
import net.Start;
import net.engine.AssetLoader;
import net.engine.Engine;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
/** Constructs a scene with a pannable Map background. */
public class ScenarioSelect{
  private static Image backgroundImage;
  
  
  public static void runIntro(){
	  

	  
  }

  
  public static void runUI(){
	  
	  
	  
	
	runIntro();  
	System.out.println(Engine.isScenario1Done + " : " + Engine.isScenario2Done + " : " + Engine.isScenario3Done  + " LOCKED: " + Engine.isScenario3Locked);
	Engine.objLabel.setText("Find the best areas to take cover in. Red Squares are the take cover zones");
	Engine.itemLabel.setText("");
	Engine.updateInvCount = false;
	  backgroundImage =  AssetLoader.returnClaremore();
    // construct the scene contents over a stacked background.
	BorderPane core = new BorderPane();
	GridPane status = new GridPane();
	status.setAlignment(Pos.CENTER);
	Label description = new Label("Click a button to go to that scenario.");
	Label index = new Label("Yellow: Available  Green: Completed  Red: Locked");
	status.add(description,0,1);
	status.add(index,0,0);
	GridPane.setHalignment(index, HPos.CENTER);
	GridPane.setHalignment(description, HPos.CENTER);
	index.setId("statusLabel");
	description.setId("statusLabel");
	status.setStyle("-fx-background-color:rgba(0, 0, 0, 0.1)");
	
	  
    StackPane layout = new StackPane();
    layout.getChildren().setAll(
      new ImageView(backgroundImage),
      createHouseButton(),
      createRoadButton(),
      createSchoolButton()
    );
 
    core.setTop(status);
    
    // wrap the scene contents in a pannable scroll pane.
    //ScrollPane scroll = createScrollPane(layout);
   
    BorderPane bPane = new BorderPane();
    bPane.setCenter(layout);
    bPane.setAlignment(layout,Pos.CENTER);
    core.setCenter(bPane);
    
    // show the scene.
    Scene scene = new Scene(core,Start.sceneStartWidth,Start.sceneStartHeight);
    scene.getStylesheets().add(ScenarioSelect.class.getResource("/net/assets/menu/MainMenu.css").toString());
    Start.primaryStage.setScene(scene);
    
    /* bind the preferred size of the scroll area to the size of the scene.
    scroll.prefWidthProperty().bind(scene.widthProperty());
    scroll.prefHeightProperty().bind(scene.widthProperty());
    */
   
    // center the scroll contents.
   // scroll.setHvalue(scroll.getHmin() + (scroll.getHmax() - scroll.getHmin()) / 2);
    //scroll.setVvalue(scroll.getVmin() + (scroll.getVmax() - scroll.getVmin()) / 2);
  }
  
  /** @return a control to place on the scene. */
  private static Button createHouseButton() {
    final Button killButton = new Button("House Scenario");
    
    if(Engine.isScenario1Done == false){
    	killButton.setStyle("-fx-base: yellow;");
    }else if(Engine.isScenario1Done == true){
    	killButton.setStyle("-fx-base: forestgreen;");
    }
    
    
    
    killButton.setTranslateX(65);
    killButton.setTranslateY(-155);
    killButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
    	  if(Engine.isScenario1Done != true){
    		  HouseIntroUI.runIntro();
    		  Engine.inScenario = true;
    	  }
      }
    });
    return killButton;
  }
  private static Button createSchoolButton() {
	    final Button killButton = new Button("School Scenario");
	    if(Engine.isScenario3Done == false && Engine.isScenario3Locked != true){
	    	killButton.setStyle("-fx-base: yellow;");
	    }else if(Engine.isScenario3Done == true && Engine.isScenario3Locked != true){
	    	killButton.setStyle("-fx-base: forestgreen;");
	    }else if(Engine.isScenario3Locked){
	    	killButton.setStyle("-fx-base: firebrick;");
	    }
	    killButton.setTranslateX(-360);
	    killButton.setTranslateY(200);
	    killButton.setOnAction(new EventHandler<ActionEvent>() {
	      @Override public void handle(ActionEvent t) {
	        if(Engine.isScenario3Locked != true && Engine.isScenario3Done != true){
	        	Engine.inScenario = true;
	        	SchoolIntroUI.runIntro();
	        }
	      }
	    });
	    return killButton;
	  }
  private static Button createRoadButton() {
	    final Button killButton = new Button("Road Scenario");
	    if(Engine.isScenario2Done == false){
	    	killButton.setStyle("-fx-base: yellow;");
	    }else if(Engine.isScenario2Done == true){
	    	killButton.setStyle("-fx-base: forestgreen;");
	    }
	    killButton.setTranslateX(-750);
	    killButton.setTranslateY(-220);
	    killButton.setOnAction(new EventHandler<ActionEvent>() {
	      @Override public void handle(ActionEvent t) {
	       if(Engine.isScenario2Done != true){
	    	   RoadIntroUI.runIntro();
	    	   Engine.inScenario = true;
	       }
	      }
	    });
	    return killButton;
	  }
  
 
  /** @return a ScrollPane which scrolls the layout. */
  private static ScrollPane createScrollPane(Pane layout) {
    ScrollPane scroll = new ScrollPane();
    scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    scroll.setPannable(false);
    scroll.setPrefSize(800, 600);
    scroll.setContent(layout);
    return scroll;
  }
  
 
}