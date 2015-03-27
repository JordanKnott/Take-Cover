package net.levels;

import net.engine.Engine;
import net.engine.GameBoard;
import net.items.BatteryItem;
import net.items.Item;
import net.tiles.*;
import net.tiles.itemTiles.BatteryTile;
import net.tiles.itemTiles.CanTile;
import net.tiles.itemTiles.FlashlightTile;
public class DevTestLevel extends Level {
	
	
	
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
	
	Tile TestTile = new TestTile();
	
	Item battery = new BatteryItem();
	
	String[] winCondition = null;
	
	/*	
	Tile wall = new VerticalWallTile();
	Tile wall = new HorizontalWallTile();
	Tile wall = new CornerWallTile();
*/
	
	public String[] winCondition(){
		
		return winCondition;
		
	}
	
	
	public void populateGameBoard(GameBoard gameBoard){
		//						ObName X  Y
		
		
		//Setting up player
		Engine.mainPlayer().setPlayerCords(5, 5);;
		Engine.setPlayerStorageSpace(10);
		

		//Setting up game board
		for(int i = 4; i < 34; i++){
			GameBoard.addTileObject(DoorColor, 2, i);
		}
		for(int i = 2; i < 35; i++){
			GameBoard.addTileObject(GrassTile, i, 4);
			GameBoard.addTileObject(FloorColor, i, 34);
		}
		for(int i = 4; i < 9; i++){
			GameBoard.addTileObject(ConcreteTile, 14, i);
		}
		for(int i = 2; i < 14; i++){
			GameBoard.addTileObject(WallTile, i, 17);
		}
		for(int i = 12; i < 22; i++){
			GameBoard.addTileObject(DoorColor, 14, i);
		}	
		for(int i = 2; i < 7; i++){
			GameBoard.addTileObject(BottomWindow, i, 27);
		}
		for(int i = 9; i < 18; i++){
			GameBoard.addTileObject(TopWindow, i, 27);
		}
		for(int i = 24; i < 30; i++){
			GameBoard.addTileObject(RightWindow, 14, i);
		}
		for(int i = 32; i < 35; i++){
			GameBoard.addTileObject(WallTile, 14, i);
		}
		for(int i = 5; i < 15; i++){
			GameBoard.addTileObject(WallTile, 24, i);
		}
		for(int i = 18; i < 30; i++){
			GameBoard.addTileObject(WallTile, 24, i);
		}
			
		GameBoard.addTileObject(WallTile, 24, 33);
		
		for(int i = 20; i < 28; i++){
			GameBoard.addTileObject(WallTile, i, 27);
		}		
		for(int i = 5; i < 15; i++){
			GameBoard.addTileObject(WallTile, 34 , i);
		}
		for(int i = 18; i < 35; i++){
			GameBoard.addTileObject(WallTile, 34 , i);
		}
		for(int i = 30; i < 34; i++){
			GameBoard.addTileObject(WallTile, i, 26);
		}
		
		GameBoard.addTileObject(TestTile, 45,30);
		
		GameBoard.addTileObject(BatteryTile,45,40);
		
		GameBoard.addTileObject(CanTile, 45,20);
		
		GameBoard.addTileObject(FlashlightTile,45,30);
	}
		
		
}

	
	
	
	

