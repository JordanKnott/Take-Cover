package net.tiles.specTiles;

import javafx.scene.image.Image;
import net.engine.resourceHandlers.tiles.floor.RedTileImageHandler;
import net.engine.resourceHandlers.tiles.floor.WallTileImageHandler;
import net.items.Item;
import net.tiles.Tile;

public class RedTile extends Tile{

	RedTileImageHandler redTileImageHandler = new RedTileImageHandler();
	
	boolean doesCauseCollision = true;

	Item[] itemArray = new Item[10];
	
	int curItemArrayNumber = 0;
	
	
	public boolean causesCollision(){
		
		return doesCauseCollision;
		
	}
	
	public Item[] returnItemArray(){
		
		return itemArray;
		
	}
	
	public void addItemToItemArray(Item itemHandle){
		
		if(curItemArrayNumber == 9 ){
			curItemArrayNumber = 0;
		}
		itemArray[curItemArrayNumber] = itemHandle;
		
		curItemArrayNumber ++;
		
	}
	
	public Image returnTileImage(String cause){
		
		return redTileImageHandler.returnImage();
	}
	public boolean isSpecial(){
		return false;
	}
	
	public void doSpecial(){
		
		
	}
}