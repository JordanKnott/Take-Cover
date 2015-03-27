package net.tiles;

import javafx.scene.image.Image;
import net.engine.AssetLoader;
import net.items.Item;

public class FloorColor extends Tile{
	
	boolean doesCauseCollision = false;

	Item[] itemArray = new Item[10];
	
	int curItemArrayNumber = 0;
	
	
	public boolean causesCollision(){
		
		return doesCauseCollision;
		
	}
	
	public Item[] returnItemArray(){
		
		return itemArray;
		
	}
	public String returnFloorType(){
		return "HouseFloor";
	}
	public void addItemToItemArray(Item itemHandle){
		
		if(curItemArrayNumber == 9 ){
			curItemArrayNumber = 0;
		}
		itemArray[curItemArrayNumber] = itemHandle;
		
		curItemArrayNumber ++;
		
	}
	
	public Image returnTileImage(String cause){
		
		return AssetLoader.returnFloorColorImage();
	}
	public boolean isSpecial(){
		return false;
	}
	
	public void doSpecial(){
		
		
	}
}