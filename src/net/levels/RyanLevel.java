package net.levels;

import net.engine.GameBoard;
import net.tiles.Tile;
import net.tiles.WallTile;

public class RyanLevel extends Level{

	
	
	
	
	Tile wall1 = new WallTile();
	Tile wall2 = new WallTile();
	Tile wall3 = new WallTile();
	Tile wall4 = new WallTile();
	Tile wall5 = new WallTile();
	Tile wall6 = new WallTile();
	Tile wall7 = new WallTile();
	Tile wall8 = new WallTile();
	Tile wall9 = new WallTile();
	
	
	
	public void populateGameBoard(GameBoard gameBoard){
		
		GameBoard.addTileObject(wall1, 10, 5);
		GameBoard.addTileObject(wall2, 10, 6);
		GameBoard.addTileObject(wall3, 10, 7);
		GameBoard.addTileObject(wall4, 10, 8);
		GameBoard.addTileObject(wall5, 10, 9);
		GameBoard.addTileObject(wall6, 10, 10);
	}
	
	
}
