package net;

import java.awt.Dimension;
import java.awt.SplashScreen;
import java.awt.Toolkit;

import net.engine.*;
import net.engine.introUI.GameIntroUI;
import net.engine.introUI.HouseIntroUI;
import net.engine.introUI.RoadIntroUI;
import net.engine.introUI.SchoolIntroUI;
import net.engine.musicHandlers.MusicThread;
import net.engine.musicHandlers.TitleMusic;
import net.engine.resourceHandlers.MainMenuImageHandler;
//JavaFX imports
import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Start extends Application{


	public final String version = "v1.1.9";

	//public static Font BIRTHFONT;
	
	static boolean playMusic = false;
	
	
	static Engine gameEngine = new Engine();
	public static  ScrollPane scroll;
	public static AssetLoader assetLoader = new AssetLoader();
	public static Thread thread2 = new TitleMusic(); 
	public static MainMenuImageHandler mainMenuHandler = new MainMenuImageHandler();
	public static int sceneStartHeight = GetScreenWorkingHeight()-25;
	public static int sceneStartWidth = GetScreenWorkingWidth();
	public static Thread thread = new MusicThread();
	public boolean running = true;
	public static Scene gameMenu = new Scene(setUpCoreGrid(),sceneStartWidth,sceneStartHeight);
	public static Scene mainMenu = new Scene(gameEngine.setUpMainMenu(),sceneStartWidth,sceneStartHeight);
	public static Scene newLevelMenu = new Scene(gameEngine.setUpNewLevelMenu(),sceneStartWidth,sceneStartHeight);
	public static Scene newWorldMenu = new Scene(gameEngine.setUpNewWorldMenu(),sceneStartWidth,sceneStartHeight);
	public static Scene loadWorldMenu = new Scene(gameEngine.setUpLoadWorldMenu(),sceneStartWidth,sceneStartHeight);
	public static Scene optionsMenu = new Scene(gameEngine.setUpOptionMenu(),sceneStartWidth,sceneStartHeight);
	public static Scene introMenu = new Scene(gameEngine.setupIntro(),sceneStartWidth,sceneStartHeight);
	public static Scene helpMenu = new Scene(gameEngine.setUpHelpGrid(),sceneStartWidth, sceneStartHeight);
	public static Scene selectionMenu = new Scene(returnScenarioSelectionMenu(),sceneStartWidth, sceneStartHeight);
	public static String documentBase;
	//Loads Images to create tiles

	static int curMainMenuItemSelection = 1;
	static int mainMenuMaxListNumber = 5;

	static int curNewLevelItemSelection = 1;
	static int newLevelMaxListNumber = 2;

	static int curOptionsItemSelection = 1;
	static int curOptionsMaxListNumber = 3;

	
	
	public static Stage primaryStage;


	public static Engine returnGameEngine(){
		return gameEngine;
	}

	public static Stage returnPrimaryStage(){
		return primaryStage;
	}

	
	public static boolean isRight(double touchX, double touchY, double stageHeight, double stageWidth){
		System.out.println(touchX + " : " + sceneStartWidth*.75);
		if(touchX > sceneStartWidth*.75){
			
			Engine.updateK(KeyCode.RIGHT);
			return true;
			
		}
		
		
		
		
		return false;
	}
	public static boolean isLeft(double touchX, double touchY, double stageHeight, double stageWidth){
		if(touchX < sceneStartWidth*.25){
			Engine.updateK(KeyCode.LEFT);
			return true;
				
		}
		return false;
	}
	public static boolean isUp(double touchX, double touchY, double stageHeight, double stageWidth){
		if(touchX > sceneStartWidth*.75 == false && touchX < sceneStartWidth*.25  == false){
			
				
			if(touchY < sceneStartHeight/2){
			
				Engine.updateK(KeyCode.UP);
				return true;
			}
		}
		
		return false;
	}
	public static boolean isDown(double touchX, double touchY, double stageHeight, double stageWidth){
		if(touchX > sceneStartWidth*.75 == false && touchX < sceneStartWidth*.25  == false){
			
			
			if(touchY > sceneStartHeight * .5){
			
				Engine.updateK(KeyCode.DOWN);
				return true;
			}
		}
		
		return false;
	}
	public static void handleTabletTouch(TouchEvent event){
		
		double stageHeight = primaryStage.getHeight();
		double stageWidth = primaryStage.getWidth();
		
		

		double x = event.getTouchPoint().getSceneX();
		double y = event.getTouchPoint().getSceneY();
		System.out.println(isRight(x ,y ,  stageHeight, stageWidth));
		isLeft(x ,y ,  stageHeight, stageWidth);
		isDown(x ,y ,  stageHeight, stageWidth);
		System.out.println(isUp(x ,y ,  stageHeight, stageWidth));
		
	}
	
	public static void handleKey(KeyEvent e){
		Engine.updateK(e.getCode());
		
		
		
	}

	//@Override public void init() { System.out.println("INIT"); };
	@Override
	public void start(Stage primaryStage) {
//com.sun.javafx.application.tkExit()
		
		//Hello
		Engine.buildControlScene();
		if(Engine.gridSize < 15){
			Engine.controlScene = Engine.tabletControl;
			Engine.updateRate = 1250;
			Engine.time = 45;
			mainMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/TakeCoverMenuSmall.css").toString());
			gameMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/MainMenuSmall.css").toString());
			newLevelMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/MainMenuSmall.css").toString());
			newWorldMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/MainMenuSmall.css").toString());
			loadWorldMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/MainMenuSmall.css").toString());
			optionsMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/TakeCoverMenuSmall.css").toString());
			helpMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/OptionsMenu.css").toString());
			selectionMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/MainMenuSmall.css").toString());
			

		}else {
			System.out.println("Hit!");
			Engine.controlScene = Engine.computerControl;
			Engine.updateRate = 750;
			mainMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/TakeCoverMenu.css").toString());
			gameMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/MainMenu.css").toString());
			newLevelMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/MainMenu.css").toString());
			newWorldMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/MainMenu.css").toString());
			loadWorldMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/MainMenu.css").toString());
			optionsMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/TakeCoverMenu.css").toString());
			helpMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/OptionsMenu.css").toString());
			selectionMenu.getStylesheets().add(getClass().getResource("/net/assets/menu/MainMenu.css").toString());

		}
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent iEvent) {
				com.sun.javafx.application.PlatformImpl.tkExit();
				Platform.exit();
			}
			
				
		});
		Start.primaryStage = primaryStage;

		documentBase = getHostServices().getDocumentBase();
		javafx.scene.text.Font BIRTHFONT = javafx.scene.text.Font.loadFont(getClass().getResourceAsStream("/net/BIRTH.ttf"), 10);
		Engine.BIRTHFONT = BIRTHFONT;


		Engine.setCurrentMenu(1);



		Engine.init();

		//Keyboard Handlers

		gameMenu.setOnTouchPressed(new EventHandler<TouchEvent>() {
            @Override public void handle(TouchEvent event) {
            	handleTabletTouch(event);
            }
        });

		gameMenu.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
            	handleKey(event);
            	System.out.println("Key Pressed");
            }
        });

		//Main Menu Handler
		/*
		mainMenu.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent mainMenuHandler){

				if(mainMenuHandler.getCode() == KeyCode.UP || mainMenuHandler.getCode() == KeyCode.W){
					if(curMainMenuItemSelection-1 != 0){
						if(curMainMenuItemSelection-1 == 1){


						} else if( curMainMenuItemSelection-1 == 2){

						} else if( curMainMenuItemSelection-1 == 3){
							Engine.mainMenuLoadWorld.setText(">Help<");
							Engine.mainMenuOptions.setText("Options");
						} else if( curMainMenuItemSelection-1 == 4){
							Engine.mainMenuOptions.setText(">Options<");
							Engine.mainMenuExit.setText("Exit");
						} else if( curMainMenuItemSelection == 1){
							Engine.mainMenuExit.setText(">Exit<");

						}

						curMainMenuItemSelection--;
					}


				} else if(mainMenuHandler.getCode() == KeyCode.DOWN || mainMenuHandler.getCode() == KeyCode.S){

					if(curMainMenuItemSelection+1 <= mainMenuMaxListNumber){
						if(curMainMenuItemSelection+1 == 1){
							Engine.mainMenuNewLevel.setText(">New Level<");

						} else if( curMainMenuItemSelection+1 == 2){
							Engine.mainMenuNewWorld.setText(">New World<");
							Engine.mainMenuNewLevel.setText("New Level");
						} else if( curMainMenuItemSelection+1 == 3){
							Engine.mainMenuLoadWorld.setText(">Help<");
							Engine.mainMenuNewWorld.setText("New World");
						} else if( curMainMenuItemSelection+1 == 4){
							Engine.mainMenuOptions.setText(">Options<");
							Engine.mainMenuLoadWorld.setText("Help");
						} else if( curMainMenuItemSelection+1 == 5){
							Engine.mainMenuExit.setText(">Exit<");
							Engine.mainMenuOptions.setText("Options");
						}


						curMainMenuItemSelection++;
					}


				} else if(mainMenuHandler.getCode() == KeyCode.ENTER){

					if(curMainMenuItemSelection == 1){

						Engine.setCurrentMenu(2);
						primaryStage.setScene(newLevelMenu); 

					}  else if(curMainMenuItemSelection == 2 ){
						Engine.setCurrentMenu(3);
						primaryStage.setScene(newWorldMenu); 

					}  else if(curMainMenuItemSelection == 3 ){
						Engine.setCurrentMenu(5);
						primaryStage.setScene(helpMenu); 

					}  else if(curMainMenuItemSelection == 4 ){
						Engine.setCurrentMenu(4);
						primaryStage.setScene(optionsMenu); 

					} else if(curMainMenuItemSelection == 5 ){
						Engine.threadRunning = false;
						Engine.musicState = false;
						thread.interrupt();
						primaryStage.close();
					}

				}





			}
		});



*/
		newLevelMenu.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent newLevelMenuHandler) {

				if(newLevelMenuHandler.getCode() == KeyCode.BACK_SPACE){
					primaryStage.setScene(mainMenu);   


				} else if(newLevelMenuHandler.getCode() == KeyCode.UP || newLevelMenuHandler.getCode() == KeyCode.W){
					if(curNewLevelItemSelection-1 != 0){
						if(curNewLevelItemSelection == 2){
							Engine.newLevelFirstOption.setText(">House Scenario<");
							Engine.newLevelSecondOption.setText("Dev Test Level");

						}

						curNewLevelItemSelection--;

					}


				} else if(newLevelMenuHandler.getCode() == KeyCode.DOWN || newLevelMenuHandler.getCode() == KeyCode.S){

					if(curNewLevelItemSelection+1 <= newLevelMaxListNumber){
						if(curNewLevelItemSelection == 1){
							Engine.newLevelFirstOption.setText("House Scenario");
							Engine.newLevelSecondOption.setText(">Dev Test Level<");

						}

						curNewLevelItemSelection++;

					}

				} else if(newLevelMenuHandler.getCode() == KeyCode.ENTER){
					if(curNewLevelItemSelection == 1){
						GameIntroUI.runUI();

						//Engine.showStartDialog();
					} else if(curNewLevelItemSelection == 2){
						Engine.init();
						Engine.setCurrentMenu(6);
						Engine.loadRyanLevel();
						primaryStage.setScene(gameMenu);

					}


				}




			}
		});



		newWorldMenu.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent newWorldMenuHandler) {


				if(newWorldMenuHandler.getCode() == KeyCode.BACK_SPACE){
					primaryStage.setScene(mainMenu);   


				}




			}
		});


		helpMenu.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent loadWorldMenuHandler) {



				if(loadWorldMenuHandler.getCode() == KeyCode.BACK_SPACE){
					primaryStage.setScene(mainMenu);   


				}



			}
		});


		optionsMenu.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent newLevelMenuHandler) {

				if(newLevelMenuHandler.getCode() == KeyCode.BACK_SPACE){
					primaryStage.setScene(mainMenu);   


				} else if(newLevelMenuHandler.getCode() == KeyCode.UP || newLevelMenuHandler.getCode() == KeyCode.W){
					if(curOptionsItemSelection-1 != 0){
						if(curOptionsItemSelection == 2){
							Engine.musicOption.setText(">Music: " + Engine.musicState + "<");
							Engine.backOption.setText("Back");

						}

						curOptionsItemSelection--;

					}


				} else if(newLevelMenuHandler.getCode() == KeyCode.DOWN || newLevelMenuHandler.getCode() == KeyCode.S){

					if(curOptionsItemSelection+1 <= curOptionsMaxListNumber){
						if(curOptionsItemSelection == 1){
							Engine.musicOption.setText("Music: " + Engine.musicState);
							Engine.backOption.setText(">Back<");

						}

						curOptionsItemSelection++;

					}

				} else if(newLevelMenuHandler.getCode() == KeyCode.ENTER){
					if(curOptionsItemSelection == 1){
						Engine.toggleMusicState();
						thread.interrupt();
						Engine.showMusicState();
						Engine.musicOption.setText(">Music: " + Engine.musicState + "<");
					} else if(curOptionsItemSelection == 2){

						setMainMenu();
					}


				}




			}
		});

		optionsMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub



				if(arg0.getTarget().toString().contains("Music")){
					Engine.toggleMusicState();
					thread.interrupt();
					Engine.showMusicState();
					Engine.musicOption.setText(">Music: " + Engine.musicState + "<");
				}
				else if(arg0.getTarget().toString().contains("Back")){
					setMainMenu();
				}
			}


		});


		/*gameMenu.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent gameBoardHandler) {



			
	

			}
		});
*/		introMenu.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent gameBoardHandler) {


				if(gameBoardHandler.getCode() == KeyCode.ENTER){

					runGameMenu();

				}


			}
		});



		this.primaryStage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
		primaryStage.setTitle("Take Cover - " + version);
		System.out.println("DEBUG");
		primaryStage.setScene(mainMenu);     	
		
		primaryStage.show();
	}

	protected void runIntro() {
		// TODO Auto-generated method stub
		primaryStage.setScene(introMenu);


	}

	public void runGameMenu(){

	}

	public static void setMainMenu(){
		primaryStage.setScene(mainMenu);
	}
	public void close(){
		com.sun.javafx.application.PlatformImpl.tkExit();
		Platform.exit();
	}

	public void setUpHelp(){
		primaryStage.setScene(helpMenu);
	}

	//Engine Methods


	
	public static BorderPane setUpCoreGrid(){
		
		

	    
		
		BorderPane coreGrid = new BorderPane();
		Engine.status = new GridPane();
		Engine.status.setStyle("-fx-background-color:rgba(0, 0, 0, 0.1)");
		Engine.itemLabel.setId("statusLabel");
		Engine.objLabel.setId("statusLabel");
		Engine.status.add(Engine.itemLabel,0,1);
		GridPane.setHalignment(Engine.itemLabel, HPos.CENTER);
		Engine.status.add(Engine.objLabel,0,0);
	    Image compass = new Image( Start.class.getResource("/net/assets/menu/Compass.PNG").toString());
		 
	    ImageView compassView1 = new ImageView(compass);
	    compassView1.setFitHeight(100);
	    compassView1.setFitWidth(100);
		Engine.status.add(compassView1,1,0);
		/*Button back = new Button("Exit");
		back.setStyle("-fx-background-color: #ff00ff;");
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {

				setMainMenu();

			}

		});
		back.setScaleX(1.10);
		back.setScaleY(1.10);



		//  	buttons.set
		buttons.add(back,1,0);

*/
		// 	buttons.set

	
	
		
		
		coreGrid.setTop(Engine.status);
		Engine.status.setAlignment(Pos.BOTTOM_CENTER);
		coreGrid.setCenter(Engine.setUpGameGrid());
		//coreGrid.setRight(setUpStatusGrid());

		return coreGrid;
	}

	//End of Engine Methods


	public static int GetScreenWorkingWidth() {
		return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
	}

	public static int GetScreenWorkingHeight() {
		return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	}


	public static GridPane returnScenarioSelectionMenu(){
		GridPane selectionPane = new GridPane();

		selectionPane.setAlignment(Pos.TOP_CENTER);
		ImageView title = new ImageView(mainMenuHandler.title);
		Label scenario1 = new Label("House Scenario");
		Label scenario2 = new Label("School Scenario");
		Label scenario3 = new Label("Road Scenario");
		Label exitMenu = new Label("Exit to Main Menu");
		GridPane.setHalignment(title, HPos.CENTER);
		GridPane.setHalignment(scenario1, HPos.CENTER);
		GridPane.setHalignment(scenario2, HPos.CENTER);
		GridPane.setHalignment(scenario3, HPos.CENTER);
		GridPane.setHalignment(exitMenu, HPos.CENTER);

		selectionPane.setHgap(10);
		selectionPane.setVgap(10);
		selectionPane.setPadding(new Insets(0, 10, 0, 10));
		selectionPane.add(title, 0, 0);
		selectionPane.add(scenario1, 0, 1);
		selectionPane.add(scenario2, 0, 2);
		selectionPane.add(scenario3, 0, 3);
		selectionPane.add(exitMenu, 0, 4);

		scenario1.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {

				scenario1.setText(">" + "House Scenario" + "<");
				scenario1.setEffect(Engine.returnEnteredEffect());

			}

		});

		scenario1.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {

				scenario1.setText("House Scenario");
				scenario1.setEffect(null);

			}

		});

		scenario1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				HouseIntroUI.runIntro();


			}

		});

		scenario2.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {

				scenario2.setText(">" + "School Scenario" + "<");
				scenario2.setEffect(Engine.returnEnteredEffect());

			}

		});

		scenario2.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {

				scenario2.setText("School Scenario");
				scenario2.setEffect(null);

			}

		});

		scenario2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				//primaryStage.setScene(mainMenu);  
				SchoolIntroUI.runIntro();

			}

		});

		scenario3.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {

				scenario3.setText(">" + "Road Scenario" + "<");
				scenario3.setEffect(Engine.returnEnteredEffect());

			}

		});

		scenario3.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {

				scenario3.setText("Road Scenario");
				scenario3.setEffect(null);
				
			}

		});

		scenario3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				//primaryStage.setScene(mainMenu);  
				RoadIntroUI.runIntro();

			}

		});

		exitMenu.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {

				exitMenu.setText(">" + "Exit to Main Menu" + "<");
				exitMenu.setEffect(Engine.returnEnteredEffect());

			}

		});

		exitMenu.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {

				exitMenu.setText("Exit to Main Menu");
				exitMenu.setEffect(null);

			}

		});

		exitMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				primaryStage.setScene(mainMenu);  


			}

		});
		return selectionPane;
	}
	
	public static void playTitleMusic(){
		if(playMusic = true){
			thread2.start();
		}
	}
	
	public static void stopTitleMusic(){
		thread2.interrupt();
		System.out.println("Interrupt!");
	}
	public static void main(String[] args) {
		final SplashScreen splash = SplashScreen.getSplashScreen();
		if(splash != null){
			splash.close();
		}
		
		
		System.out.println(args.length);
		
		if(args.length == 1){
			if(args[0].equals("-help")){
				System.out.println("[name].jar [-help]:[false/False] [integer]");
				System.out.println("First argument can either display help message or with false/False turn off music");
				System.out.println("Second argument determines a fixed gridsize for the gameboard");
			}
		}
		
		
		if(args.length == 1){
			if(args[0].equals("false") || args[0].equals( "False")){
				playMusic = false;
				System.out.println("No Music!");
			}else{
				
				playTitleMusic();
			}
			
		}
		
		
		if(args.length == 2){
			Engine.gridSize = Integer.parseInt(args[1]);
		}else {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double width = screenSize.getWidth();
			Engine.gridSize = (int) Math.round(width/100);
			
		}

	
		launch(args);
		
	}

}

