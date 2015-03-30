package net.engine;


import java.lang.reflect.InvocationTargetException;
import java.util.Timer;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import net.Start;
import net.engine.introUI.GameIntroUI;
import net.engine.introUI.HouseIntroUI;
import net.engine.introUI.RoadIntroUI;
import net.engine.introUI.ScenarioSelect;
import net.engine.introUI.ScoreIntroUI;
import net.engine.introUI.SelectIntroUI;
import net.engine.musicHandlers.Sound;
import net.engine.overview.DetailedOverviewUI;
import net.engine.overview.House2OverviewUI;
import net.engine.overview.HouseOverviewUI;
import net.engine.overview.RoadOverviewUI;
import net.engine.overview.SchoolOverviewUI;
import net.engine.resourceHandlers.MainMenuImageHandler;
import net.engine.resourceHandlers.entities.PlayerTileImageHandler;
import net.engine.resourceHandlers.tiles.walls.PlayerImageHandler;
import net.engine.tasks.AppTask;
import net.engine.tasks.LoadWorldTask;
import net.engine.tasks.NewWorldTask;
import net.engine.tasks.OptionsTask;
import net.entities.Player;
import net.entities.SchoolEntity;
import net.items.Item;
import net.levels.Level;
import net.levels.ScenarioHouse2Level;
import net.levels.ScenarioHouseLevel;
import net.levels.ScenarioRoad2Level;
import net.levels.ScenarioRoadLevel;
import net.levels.ScenarioSchoolLevel;
import net.tiles.Tile;


public class Engine {

	
	public static Debug debug = new Debug();
	
	public static boolean inGame;         
	public static Scene controlScene;
	
	public static Scene tabletControl;
	public static Scene computerControl;
	public static int updateRate; 
	
	public static int gridSize;
	public static int time = 30;
	public static boolean updateInvCount = true;
	public static Font BIRTHFONT;
	public static GridPane status;
	public static Button yesButton = new Button("Yes");
	public static Button noButton = new Button("No");
	public static Label specialLabel = new Label();
	public static boolean returnBool;
	public static boolean returnBool2 = false;
	public static String EngineVersion = "1.0.0";
	public static int I;
	public static int X;
	public static boolean threadRunning = true;
	public static boolean animationState = true;
	public static TextArea chatLog = new TextArea() ;
    public static GameBoard gameBoard = new GameBoard();
	public static ImageBoard imageBoard = new ImageBoard();
	public static boolean optionsLocked = false;
	public static boolean musicState = true;
	//House2
	public static boolean isScenario1Locked = false;
	//Road
	public static boolean isScenario2Locked = false;
	//School
	public static boolean isScenario3Locked = true;
	
	public static boolean isScenario1Done = false;
	public static boolean isScenario2Done = false;
	public static boolean isScenario3Done = false;
	
	public static int curDialogItem = 1;
	
	public static ScoreBoard score = new ScoreBoard();
	
	public static int animationSpeed = 500;
	
	//Main Menu Global Handles
	public static GridPane mainMenu = new GridPane();
	public static Label mainMenuNewLevel = new Label();
	
	public static Label mainMenuLoadWorld = new Label();
	public static Label mainMenuOptions = new Label();
	public static Label mainMenuExit = new Label();	
	
	public static Label helpLine1 = new Label();
	public static Label helpLine2 = new Label();
	public static Label helpLine3 = new Label();
	public static Label helpLine4 = new Label();
	public static Label helpLine5 = new Label();	
	
	public static Transition pathTransition,
	   pathTransition2,
	   pathTransition3,
	   pathTransition4,
	   pathTransition5 = null;
	
	//New Level Menu Global Handles
	public static GridPane newLevelMenu = new GridPane();
	public static Label newLevelFirstOption = new Label();
	public static Label newLevelSecondOption = new Label();
	
	public static Timer timer = new Timer();
	
	//New World Menu Global Handles
	public static GridPane newWorldMenu = new GridPane();
	
	//Load World Menu Global Handles
	public static GridPane loadWorldMenu = new GridPane();
	
	//Options Menu Global Handles
	public static GridPane optionsMenu = new GridPane();
	public static Label musicOption = new Label();
	public static Label gridSizeOption = new Label("Grid Size: " + gridSize);
	
	public static Label backOption = new Label();
	
	//Global Image Handlers
	public static PlayerImageHandler playerImageHandler = new PlayerImageHandler();
	public static MainMenuImageHandler mainMenuHandler = new MainMenuImageHandler();
	
	//Global Title Image Handle
	public static ImageView mainMenuTitle = new ImageView(mainMenuHandler.title);
	public static ImageView mainMenuTitle2 = new ImageView(mainMenuHandler.title);
	public static ImageView mainMenuTitle3 = new ImageView(mainMenuHandler.title);
	public static ImageView mainMenuTitle4 = new ImageView(mainMenuHandler.title);
	public static ImageView mainMenuTitle5 = new ImageView(mainMenuHandler.title);
	public static ImageView mainMenuTitle6 = new ImageView(mainMenuHandler.title);

	public static GridPane introMenu = new GridPane();

	
	public static int dialogIndex = 0;
	
	public static PlayerTileImageHandler playerIHandler = new PlayerTileImageHandler();
	public static Image playerTileImage = playerIHandler.returnImage();
	

	
	private static int currentMenu = 1;
	//Menu ids
	//1 - Main Menu
	//2 - New Level Menu
	//3 - New World Menu
	//4 - Load World Menu
	//5 - Options
	//6 - Game Board Screen
	//7 - Inventory?
	
	//Level Objects
	
	
	
	     //ScenarioSchoolLevel();
	

	
	static Level newRoad2Level = new ScenarioRoad2Level();
    //Creates new Player Object
    static Player mainPlayer = new Player();
    public static Label itemLabel = new Label("Items in bag: 0/10");
    public static Label objLabel = new Label("Objective: Gather items for your emergency preparedness kit");
    static Sound music = new Sound();

	public static boolean inScenario = false;
	
    //returns the gameboard
	public static GameBoard getGameBoard(){
		return gameBoard;
	}
	//returns the image board
	public static ImageBoard getImageBoard(){
		return imageBoard;
	}
	//returns the tile image handler
	public static PlayerImageHandler getPlayerImageHandler(){
		return playerImageHandler;
		
	}
	
	
	public static void log(String i){
		chatLog.appendText(i + "\n");
	}
	
	//Loads dev level
	public static void LoadHouseLevel(){
		//calls newlevel methods to add tiles to the gameboard
		Start.primaryStage.setScene(Start.gameMenu);
		mainPlayer.resetPlayer();
		Level newLevel = new ScenarioHouseLevel();
		newLevel.populateGameBoard(gameBoard);
		redraw();
		currentMenu = 6;
		drawAndCheckPlayerTexture();
		startGameMusic();
	}
	public static void loadHouse2Level(){
		//calls newlevel methods to add tiles to the gameboard
		currentMenu = 6;
		mainPlayer.resetPlayer();
		
		Start.primaryStage.setScene(Start.gameMenu);
		Level newHouse2Level = new ScenarioHouse2Level();
		newHouse2Level.populateGameBoard(gameBoard);
		redraw();
		drawAndCheckPlayerTexture();

	}
	public static void loadRyanLevel(){
		//calls newlevel methods to add tiles to the gameboard
		Start.primaryStage.setScene(Start.gameMenu);
		//newRLevel.populateGameBoard(gameBoard);
		redraw();
		drawAndCheckPlayerTexture();

	}
	public static void loadRoadLevel(){
		currentMenu = 6;
		mainPlayer.setCurrentLevelID(3);
		mainPlayer.resetPlayer();
		Start.primaryStage.setScene(Start.gameMenu);
		Level newRLevel = new ScenarioRoadLevel();
		newRLevel.populateGameBoard(gameBoard);
		redraw();
		drawAndCheckPlayerTexture();
	}
	public static void loadRoad2Level(){
		currentMenu = 6;
		mainPlayer.setCurrentLevelID(4);
		mainPlayer.resetPlayer();
		Start.primaryStage.setScene(Start.gameMenu);
		newRoad2Level.populateGameBoard(gameBoard);
		redraw();
		drawAndCheckPlayerTexture();
	}
	public static void loadSchoolLevel(){
		//TODO
		currentMenu = 6;
		mainPlayer.resetPlayer();
		Start.primaryStage.setScene(Start.gameMenu);
		Level newSLevel = new ScenarioSchoolLevel();
		newSLevel.populateGameBoard(gameBoard);
		redraw();
		drawAndCheckPlayerTexture();
	}
	//Level Redraw Update
	
	public static void redraw(){
		if(mainPlayer.hasWon()){
		//	setGameOver("W");
			
		}
		
    	for( int i = 0; i < 75; i++){
    		for( int x = 0; x < 45 ; x++){
    			ImageBoard.imageTileArray[i][x].setImage(GameBoard.gameBoardArray[i][x].returnTileImage("redraw"));

    		}
    	}
    	drawAndCheckPlayerTexture();
	}

	
	public static void checkPos(int pX,int pY,int nX,int nY){
		
		if(GameBoard.gameBoardArray[nX][nY].isSpecial()){
			GameBoard.gameBoardArray[nX][nY].doSpecial();
		}
		
		
		
		
	}
	
	public static void checkCompleted(){
		
		System.out.println("Engine States: " + Engine.isScenario1Done + " - " + Engine.isScenario2Done + " - " + Engine.isScenario3Done);
		
		if(Engine.isScenario1Done && Engine.isScenario2Done){
			Engine.isScenario3Locked = false;
		}
		
		
		/*if(Engine.isScenario1Done && Engine.isScenario2Done && Engine.isScenario3Done){
			ScoreIntroUI.runIntro();
			return true;
		}
		*/

	}
	
	
	
	public static void increasePlayersItemWinCount(){
		mainPlayer.increaseWinCount();
		
	}
	
	public static void decreasePlayerStorageSpace(){
		mainPlayer.decreaseCurInventorySpace();
		log("You have picked up a item!");
		//Sound soundHandler = new Sound();
		//soundHandler.playSound();
	}
	
	public static void setPlayerStorageSpace(int space){
		mainPlayer.setInvSpace(space);
	}
	public static void setGameOver(String condition){
		if(condition.equals("W")){
				showDialog(75,75,"WIN");
				Start.returnPrimaryStage().close();
		} else if(condition.equals("L")){
			
		}
	}
	public static void hasPlayerWon(){
		
		if(mainPlayer.hasWon()){
			HouseOverviewUI.runOverview();
			
		}
	}

	
	public static void activateDialog(String itemName, boolean isNeeded, Tile handle){
	
		Stage dialogStage = new Stage(StageStyle.DECORATED);
		dialogStage.initOwner(Start.primaryStage);
		GridPane grid = new GridPane();

		GridPane winGrid = new GridPane();

		winGrid.getStylesheets().add(Engine.class.getResource("/net/assets/menu/Dialog.css").toString());
		Label winLabel = new Label("");
		Label closeLabel = new Label(">Exit<");
    	GridPane.setHalignment(winLabel, HPos.CENTER);
    	GridPane.setHalignment(closeLabel, HPos.CENTER);
		winGrid.add(winLabel,0,0);
		winGrid.add(closeLabel,0,1);
		winGrid.setAlignment(Pos.CENTER);
		Scene winScene = new Scene(winGrid,450,300);
		closeLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {

            	dialogStage.close();  	
            }

    	});
		closeLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {

            	closeLabel.setEffect(Engine.returnEnteredEffect());
            	
            }

    	});
		closeLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
            	closeLabel.setEffect(null);

            	
            	
            }

    	});
		
		winScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent keyHandle){
				dialogStage.close();
			}
		});
		
		dialogIndex = 1;
		
		
		Label label = new Label(itemName);
		Label yes = new Label(">Yes<");
		Label no = new Label("No");
		yes.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Engine.decreasePlayerStorageSpace();
				handle.setPickedUp(true);
				if(isNeeded){
					winLabel.setText("Correct!");
					score.increaseItems();
				}else {
					winLabel.setText("Oops! Sorry");
				}
				
				
				hasPlayerWon();
				
				dialogStage.setScene(winScene);
				
				
			}
	        	
	        	
	    });
		
		yes.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	yes.setText("No");
	        	yes.setText(">Yes<");
	        	yes.setEffect(returnEnteredEffect());
	             
	        }
	    });
    	
		yes.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	yes.setText("Yes");
	        	yes.setEffect(null);
	             
	        }
	    });
		
		no.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub

				dialogStage.close();
			}
	        	
	        	
	    });
		no.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	yes.setText("Yes");
	        	no.setText(">No<");
	        	no.setEffect(returnEnteredEffect());
	             
	        }
	    });
    	
		no.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	no.setText("No");
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
		Scene scene = new Scene(grid,450,300);
		
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent keyHandle){

				
				
				if(keyHandle.getCode() == KeyCode.W || keyHandle.getCode() == KeyCode.UP){
					if(dialogIndex != 1){
						dialogIndex = 1;
						yes.setText(">Yes<");
						no.setText("No");
					}

				} else if(keyHandle.getCode() == KeyCode.S || keyHandle.getCode() == KeyCode.DOWN){
					if(dialogIndex != 2){
						dialogIndex = 2;
						yes.setText("Yes");
						no.setText(">No<");
					}
				
				}
			    else if(keyHandle.getCode() == KeyCode.ENTER){
				
					// TODO Auto-generated method stub
					
					if(dialogIndex == 1){
						Engine.decreasePlayerStorageSpace();
						handle.setPickedUp(true);

						if(isNeeded){
							winLabel.setText("Correct!");
							score.increaseItems();
						}else {
							winLabel.setText("Oops! Sorry");
						}
						
						
						hasPlayerWon();
						
						dialogStage.setScene(winScene);
					} else if(dialogIndex == 2){
						dialogStage.close();
					}
					
					
					
				}
				
				
			}
		});
		dialogStage.setScene(scene);
		dialogStage.show();
		
	
	}
	
	
	public static void buildControlScene(){
		
	  	GridPane helpGrid2 = new GridPane();
    	BorderPane helpPane2 = new BorderPane();
    	
    	helpGrid2.setAlignment(Pos.CENTER);
    	

    	
    	helpGrid2.setHgap(10);
    	helpGrid2.setVgap(10);
    	helpGrid2.setPadding(new Insets(0, 10, 0, 10));
    	
        
        Label label12 = new Label("Controls are: ");
        Label label22 = new Label("ASWD / Arrow Keys - Movement / Dialog Controls");
        Label label32 = new Label("Escape - Option Menu");
        Label label42 = new Label("Mouse - Option Selector");
        Label label62 = new Label("( Click me to continue )");
        
    	GridPane.setHalignment(label12, HPos.CENTER);
    	GridPane.setHalignment(label22, HPos.CENTER);
    	GridPane.setHalignment(label32, HPos.CENTER);
    	GridPane.setHalignment(label42, HPos.CENTER);
    
    	GridPane.setHalignment(label62, HPos.CENTER);
  

    	helpGrid2.add(label12,0,0);
        helpGrid2.add(label22,0,1);
        helpGrid2.add(label32,0,2);
        helpGrid2.add(label42,0,3);


        helpGrid2.add(label62,0,4);
        helpGrid2.setStyle("-fx-background-color:rgba(0, 0, 0, 0.5)");
        
    	
    	helpPane2.setCenter(helpGrid2);
    	helpPane2.setPadding(new Insets(150,150,150,150));

		computerControl = new Scene(helpPane2,Start.sceneStartWidth,Start.sceneStartHeight);
		if(Engine.gridSize < 15){
			computerControl.getStylesheets().add(RoadIntroUI.class.getResource("/net/assets/menu/MainMenuSmall.css").toString());

		}else{		
			computerControl.getStylesheets().add(RoadIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
		}
		
		label62.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
            	Engine.LoadHouseLevel();
            	
            	
            }

    	});
		label62.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {

            	label62.setEffect(Engine.returnEnteredEffect());
            	
            }

    	});
		label62.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
            	label62.setEffect(null);

            	
            	
            }

    	});
		//TABLET CONTROLS
		
		GridPane helpGrid = new GridPane();
    	BorderPane helpPane = new BorderPane();
    	helpGrid.setAlignment(Pos.CENTER);
    	helpGrid.setHgap(10);
    	helpGrid.setVgap(10);
    	helpGrid.setPadding(new Insets(0, 10, 0, 10));
    	
        
        Label label1 = new Label("Tablet Controls - Touch the screen to move");
        Label label2 = new Label("Yellow Area - Up");
        Label label3 = new Label("Gray Area - Right");
        Label label4 = new Label("Green Area - Down");
        Label label5 = new Label("Blue Area - Left");
		String overviewImagePath =  Engine.class.getResource("/net/assets/menu/TabletControls.jpg").toString();
		
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
        
        helpGrid.add(iView,0,5);
        helpGrid.add(label6,0,6);
    	helpGrid.setStyle("-fx-background-color:rgba(0, 0, 0, 0.5)");
        
    	
    	helpPane.setCenter(helpGrid);
    	helpPane.setPadding(new Insets(150,150,150,150));
    	
		label6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {

            	Engine.LoadHouseLevel(); 	
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
		
		tabletControl = new Scene(helpPane,Start.sceneStartWidth,Start.sceneStartHeight);
		if(Engine.gridSize < 15){
			tabletControl.getStylesheets().add(RoadIntroUI.class.getResource("/net/assets/menu/MainMenuSmall.css").toString());

		}else{		
			tabletControl.getStylesheets().add(RoadIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
		}
		
		


	
	}
		
	
	
	public static void activateSaveDialog(Tile handle){
		Stage dialogStage = new Stage(StageStyle.DECORATED);
		dialogStage.initOwner(Start.primaryStage);
		GridPane grid = new GridPane();

		dialogIndex = 1;
		
		
		
		Label label = new Label("Save this schoolmate?");
		Label yes = new Label(">Yes<");
		Label no = new Label("No");
		yes.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				handle.setInactive();
				score.increaseSchool();
				dialogStage.close();
				
				
			}
	        	
	        	
	    });
		
		yes.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	yes.setText("No");
	        	yes.setText(">Yes<");
	        	yes.setEffect(returnEnteredEffect());
	             
	        }
	    });
    	
		yes.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	yes.setText("Yes");
	        	yes.setEffect(null);
	             
	        }
	    });
		
		no.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub

				dialogStage.close();
			}
	        	
	        	
	    });
		no.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	yes.setText("Yes");
	        	no.setText(">No<");
	        	no.setEffect(returnEnteredEffect());
	             
	        }
	    });
    	
		no.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	no.setText("No");
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
		Scene scene = new Scene(grid,550,250);
		curDialogItem = 1;
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent keyHandle){

				
				
				
				
				if(keyHandle.getCode() == KeyCode.W || keyHandle.getCode() == KeyCode.UP){
					if(dialogIndex != 1){
						dialogIndex = 1;
						yes.setText(">Yes<");
						no.setText("No");
					}

				} else if(keyHandle.getCode() == KeyCode.S || keyHandle.getCode() == KeyCode.DOWN){
					if(dialogIndex != 2){
						dialogIndex = 2;
						yes.setText("Yes");
						no.setText(">No<");
					}
				
				} else if(keyHandle.getCode() == KeyCode.ENTER){
					// TODO Auto-generated method stub
					
					if(dialogIndex == 1){
						handle.setInactive();
						score.increaseSchool();
						dialogStage.close();
						
					} else if(dialogIndex == 2){
						dialogStage.close();
					}
					
					
					
				}
				
				
			}
		});
		dialogStage.setScene(scene);
		dialogStage.show();
		
	
	}
	
	public static void activateTakeCoverDialog(boolean isSafe, int ID){
		
		Stage dialogStage = new Stage(StageStyle.DECORATED);
		dialogStage.initOwner(Start.primaryStage);
		GridPane grid = new GridPane();
	
		
		
		dialogIndex = 1;
		
		Label label = new Label("Take Cover?");
		Label yes = new Label(">Yes<");
		Label no = new Label("No");
		yes.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				Engine.inGame = false;
				if(isSafe){
					score.increaseScenario();
				}
				if(ID == 3){
					isScenario2Done = true;
					RoadOverviewUI.runOverview();
				}else if(ID == 5){
					isScenario1Done = true;
					House2OverviewUI.runOverview();
				}else if(ID == 2){
					isScenario3Done = true;
					SchoolOverviewUI.runOverview();
				}
				checkCompleted();
				
				dialogStage.close();
				Engine.inScenario = false;
				
				
				
			}
	        	
	        	
	    });
		
		yes.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	yes.setText("No");
	        	yes.setText(">Yes<");
	        	yes.setEffect(returnEnteredEffect());
	             
	        }
	    });
    	
		yes.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	yes.setText("Yes");
	        	yes.setEffect(null);
	             
	        }
	    });
		
		no.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub

				dialogStage.close();
			}
	        	
	        	
	    });
		no.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	yes.setText("Yes");
	        	no.setText(">No<");
	        	no.setEffect(returnEnteredEffect());
	             
	        }
	    });
    	
		no.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	no.setText("No");
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
		Scene scene = new Scene(grid,400,250);
		
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent keyHandle){

				
				
				
				
				
				
				if(keyHandle.getCode() == KeyCode.W || keyHandle.getCode() == KeyCode.UP){
					if(dialogIndex != 1){
						dialogIndex = 1;
						yes.setText(">Yes<");
						no.setText("No");
					}

				} else if(keyHandle.getCode() == KeyCode.S || keyHandle.getCode() == KeyCode.DOWN){
					if(dialogIndex != 2){
						dialogIndex = 2;
						yes.setText("Yes");
						no.setText(">No<");
					}
				
				} else if(keyHandle.getCode() == KeyCode.ENTER){
					// TODO Auto-generated method stub
					
					if(dialogIndex == 1){
						
						if(isSafe){
							score.increaseScenario();
						}
						if(ID == 3){
							isScenario2Done = true;
							RoadOverviewUI.runOverview();
						}else if(ID == 5){
							isScenario1Done = true;
							House2OverviewUI.runOverview();
						}else if(ID == 2){
							isScenario3Done = true;
							SchoolOverviewUI.runOverview();
						}
						checkCompleted();
						
						dialogStage.close();
						Engine.inScenario = false;
						Engine.inGame = false;
					
						
					} else if(dialogIndex == 2){
						dialogStage.close();
					}
					
					
					
				}
				
				
			}
		});
		dialogStage.setScene(scene);
		dialogStage.show();
		
		
	}
	
	//KeyBoard Update
public static String updateK(KeyCode t){

		
		if( currentMenu == 5){

		} else if(currentMenu == 6){
			updateStatus();
			hasPlayerWon();
			if (t == KeyCode.UP || t == KeyCode.W) {
			if(mainPlayer.returnPlayerY()-1 != -1){
				if(!GameBoard.gameBoardArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()-1].causesCollision())
				{
					checkPos(mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY(),mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY()-1);
					mainPlayer.setPlayerCords(mainPlayer.returnPlayerX(), mainPlayer.returnPlayerY()-1);	
					
					System.out.println(mainPlayer.returnPlayerX() + " + " + mainPlayer.returnPlayerY());
					redraw();	
				
				}
				
			}
			
			return "up";
    	
		} else if(t  == KeyCode.DOWN || t  == KeyCode.S) {
			if(mainPlayer.returnPlayerY()+1 <= gameBoard.returnGridMaxY()-1){
				if(!GameBoard.gameBoardArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()+1].causesCollision())
				{
					
					checkPos(mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY(),mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY()+1);
					mainPlayer.setPlayerCords(mainPlayer.returnPlayerX(), mainPlayer.returnPlayerY()+1);
					
					redraw();
				}
			}
				
			return "down";
    		
		} else if(t  == KeyCode.LEFT || t  == KeyCode.A) {
			if(mainPlayer.returnPlayerX()-1 != -1){
				if(!GameBoard.gameBoardArray[mainPlayer.returnPlayerX()-1][mainPlayer.returnPlayerY()].causesCollision())
				{
					
					checkPos(mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY(),mainPlayer.returnPlayerX()-1,mainPlayer.returnPlayerY());
					mainPlayer.setPlayerCords(mainPlayer.returnPlayerX()-1, mainPlayer.returnPlayerY());
					drawAndCheckPlayerTexture();
					System.out.println(mainPlayer.returnPlayerX() + " + " + mainPlayer.returnPlayerY());
					redraw();
					
				}
			}

			return "left";
		} else if(t  == KeyCode.RIGHT || t  == KeyCode.D) {
			if(mainPlayer.returnPlayerX()+1 <= gameBoard.returnGridMaxX()-1){
				if(!GameBoard.gameBoardArray[mainPlayer.returnPlayerX()+1][mainPlayer.returnPlayerY()].causesCollision())
				{
					
					checkPos(mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY(),mainPlayer.returnPlayerX()+1,mainPlayer.returnPlayerY());
					mainPlayer.setPlayerCords(mainPlayer.returnPlayerX()+1, mainPlayer.returnPlayerY());
					drawAndCheckPlayerTexture();
					redraw();
					
				}
			
			}
			
			return "right";
		} else if(t  == KeyCode.ESCAPE){
		
			return "escape";
			
		} else if(t  == KeyCode.I){
			showDialog(25,25,"WIN");
		} else if(t  == KeyCode.P){
			
			debug.introDebug();
			//SelectIntroUI.runIntro();
			
		}
		}
		return "unknown";
		
	}	
	
	
	public static void updateStatus(){
		if(updateInvCount == true){
			Engine.itemLabel.setText("Items in bag: " + (10 - mainPlayer.getInvSpace()) + "/" + mainPlayer.getMaxSpace());
		}
		
	}
	
	public static String update(KeyCode t){

		
		if( currentMenu == 5){
			if(t == KeyCode.ENTER){
				return "bye!";
				
			}
		} else if(currentMenu == 6){
			hasPlayerWon();
			if (t == KeyCode.UP || t == KeyCode.W) {
			if(mainPlayer.returnPlayerY()-1 != -1){
				if(!GameBoard.gameBoardArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()-1].causesCollision())
				{
					redraw();
					checkPos(mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY(),mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY()-1);
					mainPlayer.setPlayerCords(mainPlayer.returnPlayerX(), mainPlayer.returnPlayerY()-1);	
					drawAndCheckPlayerTexture();
				}
			}
			
			return "up";
    	
		} else if(t == KeyCode.DOWN || t == KeyCode.S) {
			if(mainPlayer.returnPlayerY()+1 <= gameBoard.returnGridMaxY()-1){
				if(!GameBoard.gameBoardArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()+1].causesCollision())
				{
					redraw();
					checkPos(mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY(),mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY()+1);
					mainPlayer.setPlayerCords(mainPlayer.returnPlayerX(), mainPlayer.returnPlayerY()+1);
					drawAndCheckPlayerTexture();
				}
			}
				
			return "down";
    		
		} else if(t == KeyCode.LEFT || t == KeyCode.A) {
			if(mainPlayer.returnPlayerX()-1 != -1){
				if(!GameBoard.gameBoardArray[mainPlayer.returnPlayerX()-1][mainPlayer.returnPlayerY()].causesCollision())
				{
					redraw();
					checkPos(mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY(),mainPlayer.returnPlayerX()-1,mainPlayer.returnPlayerY());
					mainPlayer.setPlayerCords(mainPlayer.returnPlayerX()-1, mainPlayer.returnPlayerY());
					drawAndCheckPlayerTexture();
				}
			}

			return "left";
		} else if(t == KeyCode.RIGHT || t == KeyCode.D) {
			if(mainPlayer.returnPlayerX()+1 <= gameBoard.returnGridMaxX()-1){
				if(!GameBoard.gameBoardArray[mainPlayer.returnPlayerX()+1][mainPlayer.returnPlayerY()].causesCollision())
				{
					redraw();
					checkPos(mainPlayer.returnPlayerX(),mainPlayer.returnPlayerY(),mainPlayer.returnPlayerX()+1,mainPlayer.returnPlayerY());
					mainPlayer.setPlayerCords(mainPlayer.returnPlayerX()+1, mainPlayer.returnPlayerY());
					drawAndCheckPlayerTexture();
					}
			}
			
			return "right";
		} else if(t == KeyCode.ESCAPE){
			
			return "escape";
		} else if(t == KeyCode.I){
			showDialog(25,25,"WIN");
		} else if(t == KeyCode.P){
			
		}
		}
		return "unknown";
		
	}	
	
	//sets up starting level
	public static void init(){
		
		resetGameBoard();
		setUpImageGrid();

	}
	
	public static void reset(){
	//	playerHandle.x = 0;
//		playerHandle.y = 0;
		
	}
	
	
	//Initial playerDrawing in a new scenario
	public static void drawPlayerInScenario(){
		
	}
	
	public static void drawAndCheckPlayerTexture(){
		drawPlayer(GameBoard.gameBoardArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].returnFloorType());
		
	}
	
	
	public static void drawPlayer(String charTexture){
		
		
		if(charTexture == "Grass"){
			ImageBoard.imageTileArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].setImage(playerImageHandler.grassPlayerImage);
		}else if(charTexture == "HouseDoor"){
			ImageBoard.imageTileArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].setImage(playerImageHandler.houseDoorPlayerImage);
		}else if(charTexture == "HouseFloor"){
			ImageBoard.imageTileArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].setImage(playerImageHandler.houseFloorPlayerImage);
		}else if(charTexture == "Concrete"){
			ImageBoard.imageTileArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].setImage(playerImageHandler.concretePlayerImage);
		}else if(charTexture == "DeepestDitch"){
			ImageBoard.imageTileArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].setImage(playerImageHandler.deepestDitchImage);
		}else if(charTexture == "LightestDitch"){
			ImageBoard.imageTileArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].setImage(playerImageHandler.lightestDitchImage);
		}else if(charTexture == "SecondDeepestDitch"){
			ImageBoard.imageTileArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].setImage(playerImageHandler.secondDeepestDitchImage);
		}else if(charTexture == "SecondLightestDitch"){
			ImageBoard.imageTileArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].setImage(playerImageHandler.secondLightestDitchImage);
		}else if(charTexture == "YellowLines"){
			ImageBoard.imageTileArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].setImage(playerImageHandler.yellowLinesPathImage);
		}
		
		else {
			ImageBoard.imageTileArray[mainPlayer.returnPlayerX()][mainPlayer.returnPlayerY()].setImage(playerImageHandler.defaultPlayerImage);	
		}
		
	}
	
	
//SECTION - GAMEBOARD SETUP		
		//Creates the initial blank game board - adds to grid and returns said grid
	    public static GridPane setUpGameGrid(){
		    GridPane gameBoardGrid = new GridPane();
	    	gameBoardGrid.setAlignment(Pos.CENTER); 
	    	for( int i = 0; i < 74; i++){
	    		for( int x = 0; x < 44 ; x++){
	    			gameBoardGrid.add(ImageBoard.imageTileArray[i][x],i,x);
	    		}
	    	}
	    	
	    	return gameBoardGrid;
	    }
	    
	    //Creates the initial blank game board - images
	    
	    public static void setUpImageGrid(){
	    	for( int i = 0; i < 74; i++){
	    		for( int x = 0; x < 44 ; x++){
	    		
	    			ImageBoard.imageTileArray[i][x].setImage(GameBoard.gameBoardArray[i][x].returnTileImage("forcedUpdate"));
	    			ImageBoard.imageTileArray[i][x].setFitWidth(gridSize);
	    			ImageBoard.imageTileArray[i][x].setFitHeight(gridSize);
	    		}
	    	}

	    }
	    
	    public GridPane setUpStatusGrid(){
	    	
	    	  
    		GridPane statusGrid = new GridPane();
    		
    		statusGrid.add(specialLabel, 0, 0);
    		statusGrid.add(yesButton, 1, 0);
    		statusGrid.add(noButton, 1, 1);
    		
    		
    		
    		specialLabel.setVisible(false);
    		yesButton.setVisible(false);
    		noButton.setVisible(false);
    		return statusGrid;
    		
	    }
	    
	    public static void turnOnStatusGrid(){
    		specialLabel.setVisible(true);
    		yesButton.setVisible(true);
    		noButton.setVisible(true);
	    }
	    
	    public void turnOffStatusGrid(){
    		specialLabel.setVisible(false);
    		yesButton.setVisible(false);
    		noButton.setVisible(false);
	    }
	    
	    //Creates the core grid

	    public static void showDialog(int dialogWidth, int dialogHeight , String condition){
	        final Stage dialogStage = new Stage();
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        
	        GridPane hBox = new GridPane();
	        hBox.setAlignment(Pos.CENTER);
	        
	        Label label1 = new Label("You Win!");
	        hBox.add(label1,0,0);

	        dialogStage.setScene(new Scene(hBox,100,100));
	        dialogStage.show();
	        
	    }
	    
	    public static void showStartDialog(){
	        final Stage dialogStage = new Stage();
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        
	        GridPane grid = new GridPane();


	        dialogStage.setScene(new Scene(grid,200,200));
	        dialogStage.show();
	        
	    }
	    
	    public AnchorPane addAnchorPane(GridPane grid) {

	        AnchorPane anchorpane = new AnchorPane();
	       
	        HBox hb = new HBox();
	        hb.setPadding(new Insets(0, 10, 10, 10));
	        hb.setSpacing(10);
	        hb.setAlignment(Pos.BOTTOM_CENTER);
	        
	        
	        anchorpane.getChildren().addAll(grid,hb);

	        AnchorPane.setBottomAnchor(hb, 8.0);
	        AnchorPane.setRightAnchor(hb, 5.0);
	        AnchorPane.setTopAnchor(grid, 10.0);

	        return anchorpane;
	    }
	    
	    public BorderPane setUpHelpGrid(){
	    	
	    	GridPane helpGrid = new GridPane();
	    	BorderPane helpPane = new BorderPane();
	    	
	    	helpGrid.setAlignment(Pos.CENTER);
	    	

	    	
	    	helpGrid.setHgap(10);
	    	helpGrid.setVgap(10);
	    	helpGrid.setPadding(new Insets(0, 10, 0, 10));
	    	
	        
	        Label label1 = new Label("You must go around your house and gather items.");
	        Label label2 = new Label("Take only the items that would help you in the");
	        Label label3 = new Label("event of a tornado.");
	        Label label4 = new Label("You only have a limited amount of space");
	        Label label5 = new Label("in your inventory.");
	        Label label6 = new Label("After you have gathered what you need");
	        Label label7 = new Label("head to the red spot to begin the scenario.");
	        Label label8 = new Label("Good luck.");
	        Label label9 = new Label("(Click to go back to the main screen)");
	        
	    	GridPane.setHalignment(label1, HPos.CENTER);
	    	GridPane.setHalignment(label2, HPos.CENTER);
	    	GridPane.setHalignment(label3, HPos.CENTER);
	    	GridPane.setHalignment(label4, HPos.CENTER);
	    	GridPane.setHalignment(label5, HPos.CENTER);
	    	GridPane.setHalignment(label6, HPos.CENTER);
	    	GridPane.setHalignment(label7, HPos.CENTER);
	    	GridPane.setHalignment(label8, HPos.CENTER);
	    	GridPane.setHalignment(label9, HPos.CENTER);



	        helpGrid.add(label1,0,0);
	        helpGrid.add(label2,0,1);
	        helpGrid.add(label3,0,2);
	        helpGrid.add(label4,0,3);
	        helpGrid.add(label5,0,4);
	        helpGrid.add(label6,0,5);
	        helpGrid.add(label7,0,6);
	        helpGrid.add(label8,0,7);
	        helpGrid.add(label9,0,8);
	    	helpGrid.setStyle("-fx-background-color:rgba(0, 0, 0, 0.5)");
	        
	    	
	    	helpPane.setCenter(helpGrid);
	    	helpPane.setPadding(new Insets(150,150,150,150));
	    	return helpPane;
	    }
	    
	    
	    
//SECTION - Main Menu Setup	    
	    public BorderPane setUpMainMenu(){
	    	
	    	
	    	BorderPane masterPane = new BorderPane();
	    	
	    	
	    	GridPane logoPane = new GridPane();
	    	logoPane.setAlignment(Pos.BOTTOM_RIGHT);
			String ntcLogoS = getClass().getResource("/net/assets/menu/NTClogo.png").toString();
		    Image ntcLogo = new Image(ntcLogoS);
		    ImageView ntcLogoView = new ImageView(ntcLogo);
		    ntcLogoView.setFitHeight(256/1.5);
		    ntcLogoView.setFitWidth(256+128/1.5);
	    	logoPane.add(ntcLogoView, 0, 0);
	    	
	    	masterPane.setBottom(logoPane);
	    	
	    	
	    	mainMenu.setAlignment(Pos.TOP_CENTER);

	    	mainMenuTitle.setFitWidth(600);
	    	mainMenuTitle.setFitHeight(200);
	    	
	    	GridPane.setHalignment(mainMenuTitle, HPos.CENTER);
	    	GridPane.setHalignment(mainMenuNewLevel, HPos.CENTER);
	    
	    	GridPane.setHalignment(mainMenuLoadWorld, HPos.CENTER);
	    	GridPane.setHalignment(mainMenuOptions, HPos.CENTER);
	    	GridPane.setHalignment(mainMenuExit, HPos.CENTER);
	    	
	    	mainMenuTitle.setId("mainLabel");
	    	mainMenuNewLevel.setId("mainLabel");
	    	mainMenuLoadWorld.setId("mainLabel");
	    	mainMenuOptions.setId("mainLabel");
	    	mainMenuExit.setId("mainLabel");
	    	
	    	mainMenu.setHgap(10);
	    	mainMenu.setVgap(10);
	    	mainMenu.setPadding(new Insets(0, 10, 0, 10));

	    	mainMenuNewLevel.setText("New Game");

	    	mainMenuNewLevel.setEffect(returnMainEffect());
	    	mainMenuLoadWorld.setText("Help");

	    	mainMenuLoadWorld.setEffect(returnMainEffect());
	    	mainMenuOptions.setText("Options");

	    	mainMenuOptions.setEffect(returnMainEffect());
	    	mainMenuExit.setText("Exit");
	    	
	    	mainMenuExit.setEffect(returnMainEffect());


	    	
	    	mainMenuNewLevel.setOnMouseEntered(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {

		        	mainMenuNewLevel.setText(">New Game<");
		        	mainMenuNewLevel.setEffect(returnEnteredEffect());

		        	
		        }
		    });
	    	
	    	mainMenuNewLevel.setOnMouseExited(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		        	
		        	mainMenuNewLevel.setText("New Game");
		        	mainMenuNewLevel.setEffect(null);

		        }
		    });

	    	mainMenuNewLevel.setOnMouseClicked(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		        	if(optionsLocked == false){
		        		optionsLocked = true;
		        		playTransition("New Level");
		        	
		        		
		        		timer.schedule( new AppTask(), animationSpeed);
		        	}
		        	//primaryStage.setScene(appUI);
		             
		        }
		    });
	    	
	    	
	    	
	    	

	    	mainMenuLoadWorld.setOnMouseEntered(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		        	
		        	mainMenuLoadWorld.setText(">Help<");
		        	mainMenuLoadWorld.setEffect(returnEnteredEffect());
		             
		        }
		    });
	    	
	    	mainMenuLoadWorld.setOnMouseExited(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		        	
		        	mainMenuLoadWorld.setText("Help");
		        	mainMenuLoadWorld.setEffect(null);
		             
		        }
		    });
	    	
	    	mainMenuLoadWorld.setOnMouseClicked(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		           	if(optionsLocked == false){
		           		optionsLocked = true;
		        	playTransition("Load World");
		        	
		        	timer.schedule( new LoadWorldTask(), animationSpeed);
		           	}

		        	//primaryStage.setScene(appUI);
		             
		        }
		    });
	    	
	    	mainMenuOptions.setOnMouseEntered(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		        	
		        	mainMenuOptions.setText(">Options<");
		        	mainMenuOptions.setEffect(returnEnteredEffect());
		             
		        }
		    });
	    	
	    	mainMenuOptions.setOnMouseExited(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		        	
		        	mainMenuOptions.setText("Options");
		        	mainMenuOptions.setEffect(null);
		             
		        }
		    });

	    	mainMenuOptions.setOnMouseClicked(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		        	if(optionsLocked == false && animationState == true){
		        		optionsLocked = true;
		        		playTransition("Options");
		        	
		        		timer.schedule( new OptionsTask(), animationSpeed);
		        	//primaryStage.setScene(appUI);
		        	}
		        }
		    });
	    	mainMenuExit.setOnMouseEntered(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		        	
		        	mainMenuExit.setText(">Exit<");
		        	mainMenuExit.setEffect(returnEnteredEffect());
		             
		        }
		    });
	    	
	    	mainMenuExit.setOnMouseExited(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		        	
		        	mainMenuExit.setText("Exit");
		        	mainMenuExit.setEffect(null);
		             
		        }
		    });
	    	
	    	mainMenuExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent mouseHandler) {
		        	
		        	
    				Engine.threadRunning = false;
    				Engine.musicState = false;
					Start.thread.interrupt();
		
					com.sun.javafx.application.PlatformImpl.tkExit();
					Platform.exit();

		        	
		             
		        }
		    });
	    	
	    	
	    	
	    	
	    	mainMenu.add(mainMenuTitle, 0, 0);
	    	mainMenu.add(mainMenuNewLevel, 0, 1);    	
	    	mainMenu.add(mainMenuLoadWorld, 0, 2);
	    	mainMenu.add(mainMenuOptions, 0, 3);
	    	mainMenu.add(mainMenuExit, 0, 4);
	    	
	    	masterPane.setTop(mainMenu);
	    	Engine.setCurrentMenu(1);
	    	return masterPane;
	    }
	    
	    public GridPane setupIntro(){
	    	introMenu.setAlignment(Pos.CENTER);
	        
	        Label label1 = new Label("This game is over tornado safety.");
	        Label label2 = new Label("The goal of this game is to collect items,");
	        Label label3 = new Label("save schoolmates, and find the best place");
	        Label label4 = new Label("to hide from the tornado. ");
	        Label label5 = new Label("WORK IN PROGRESS");
	        Label label6 = new Label("WORK IN PROGRESS");
	        Label label7 = new Label("WORK IN PROGRESS");
	        Label label8 = new Label("WORK IN PROGRESS");
	        Label label9 = new Label("WORK IN PROGRESS");
	        introMenu.add(label1,0,0);
	        introMenu.add(label2,0,1);
	        introMenu.add(label3,0,2);
	        introMenu.add(label4,0,3);
	        introMenu.add(label5,0,4);
	        introMenu.add(label6,0,5);
	        introMenu.add(label7,0,6);
	        introMenu.add(label8,0,7);
	        introMenu.add(label9,0,8);
	        return introMenu;
	    }
	    
		
		public static Effect returnEnteredEffect(){
		       DropShadow ds = new DropShadow();
		        ds.setOffsetY(10.5);
		        ds.setOffsetX(10.5);
		        ds.setColor(Color.TEAL);
		        return ds;
		}
		
		public static Effect returnMainEffect(){
		       DropShadow ds = new DropShadow();
		        ds.setOffsetY(5.5);
		        ds.setOffsetX(5.5);
		        ds.setColor(Color.BLACK);
		        return ds;
		}
	    
		public static void playTransition(String exception){
			
	     	FadeTransition pathTransition = new FadeTransition(Duration.millis(animationSpeed), mainMenuNewLevel);
	     	if(exception != "New Level"){
	     	pathTransition.setFromValue(2.0);
	     	pathTransition.setToValue(0.1);
	     	pathTransition.setCycleCount(2);
	     	pathTransition.setAutoReverse(true);
			}
			

	     	FadeTransition pathTransition3 = new FadeTransition(Duration.millis(animationSpeed), mainMenuLoadWorld);
	     	 if(exception != "Load World"){
	     	pathTransition3.setFromValue(2.0);
	     	pathTransition3.setToValue(0.1);
	     	pathTransition3.setCycleCount(2);
	     	pathTransition3.setAutoReverse(true);
		    }

	     	FadeTransition pathTransition4 = new FadeTransition(Duration.millis(animationSpeed), mainMenuOptions);
		    if(exception != "Options"){
	     	pathTransition4.setFromValue(2.0);
	     	pathTransition4.setToValue(0.1);
	     	pathTransition4.setCycleCount(2);
	     	pathTransition4.setAutoReverse(true);
		    }

	     	FadeTransition pathTransition5 = new FadeTransition(Duration.millis(animationSpeed), mainMenuExit);
	     	pathTransition5.setFromValue(2.0);
	     	pathTransition5.setToValue(0.1);
	     	pathTransition5.setCycleCount(2);
	     	pathTransition5.setAutoReverse(true);

	     	
			
			
	    	   ParallelTransition parallelTransition = new ParallelTransition();
	           parallelTransition.getChildren().addAll(
	        		   pathTransition,
	        		  
	        		   pathTransition3,
	        		   pathTransition4,
	        		   pathTransition5

	           );
	           parallelTransition.setCycleCount(1);
	           parallelTransition.play();
		}

		
	    
//SECTION - New Level Setup
	    public GridPane setUpNewLevelMenu(){
	    	
	    	
	    	
	    	newLevelMenu.add(mainMenuTitle2, 0, 0);
	    	newLevelMenu.setAlignment(Pos.TOP_CENTER);

	    	newLevelFirstOption.setText("House Scenario");
	    	newLevelSecondOption.setText("Back to Main Menu");
	    	
	    	newLevelFirstOption.setOnMouseEntered(new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent t) {

	            	newLevelFirstOption.setText(">" + "House Scenario" + "<");
	            	newLevelFirstOption.setEffect(Engine.returnEnteredEffect());
	            	
	            }

	    	});
	    	newLevelFirstOption.setOnMouseExited(new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent t) {

	            	newLevelFirstOption.setText("House Scenario");
	            	newLevelFirstOption.setEffect(null);
	            	
	            }

	    	});
	    	newLevelFirstOption.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent t) {
	       			GameIntroUI.runUI();
	            	
	            }

	    	});
	    	
	    	newLevelSecondOption.setOnMouseEntered(new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent t) {

	            	newLevelSecondOption.setText(">" + "Back to Main Menu" + "<");
	            	newLevelSecondOption.setEffect(Engine.returnEnteredEffect());
	            	
	            }

	    	});
	    	newLevelSecondOption.setOnMouseExited(new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent t) {

	            	newLevelSecondOption.setText("Back to Main Menu");
	            	newLevelSecondOption.setEffect(null);
	            	
	            }

	    	});
	    	newLevelSecondOption.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent t) {

	            	Start.primaryStage.setScene(Start.mainMenu);
	            	
	            }

	    	});
	    	
	    	
	    	
	    	newLevelMenu.add(newLevelFirstOption,0,1);
	    	newLevelMenu.add(newLevelSecondOption,0,2);
	    	
	    	mainMenuTitle2.setFitWidth(600);
	    	mainMenuTitle2.setFitHeight(200);
	    	
	    	GridPane.setHalignment(mainMenuTitle, HPos.CENTER);
	    	GridPane.setHalignment(newLevelFirstOption, HPos.CENTER);
	    	GridPane.setHalignment(newLevelSecondOption, HPos.CENTER);
	    	return newLevelMenu;
	    }
//SECTION - New World Setup  
	    public GridPane setUpNewWorldMenu(){
	    	newWorldMenu.add(mainMenuTitle3, 0, 0);
	    	newWorldMenu.setAlignment(Pos.TOP_CENTER);

	    	mainMenuTitle3.setFitWidth(600);
	    	mainMenuTitle3.setFitHeight(200);
	    	return newWorldMenu;
	    }
//SECTION - Load World Setup
	    public GridPane setUpLoadWorldMenu(){
	    	loadWorldMenu.add(mainMenuTitle4, 0, 0);
	    	loadWorldMenu.setAlignment(Pos.TOP_CENTER);

	    	mainMenuTitle4.setFitWidth(600);
	    	mainMenuTitle4.setFitHeight(200);
	    	return loadWorldMenu;
	    }
	    
	    
	    
//SECTION - Option Setup
	    public GridPane setUpOptionMenu(){
	    	GridPane.setHalignment(musicOption, HPos.CENTER);
	    	GridPane.setHalignment(gridSizeOption, HPos.CENTER);
	    	GridPane.setHalignment(backOption, HPos.CENTER);
	    	optionsMenu.add(mainMenuTitle5, 0, 0);
	    	optionsMenu.setAlignment(Pos.TOP_CENTER);

	    	mainMenuTitle5.setFitWidth(600);
	    	mainMenuTitle5.setFitHeight(200);
	    	
	    	
	    	musicOption.setText("Music: " + musicState+ "");
	    	backOption.setText("Back");

			
			musicOption.setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					musicOption.setText(">Music: " + musicState+ "<");
					musicOption.setEffect(returnEnteredEffect());
					
					
				}
		        	
		        	
		        });
	    	
			musicOption.setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					musicOption.setText("Music: " + musicState+ "");
					musicOption.setEffect(null);
					
					
				}
		        	
		        	
		        });
			
	    	
			musicOption.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					toggleMusicState();
					musicState = false;
					Start.thread.interrupt();
					showMusicState();
					musicOption.setText("Music: " + musicState + "");
					
				}
		        	
		        	
		        });
			
			gridSizeOption.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					

					
					if(gridSize == 16){
						gridSize = 20;
					}else if(gridSize == 20){
						gridSize = 24;
					}else if(gridSize == 24){
						gridSize = 16;
					}
					gridSizeOption.setText(">Grid Size: " + gridSize);
					
				}
		        	
		        	
		        });
			gridSizeOption.setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					gridSizeOption.setText(">Grid Size: " + gridSize+ "<");
					gridSizeOption.setEffect(returnEnteredEffect());
					
					
				}
		        	
		        	
		        });
	    	
			gridSizeOption.setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					gridSizeOption.setText("Grid Size: " + gridSize);
					gridSizeOption.setEffect(null);
					
					
				}
		        	
		        	
		        });
			
			backOption.setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					backOption.setText(">Back<");
					backOption.setEffect(returnEnteredEffect());
					
					
				}
		        	
		        	
		        });
	    	
			backOption.setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					backOption.setText("Back");
					backOption.setEffect(null);
					
					
				}
		        	
		        	
		        });
	    	optionsMenu.add(musicOption, 0, 1);
	    	optionsMenu.add(gridSizeOption,0,2);
	    	optionsMenu.add(backOption, 0, 3);
	    	
	    	return optionsMenu;
	    }
	    
	    public static void setCurrentMenu(int currentMenu){
	    	
	    	Engine.currentMenu = currentMenu;
	    	
	    	
	    }
	   
	    
	    public static void toggleMusicState(){
	    	if( musicState == true){
	    		musicState = false;
	    	}else if(musicState == false){
	    		musicState = true;
	    	}
	    }
	    
	    public static void showMusicState(){
	    	System.out.println("Music State: " + musicState);
	    }
	    
	    public static void addItemToGameBoard(Item itemHandle, int x, int y){
	    ///	gameBoard.addItemToTileInventory(itemHandle, x, y);
	    	
	    	
	    }
	    
	    public static void startGameMusic(){
	    	Start.thread.start();
	    }
	    
	    public static void resetGameBoard(){
	    	gameBoard = new GameBoard();
	    }
	    public static int returnCurrentMenu(){
	    	return currentMenu;
	    }
		public static Player mainPlayer() {
			// TODO Auto-generated method stub
			return mainPlayer;
		}
		public static boolean inScenario() {
			
			return inScenario ;
		}
		public static void runTimeout(int ID) {
			GridPane helpGrid = new GridPane();
	    	BorderPane helpPane = new BorderPane();
	    	
	    	helpGrid.setAlignment(Pos.CENTER);
	    	

	    	
	    	helpGrid.setHgap(10);
	    	helpGrid.setVgap(10);
	    	helpGrid.setPadding(new Insets(0, 10, 0, 10));
	    	
	        
	        Label label1 = new Label("You have run out of time and the tornado hit");
	        Label label2 = new Label("Better luck next time");
	        Label label3 = new Label("(Click the screen to continue)");

	        
	    	GridPane.setHalignment(label1, HPos.CENTER);
	    	GridPane.setHalignment(label2, HPos.CENTER);
	    	GridPane.setHalignment(label3, HPos.CENTER);




	        helpGrid.add(label1,0,0);
	        helpGrid.add(label2,0,1);
	        helpGrid.add(label3,0,2);

	    	helpGrid.setStyle("-fx-background-color:rgba(0, 0, 0, 0.5)");
	        
	    	
	    	helpPane.setCenter(helpGrid);
	    	helpPane.setPadding(new Insets(150,150,150,150));
			Scene scene = new Scene(helpPane,Start.sceneStartWidth, Start.sceneStartHeight);
			scene.getStylesheets().add(Engine.class.getResource("/net/assets/menu/MainMenu.css").toString());

			label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent t) {

					Engine.inGame = false;

					if(ID == 3){
						isScenario2Done = true;
						RoadOverviewUI.runOverview();
					}else if(ID == 5){
						isScenario1Done = true;
						House2OverviewUI.runOverview();
					}else if(ID == 2){
						isScenario3Done = true;
						SchoolOverviewUI.runOverview();
					}
					checkCompleted();
					
	            	
	            }

	    	});
			label3.setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				
					label3.setEffect(null);
					
					
				}
		        	
		        	
		        });
			
			label3.setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
	
					label3.setEffect(returnEnteredEffect());
					
					
				}
		        	
		        	
		        });
				Start.primaryStage.setScene(scene);
			
			
			
			
		}
}
