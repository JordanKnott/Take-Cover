package net.tiles;

import javafx.scene.image.Image;
import net.items.Item;
import net.engine.AssetLoader;
import net.engine.Engine;


public class TestTile extends Tile{


	
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
		
		return AssetLoader.returnPlayerImage();
	}
	public boolean isSpecial(){
		return true;
	}
	
	public void doSpecial(){
		
		Engine.setGameOver("W");
		
	}
	
}
