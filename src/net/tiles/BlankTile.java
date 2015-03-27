package net.tiles;

import javafx.scene.image.Image;
import net.items.Item;
import net.engine.AssetLoader;



public class BlankTile extends Tile{

	
	boolean doesCauseCollision = false;

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
		return AssetLoader.returnCharacter1();
	}
		
	public boolean isSpecial(){
		return false;
	}
	
	public void doSpecial(){
		
		
	}
	public boolean hasItem(String itemInQuestion){

		return true;
	}
}
