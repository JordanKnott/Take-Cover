package net.engine;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import net.Start;
import net.engine.introUI.SelectIntroUI;
import net.engine.overview.DetailedOverviewUI;
import net.thenightwolf.console.JConsole;
import javafx.embed.swing.SwingNode;
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

public class Debug{

	


	public static volatile boolean terminalActive = false;

	private SwingNode swingNode ;

	public static Stage terminal;

	public static JConsole console;
	
	
	public void introDebug(){

		dialogDebug();


	}


	
	
	public void dialogDebug(){
		
		Stage dialogStage = new Stage(StageStyle.UNDECORATED);
		terminal = dialogStage;
		GridPane grid = new GridPane();
		terminal.initOwner(Start.primaryStage);

	    swingNode = new SwingNode();

	
	    JConsole console = new JConsole(475,50);
	    Debug.console = console;

		

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				swingNode.setContent(console);
				
			}
		});


		
		grid.add(swingNode, 0, 0);
		
		grid.getStylesheets().add(Engine.class.getResource("/net/assets/menu/Dialog.css").toString());
		Scene scene = new Scene(grid,475,250);
		
		
		terminal.setScene(scene);
		terminal.show();

	}




}
