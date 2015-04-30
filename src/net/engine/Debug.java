package net.engine;

import net.engine.introUI.SelectIntroUI;
import net.engine.overview.DetailedOverviewUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Debug {

	
	private static boolean debugActive = false;
	
	public void introDebug(){
		System.out.println("DEBUG INTRO");
	//	if(debugActive == false){
		//	activateDebug();
		//}else {
			dialogDebug();
		//}
		
		
	}
	
	public void activateDebug(){
		System.out.println("DEBUG INTRO");
		Stage dialogStage = new Stage(StageStyle.UNIFIED);
		GridPane grid = new GridPane();

		
		
		
		
		
		TextField input = new TextField();
		Button button = new Button("Activate Debug");
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				System.out.println(input.getText().equals("nightwolf"));
				System.out.println(input.getText());
				
				if(input.getText().equals("nightwolf")){
					debugActive = true;
				}

				dialogStage.close();
			}

		});
		
		
    	grid.setAlignment(Pos.CENTER);
		grid.add(button,0,0);
		grid.add(input,1,0);
		
		
		
		grid.getStylesheets().add(Engine.class.getResource("/net/assets/menu/Dialog.css").toString());
		Scene scene = new Scene(grid);
	
				
		dialogStage.setScene(scene);
		dialogStage.show();
	}
	
	
	public void dialogDebug(){
		
		Stage dialogStage = new Stage(StageStyle.UNIFIED);
		GridPane grid = new GridPane();

		
		Label label = new Label("DEBUG COMMANDS");
		Label yes = new Label("Open Scenario Select");

		Label no = new Label("Item score to 10");
		yes.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				SelectIntroUI.runIntro();
				
				
				dialogStage.close();
				
				
			}
	        	
	        	
	    });
		
		yes.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	yes.setText(">Open Scenario Select<");
	        	yes.setEffect(Engine.returnEnteredEffect());
	             
	        }
	    });
    	
		yes.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	yes.setText("Open Scenario Select");
	        	yes.setEffect(null);
	             
	        }
	    });
		
		no.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Engine.score.setItems(10);
				dialogStage.close();
			}
	        	
	    });
		
		
		no.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	no.setText(">Item score to 10<");
	        	no.setEffect(Engine.returnEnteredEffect());
	             
	        }
	    });
    	
		no.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	no.setText("Item score to 10");
	        	no.setEffect(null);
	             
	        }
	    });
		
    	GridPane.setHalignment(label, HPos.CENTER);
    	GridPane.setHalignment(yes, HPos.CENTER);
    	GridPane.setHalignment(no, HPos.CENTER);
    	grid.setAlignment(Pos.CENTER);
		grid.add(label,0,0);
		grid.add(yes,0,1);
		grid.add(no,0,2);
		grid.getStylesheets().add(Engine.class.getResource("/net/assets/menu/Dialog.css").toString());
		Scene scene = new Scene(grid,650,550);
		

				
		dialogStage.setScene(scene);
		dialogStage.show();
		
	}
	
	
		
}
