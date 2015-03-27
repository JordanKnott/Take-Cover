package net.engine;

import java.net.URL;

import net.engine.introUI.ScenarioSelect;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AssetLoader {

	//Private declaration of resources #Used by public methods
	private static Image titleImage;
	
	private static Image blackBackground;
	
	private static Image playerImage;
	
	private static String mainMenuCssPath;

	private static String optionCssPath;
	
	private static Image batteryTileImage;
	
	private static Image ballTileImage;
	
	private static Image appleTileImage;
	
	private static Image blanketTileImage;
	
	private static Image canTileImage;
	
	private static Image flashlightTileImage;
	
	private static Image gameTileImage;
	
	private static Image gasTileImage;
	
	private static Image laptopTileImage;
	
	private static Image phoneTileImage;
	
	private static Image shoesTileImage;
	
	private static Image walkieTalkieImage;
	
	private static Image waterBottleTileImage;
	
	private static Image blankTileImage;
	
	private static Image concreteTileImage;
	
	private static Image floorColorImage;
	
	private static Image grassTileImage;
	
	private static Image grassColor1Image;
	
	private static Image grassColor2Image;
	
	private static Image redTileImage;
	
	private static Image schoolFloorImage;
	
	private static Image schoolWallImage;
	
	private static Image wallColorImage;
	
	private static Image wallTileImage;
	
	private static Image bottomWindowImage;
	
	private static Image doorColorImage;
	
	private static Image rightWindowImage;
	
	private static Image topWindowImage;
	
	private static Image backgroundImage;
	
	private static Image character1;
	
	private static Image character2;
	
	private static Image character3;
	
	private static Image character4;

	private static Image character5;
	
	private static Image character6;
	
	private static Image deerImage;
	private static MediaPlayer musicPlayer1;
	
	private static MediaPlayer musicPlayer2;
	
	
	private static ProgressBar progBar = new ProgressBar();
	private static int curIndex = 0;
	private static int maxIndex = 50;
	
	public static void updateProgressBar(){
		
		curIndex++;
		if(curIndex > maxIndex){
			curIndex = 0;
		}
		double first = curIndex * 100;
		double second = maxIndex; // implicit times X
		
		double third = first/second;
		
		
		//progBar.setProgress(third);
		
		
		
		
		
	}
	
	public static Image returnDeerImage(){
		return deerImage;
	}
	
	public AssetLoader(){
		//Init Phase
		/*Stage loadScreenStage = new Stage(StageStyle.UNDECORATED);
		
		VBox loadScreenBox = new VBox();
		
		
		
		progBar.setPrefWidth(250);
		loadScreenBox.setAlignment(Pos.CENTER);
		
		String loadScreenPath = AssetLoader.class.getResource("/net/assets/menu/TITLE.png").toString();
		 
	    Image loadScreenImage = new Image(loadScreenPath);
		this.titleImage = loadScreenImage;
	    
	    
		ImageView iView = new ImageView(loadScreenImage);
		iView.setFitHeight(230);
		iView.setFitWidth(350);
		loadScreenBox.getChildren().addAll(iView,progBar);
		Scene loadScene = new Scene(loadScreenBox,350,250);
		loadScreenStage.setScene(loadScene);
		loadScreenStage.show();
		
		*/
		//Beginning of Asset Loading
		
		mainMenuCssPath = AssetLoader.class.getResource("/net/assets/menu/MainMenu.css").toString();

		optionCssPath = AssetLoader.class.getResource("/net/assets/menu/OptionsMenu.css").toString();
	
		/*
		String Title = getClass().getResource("/net/assets/menu/TITLE.png").toString();
	    Image title = new Image(Title);
	    titleImage = title;
	    */
		
		String DeerPath =  getClass().getResource("/net/assets/tiles/entities/Deer.jpg").toString();
	    Image deerImage = new Image(DeerPath);
	    AssetLoader.deerImage = deerImage;
	    
		String BlackBackground =  getClass().getResource("/net/assets/menu/BlackBackground.png").toString();
	    Image blackBackground = new Image(BlackBackground);
	    AssetLoader.blackBackground = blackBackground;
	    updateProgressBar();
		String PlayerTile = getClass().getResource("/net/assets/tiles/entities/PlayerTile.png").toString();
		Image playerTile = new Image(PlayerTile);
		playerImage = playerTile;
		updateProgressBar();
		String AppleTileImage = getClass().getResource("/net/assets/items/Apple.png").toString();
	    Image appleTileImage = new Image(AppleTileImage);
	    AssetLoader.appleTileImage = appleTileImage;
	    updateProgressBar();
		String BallTileImage = getClass().getResource("/net/assets/items/Ball.png").toString();
	    Image ballTileImage = new Image(BallTileImage);
	    AssetLoader.ballTileImage = ballTileImage;
	    updateProgressBar();
		String BatteryTileImage = getClass().getResource("/net/assets/items/Battery.png").toString();
	    Image batteryTileImage = new Image(BatteryTileImage);
	    AssetLoader.batteryTileImage = batteryTileImage;
	    updateProgressBar();
		String BlanketTileImage = getClass().getResource("/net/assets/items/Blanket.png").toString();
	    Image blanketTileImage = new Image(BlanketTileImage);
		AssetLoader.blanketTileImage = blanketTileImage;
		updateProgressBar();
		String CanTileImage = getClass().getResource("/net/assets/items/Can.png").toString();
	    Image canTileImage = new Image(CanTileImage);
	    AssetLoader.canTileImage = canTileImage;
	    updateProgressBar();
		String FlashlightTileImage = getClass().getResource("/net/assets/items/Flashlight.png").toString();
	    Image flashlightTileImage = new Image(FlashlightTileImage);
	    AssetLoader.flashlightTileImage = flashlightTileImage;
	    updateProgressBar();
		String GameTileImage = getClass().getResource("/net/assets/items/GameBoy.png").toString();
	    Image gameTileImage = new Image(GameTileImage);
	    AssetLoader.gameTileImage = gameTileImage;
	    updateProgressBar();
		String GasTileImage = getClass().getResource("/net/assets/items/GasCan.png").toString();
	    Image gasTileImage = new Image(GasTileImage);
	    AssetLoader.gasTileImage = gasTileImage;
	    updateProgressBar();
		String LaptopTileImage = getClass().getResource("/net/assets/items/Laptop.png").toString();
	    Image laptopTileImage = new Image(LaptopTileImage);
	    AssetLoader.laptopTileImage = laptopTileImage;
	    updateProgressBar();
		String PhoneTileImage = getClass().getResource("/net/assets/items/Phone.png").toString();	
	    Image phoneTileImage = new Image(PhoneTileImage);
	    AssetLoader.phoneTileImage = phoneTileImage;
	    updateProgressBar();
		String ShoesTileImage = getClass().getResource("/net/assets/items/Shoes.png").toString();
	    Image shoesTileImage = new Image(ShoesTileImage);
	    AssetLoader.shoesTileImage = shoesTileImage;
	    updateProgressBar();
		String WalkieTalkieImage = getClass().getResource("/net/assets/items/WalkieTalkie.png").toString();
	    Image walkieTalkieImage = new Image(WalkieTalkieImage);
	    AssetLoader.walkieTalkieImage = walkieTalkieImage;
	    updateProgressBar();
		String WaterBottleTileImage = getClass().getResource("/net/assets/items/WaterBottle.png").toString();
	    Image waterBottleTileImage = new Image(WaterBottleTileImage);
	    AssetLoader.waterBottleTileImage = waterBottleTileImage;
	    updateProgressBar();
		String BlankTile = getClass().getResource("/net/assets/tiles/floor/BlankTile.png").toString();
	    Image blankTile = new Image(BlankTile);
	    AssetLoader.blankTileImage = blankTile;
	    updateProgressBar();
	    String ConcreteTile = getClass().getResource("/net/assets/tiles/floor/ConcreteTile.png").toString();
	    Image concreteTile = new Image(ConcreteTile);
	    AssetLoader.concreteTileImage = concreteTile;
	    updateProgressBar();
		String FloorColor = getClass().getResource("/net/assets/tiles/floor/FloorColor.png").toString();
	    Image floorColor = new Image(FloorColor);
	    AssetLoader.floorColorImage = floorColor;
	    updateProgressBar();
		String GrassColor1 = getClass().getResource("/net/assets/tiles/floor/Grass1.png").toString();
	    Image grassColor1 = new Image(GrassColor1);
	    AssetLoader.grassColor1Image = grassColor1;
	    updateProgressBar();
		String GrassColor2 = getClass().getResource("/net/assets/tiles/floor/Grass2.png").toString();
	    Image grassColor2 = new Image(GrassColor2);
	    AssetLoader.grassColor2Image = grassColor2;
	    updateProgressBar();
		String GrassTile = getClass().getResource("/net/assets/tiles/floor/GrassTile.png").toString();
		Image grassTile = new Image(GrassTile);
		AssetLoader.grassTileImage = grassTile;
		updateProgressBar();
		String RedTile = getClass().getResource("/net/assets/tiles/floor/RedTile.png").toString();
	    Image redTile = new Image(RedTile);
		AssetLoader.redTileImage = redTile;
		updateProgressBar();
		String SchoolFloor = getClass().getResource("/net/assets/tiles/floor/SchoolFloor.png").toString();
	    Image schoolFloor = new Image(SchoolFloor);
	    AssetLoader.schoolFloorImage = schoolFloor;
	    updateProgressBar();
		String SchoolWall = getClass().getResource("/net/assets/tiles/floor/SchoolWall.png").toString();
	    Image schoolWall = new Image(SchoolWall);
	    AssetLoader.schoolWallImage = schoolWall;
	    updateProgressBar();
		String WallColor = getClass().getResource("/net/assets/tiles/walls/WallColor.png").toString();
	    Image wallColor = new Image(WallColor);
	    AssetLoader.wallColorImage = wallColor;
	    updateProgressBar();
		String WallTile = getClass().getResource("/net/assets/tiles/walls/Wall.png").toString();
	    Image wallTile = new Image(WallTile);
	    AssetLoader.wallTileImage = wallTile;
	    updateProgressBar();
		String BottomWindow = getClass().getResource("/net/assets/tiles/walls/BottomWindow.png").toString();
	    Image bottomWindow = new Image(BottomWindow);
	    AssetLoader.bottomWindowImage = bottomWindow;
	    updateProgressBar();
		String DoorColor = getClass().getResource("/net/assets/tiles/walls/DoorColor.png").toString();
		Image doorColor = new Image(DoorColor);
		AssetLoader.doorColorImage = doorColor;
		updateProgressBar();
		String RightWindow = getClass().getResource("/net/assets/tiles/walls/RightWindow.png").toString();
	    Image rightWindow = new Image(RightWindow);
		AssetLoader.rightWindowImage = rightWindow;
		updateProgressBar();
		String TopWindow = getClass().getResource("/net/assets/tiles/walls/TopWindow.png").toString();
	    Image topWindow = new Image(TopWindow);
	    AssetLoader.topWindowImage = topWindow;
	    updateProgressBar();
	    
	    Image character1 = new Image(getClass().getResource("/net/assets/tiles/entities/Character2.png").toString());
	    AssetLoader.character1 = character1;
	    updateProgressBar();
	    
	    Image character2 = new Image(getClass().getResource("/net/assets/tiles/entities/Character3.png").toString());
	    AssetLoader.character2 = character2;
	    updateProgressBar();
	    
	    Image character3 = new Image(getClass().getResource("/net/assets/tiles/entities/Character4.png").toString());
	    AssetLoader.character3 = character3;
	    updateProgressBar();
	    
	    Image character4 = new Image(getClass().getResource("/net/assets/tiles/entities/Character5.png").toString());
	    AssetLoader.character4 = character4;
	    updateProgressBar();
	    
	    Image character5 = new Image(getClass().getResource("/net/assets/tiles/entities/Character6.png").toString());
	    AssetLoader.character5 = character5;
	    updateProgressBar();
	    
	    Image character6 = new Image(getClass().getResource("/net/assets/tiles/entities/Character7.png").toString());
	    AssetLoader.character6 = character6;
	    updateProgressBar();
	    
	    backgroundImage = new Image(ScenarioSelect.class.getResource("/net/assets/menu/Claremore.PNG").toString());
	    
	    
	    
		URL resource = AssetLoader.class.getResource("/net/assets/music/BackgroundMusic.mp3");
		Media media = new Media(resource.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		AssetLoader.musicPlayer1 = mediaPlayer;
		updateProgressBar();
		
		URL resource1 = AssetLoader.class.getResource("/net/assets/music/BackgroundMusic2.mp3");
		Media media1 = new Media(resource1.toString());
		MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
		AssetLoader.musicPlayer2 = mediaPlayer1;
		updateProgressBar();
		
	    
	}
	
	//Public return methods for loading resources.\
	public static Image returnCharacter1(){
		return character1;
	}
	public static Image returnCharacter2(){
		return character2;
	}
	public static Image returnCharacter3(){
		return character3;
	}
	public static Image returnCharacter4(){
		return character4;
	}
	public static Image returnCharacter5(){
		return character5;
	}
	public static Image returnCharacter6(){
		return character6;
	}
	
	
	
	public static Image returnBatteryImage(){
		return batteryTileImage;
	}
	public static Image returnBallImage(){
		return ballTileImage;
	}
	public static Image returnAppleImage(){
		return appleTileImage;
	}
	public static Image returnBlanketImage(){
		return blanketTileImage;
	}
	public static Image returnCanImage(){
		return canTileImage;
	}
	public static Image returnFlashlightImage(){
		return flashlightTileImage;
	}
	public static Image returnGameImage(){
		return gameTileImage;
	}
	public static Image returnGasImage(){
		return gasTileImage;
	}
	public static Image returnLaptopImage(){
		return laptopTileImage;
	}
	public static Image returnPhoneImage(){
		return phoneTileImage;
	}
	public static Image returnShoesImage(){
		return shoesTileImage;
	}
	public static Image returnWalkieImage(){
		return walkieTalkieImage;
	}
	public static Image returnWaterBottleImage(){
		return waterBottleTileImage;
	}
	public static Image returnBlankImage(){
		return blankTileImage;
	}
	public static Image returnConcreteImage(){
		return concreteTileImage;
	}
	public static Image returnFloorColorImage(){
		return floorColorImage;
	}
	public static Image returnGrassImage(){	
		return grassTileImage;
	}
	public static Image returnGrass1Image(){
		return grassColor1Image;
	}
	public static Image returnGrass2Image(){
		return grassColor2Image;
	}
	public static Image returnRedImage(){
		return redTileImage;
	}
	public static Image returnSchoolFloorImage(){
		return schoolFloorImage;
	}
	public static Image returnSchoolWallImage(){
		return schoolWallImage;
	}
	public static Image returnWallColorImage(){
		return wallColorImage;
	}
	public static Image returnWallTileImage(){
		return wallTileImage;
	}
	public static Image returnBottomWindowImage(){
		return bottomWindowImage;
	}
	public static Image returnDoorColorImage(){
		return doorColorImage;
	}
	public static Image returnRightWindowImage(){
		return rightWindowImage;
	}
	public static Image returnTopWindowImage(){
		return topWindowImage;
	}
	public static Image returnClaremore(){
		return backgroundImage;
	}
	
	public static MediaPlayer returnMediaPlayer1(){
		return musicPlayer1;
	}
	
	public static MediaPlayer returnMediaPlayer2(){
		return musicPlayer2;
	}
	
	public static String returnMenuCSSPath(){
		
		return mainMenuCssPath;
	}
	public static String returnOptionCSSPath(){
		return optionCssPath;
	}
	public static Image returnTITLEImage(){
		return titleImage;
	}
	public static Image returnBlackBackgroundImage(){
		return blackBackground;
	}
	public static Image returnPlayerImage(){
		return playerImage;
	}
}
