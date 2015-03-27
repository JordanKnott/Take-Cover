package net.levels;

import java.util.Random;

import net.engine.Engine;
import net.engine.GameBoard;
import net.items.BatteryItem;
import net.items.Item;
import net.tiles.BottomWindow;
import net.tiles.ConcreteTile;
import net.tiles.DoorColor;
import net.tiles.FloorColor;
import net.tiles.GrassTile;
import net.tiles.GrassTile1;
import net.tiles.GrassTile2;
import net.tiles.RightWindow;
import net.tiles.TestTile;
import net.tiles.Tile;
import net.tiles.itemTiles.*;
import net.tiles.TopWindow;
import net.tiles.WallColor;
import net.tiles.WallTile;
import net.tiles.itemTiles.BatteryTile;
import net.tiles.itemTiles.CanTile;
import net.tiles.itemTiles.FlashlightTile;

public class ScenarioHouseLevel extends Level {

	Tile TopWindow = new TopWindow();
	Tile RightWindow = new RightWindow();
	Tile BottomWindow = new BottomWindow();
	Tile WallColor = new WallColor();
	Tile FloorColor = new FloorColor();
	Tile DoorColor = new DoorColor();
	Tile ConcreteTile = new ConcreteTile();
	Tile GrassTile = new GrassTile();
	Tile WallTile = new WallTile();
	Tile BatteryTile = new BatteryTile();
	Tile CanTile = new CanTile();
	Tile FlashlightTile = new FlashlightTile();
	Tile AppleTile = new AppleTile();
	Tile GameBoyTile = new GameBoyTile();
	Tile LaptopTile = new LaptopTile();
	Tile BallTile = new BallTile();
	Tile GasCanTile = new GasCanTile();
	Tile WaterBottleTile1 = new WaterBottleTile();
	Tile WaterBottleTile2 = new WaterBottle2Tile();
	Tile WaterBottleTile3 = new WaterBottle3Tile();
	Tile ShoesTile = new ShoesTile();
	Tile WalkieTalkieTile = new WalkieTalkieTile();
	Tile BlanketTile = new BlanketTile();
	Tile PhoneTile = new PhoneTile();
	Tile Battery = new BatteryTile();
	Tile Flashlight = new FlashlightTile();
	Tile GrassShade1 = new GrassTile1();
	Tile GrassShade2 = new GrassTile2();
	Tile TestTile = new TestTile();
	
	Item battery = new BatteryItem();
	int chance;
	String[] winCondition = null;
	
	Random gen = new Random();
	
	public void populateGameBoard(GameBoard gameBoard){
		
		
		Engine.mainPlayer().setPlayerCords(25, 25);;
		Engine.setPlayerStorageSpace(10);
		
		Engine.mainPlayer().increaseWinCount();
		Engine.mainPlayer().increaseWinCount();
		//Grass
		
		for(int iter = 0; iter < 75; iter++){
			for(int i = 0; i < 45; i++){
				GameBoard.addTileObject(GrassTile, iter, i);
			}
		}
		
		
		for(int iter = 0; iter < 75; iter++){
			for(int i = 0; i < 45; i++){
				chance = gen.nextInt(10);
				if(chance == 1){
					GameBoard.addTileObject(GrassShade1, iter, i);
				}
			}
		}
		
		
		for(int iter = 0; iter < 75; iter++){
			for(int i = 0; i < 45; i++){
				chance = gen.nextInt(10);
				if(chance == 1){
					GameBoard.addTileObject(GrassShade2, iter, i);
				}
			}
		}
		
		

		
		// Walls
		
		for(int a = 15; a < 65; a++){
			GameBoard.addTileObject(WallColor, a, 10);
			GameBoard.addTileObject(WallColor, a, 30);
		}
		
		for(int b = 10; b < 31; b++){
			GameBoard.addTileObject(WallColor, 15, b);
			GameBoard.addTileObject(WallColor, 65, b);
		}
		

		//Floors
		
		for(int c = 16; c < 65; c++){
			GameBoard.addTileObject(FloorColor, c , 11);
			GameBoard.addTileObject(FloorColor, c , 12);
			GameBoard.addTileObject(FloorColor, c , 13);
			GameBoard.addTileObject(FloorColor, c , 14);
			GameBoard.addTileObject(FloorColor, c , 15);
			GameBoard.addTileObject(FloorColor, c , 16);
			GameBoard.addTileObject(FloorColor, c , 17);
			GameBoard.addTileObject(FloorColor, c , 18);
			GameBoard.addTileObject(FloorColor, c , 19);
			GameBoard.addTileObject(FloorColor, c , 20);
			GameBoard.addTileObject(FloorColor, c , 21);
			GameBoard.addTileObject(FloorColor, c , 22);
		}
		
		for(int d = 16; d < 33; d++){
			GameBoard.addTileObject(ConcreteTile, d , 22);
			GameBoard.addTileObject(ConcreteTile, d , 23);
			GameBoard.addTileObject(ConcreteTile, d , 24);
			GameBoard.addTileObject(ConcreteTile, d , 25);
			GameBoard.addTileObject(ConcreteTile, d , 26);
			GameBoard.addTileObject(ConcreteTile, d , 27);
			GameBoard.addTileObject(ConcreteTile, d , 28);
			GameBoard.addTileObject(ConcreteTile, d , 29);
			
		}
		
		for(int f = 16; f < 33; f++){
			GameBoard.addTileObject(ConcreteTile, f , 31);
			GameBoard.addTileObject(ConcreteTile, f , 32);
			GameBoard.addTileObject(ConcreteTile, f , 33);
			GameBoard.addTileObject(ConcreteTile, f , 34);
			GameBoard.addTileObject(ConcreteTile, f , 35);
			GameBoard.addTileObject(ConcreteTile, f , 36);
			GameBoard.addTileObject(ConcreteTile, f , 37);
			GameBoard.addTileObject(ConcreteTile, f , 38);
			GameBoard.addTileObject(ConcreteTile, f , 39);
			GameBoard.addTileObject(ConcreteTile, f , 40);
			GameBoard.addTileObject(ConcreteTile, f , 41);
			GameBoard.addTileObject(ConcreteTile, f , 42);
			GameBoard.addTileObject(ConcreteTile, f , 43);
			GameBoard.addTileObject(ConcreteTile, f , 44);
		}
		
		for(int iter = 32; iter < 43; iter++){
			for(int i = 35; i < 38; i++){
				GameBoard.addTileObject(ConcreteTile, iter, i);
			}
		}
		
		for(int iter = 40; iter < 43; iter++){
			for(int i = 31; i < 38; i++){
				GameBoard.addTileObject(ConcreteTile, iter, i);
			}
		}
		
		for(int e = 33; e < 65; e++){
			GameBoard.addTileObject(FloorColor, e , 22);
			GameBoard.addTileObject(FloorColor, e , 23);
			GameBoard.addTileObject(FloorColor, e , 24);
			GameBoard.addTileObject(FloorColor, e , 25);
			GameBoard.addTileObject(FloorColor, e , 26);
			GameBoard.addTileObject(FloorColor, e , 27);
			GameBoard.addTileObject(FloorColor, e , 28);
			GameBoard.addTileObject(FloorColor, e , 29);
		}
		
		//Inside Walls
		
		for(int g = 15; g < 32; g++){
			GameBoard.addTileObject(WallColor, g, 16);
			
			
		}
		
		for(int h = 15; h < 39; h++){
			GameBoard.addTileObject(WallColor, h, 21);
		}
		
		for(int j = 44; j < 65; j++){
			GameBoard.addTileObject(WallColor, j, 25);
		}
		
		for(int k = 48; k < 56; k++){
			GameBoard.addTileObject(WallColor, k, 13);
			GameBoard.addTileObject(WallColor, k, 21);
		}
		
		for(int l = 10; l <22; l++){
			GameBoard.addTileObject(WallColor, 48, l);
			GameBoard.addTileObject(WallColor, 56, l);
		}
		
		
		for(int m = 17; m < 22; m++){
			GameBoard.addTileObject(WallColor, 24, m);
			GameBoard.addTileObject(WallColor, 29, m);

		}
	
		for(int n = 16; n < 22; n++){
			GameBoard.addTileObject(WallColor, 32, n);
		}
		
		for(int z = 22; z < 30; z++){
			GameBoard.addTileObject(WallColor, 34, z);
		}
		
		for(int z = 21; z < 30; z++){
			GameBoard.addTileObject(WallColor, 39, z);
		}
		
		for(int x = 25; x < 31; x++ ){
			GameBoard.addTileObject(WallColor, 43, x);
			GameBoard.addTileObject(WallColor, 52, x);
			GameBoard.addTileObject(WallColor, 56, x);
		}
		
		for(int y = 19; y < 25; y++){
			GameBoard.addTileObject(WallColor,61 , y);
		}
		
		for(int o = 56; o < 65; o++){
			GameBoard.addTileObject(WallColor, o, 18);
		}
		
		for(int p = 52; p < 56 ; p++){
			GameBoard.addTileObject(WallColor, p, 28);
		}
		
		
		
		GameBoard.addTileObject(WallColor, 32, 11);	
		GameBoard.addTileObject(WallColor, 32, 12);
		
		GameBoard.addTileObject(WallColor, 32, 15);
		
		
		//Door Tiles
		
		GameBoard.addTileObject(DoorColor, 29, 10);
		GameBoard.addTileObject(DoorColor, 30, 10);
		
		for(int f= 17; f < 33; f++){
			GameBoard.addTileObject(DoorColor, f, 30);
		}
		
		GameBoard.addTileObject(DoorColor, 15, 17);
		GameBoard.addTileObject(DoorColor, 15, 18);
		GameBoard.addTileObject(DoorColor, 15, 22);
		GameBoard.addTileObject(DoorColor, 15, 23);
		
		GameBoard.addTileObject(DoorColor, 34, 27);
		GameBoard.addTileObject(DoorColor, 34, 28);
		
		GameBoard.addTileObject(DoorColor, 39, 22 );
		GameBoard.addTileObject(DoorColor, 39, 23 );
		
		GameBoard.addTileObject(DoorColor, 56, 11);
		GameBoard.addTileObject(DoorColor, 56, 12);
		
		GameBoard.addTileObject(DoorColor, 58, 18);
		GameBoard.addTileObject(DoorColor, 59, 18);
		GameBoard.addTileObject(DoorColor, 62, 18);
		GameBoard.addTileObject(DoorColor, 63, 18);
		
		GameBoard.addTileObject(DoorColor, 52, 21);
		GameBoard.addTileObject(DoorColor, 53, 21);
		
		GameBoard.addTileObject(DoorColor, 58, 25);
		GameBoard.addTileObject(DoorColor, 59, 25);
		
		GameBoard.addTileObject(DoorColor, 46, 25);
		GameBoard.addTileObject(DoorColor, 45, 25);
		
		GameBoard.addTileObject(DoorColor, 52, 26);
		GameBoard.addTileObject(DoorColor, 52, 27);
		
		GameBoard.addTileObject(DoorColor, 56, 29);
		
		GameBoard.addTileObject(DoorColor, 26, 16);
		GameBoard.addTileObject(DoorColor, 27, 16);
		
		GameBoard.addTileObject(DoorColor, 22, 16);
		GameBoard.addTileObject(DoorColor, 21, 16);
		
		GameBoard.addTileObject(DoorColor, 26, 21);
		GameBoard.addTileObject(DoorColor, 27, 21);
		
		GameBoard.addTileObject(DoorColor, 29, 18);
		GameBoard.addTileObject(DoorColor, 29, 19);
		
		GameBoard.addTileObject(DoorColor, 40, 30);
		GameBoard.addTileObject(DoorColor, 41, 30);
		GameBoard.addTileObject(DoorColor, 42, 30);
		
		
		
		
		
		
		
		
		
		//Top Windows
		
		GameBoard.addTileObject(TopWindow, 24, 10);
		GameBoard.addTileObject(TopWindow, 25, 10);
		GameBoard.addTileObject(TopWindow, 26, 10);
		GameBoard.addTileObject(TopWindow, 27, 10);
		
		GameBoard.addTileObject(TopWindow, 17, 10);
		GameBoard.addTileObject(TopWindow, 18, 10);
		
		GameBoard.addTileObject(TopWindow, 34, 10);
		GameBoard.addTileObject(TopWindow, 35, 10);
		GameBoard.addTileObject(TopWindow, 36, 10);
		
		GameBoard.addTileObject(TopWindow, 43, 10);
		GameBoard.addTileObject(TopWindow, 44, 10);
		GameBoard.addTileObject(TopWindow, 45, 10);
		
		GameBoard.addTileObject(TopWindow, 59, 10);
		GameBoard.addTileObject(TopWindow, 60, 10);
		GameBoard.addTileObject(TopWindow, 61, 10);
		GameBoard.addTileObject(TopWindow, 62, 10);
		GameBoard.addTileObject(TopWindow, 63, 10);
		
		//Right Windows
		
		GameBoard.addTileObject(RightWindow, 65, 19);
		GameBoard.addTileObject(RightWindow, 65, 20);


		//Bottom Windows
		
		GameBoard.addTileObject(BottomWindow, 63, 30);
		GameBoard.addTileObject(BottomWindow, 62, 30);
		GameBoard.addTileObject(BottomWindow, 62, 30);
		GameBoard.addTileObject(BottomWindow, 61, 30);
		GameBoard.addTileObject(BottomWindow, 60, 30);
		
		GameBoard.addTileObject(BottomWindow, 50, 30);
		GameBoard.addTileObject(BottomWindow, 49, 30);
		
		GameBoard.addTileObject(BottomWindow, 47, 30);
		GameBoard.addTileObject(BottomWindow, 46, 30);
		
		GameBoard.addTileObject(GameBoyTile, 61, 28);
		GameBoard.addTileObject(AppleTile, 31, 20);
		GameBoard.addTileObject(LaptopTile, 18, 19);
		GameBoard.addTileObject(BallTile, 56, 35);
		GameBoard.addTileObject(GasCanTile, 32, 28);
		GameBoard.addTileObject(WaterBottleTile1, 17, 12);
		GameBoard.addTileObject(WaterBottleTile2, 49, 11);
		GameBoard.addTileObject(WaterBottleTile3, 54, 26);
		GameBoard.addTileObject(ShoesTile, 44, 11);
		GameBoard.addTileObject(WalkieTalkieTile, 37, 25);
		GameBoard.addTileObject(BlanketTile, 60, 12);
		GameBoard.addTileObject(PhoneTile, 50, 16);
		GameBoard.addTileObject(CanTile, 63, 23);
		
		

	
		
		for(int z = 22; z < 30; z++){
			GameBoard.addTileObject(ConcreteTile, 33, z);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	
		GameBoard.addTileObject(Battery, 44, 29);
		
		GameBoard.addTileObject(Flashlight, 51, 28);
	
	}
}

