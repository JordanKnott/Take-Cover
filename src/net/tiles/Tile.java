package net.tiles;

import javafx.scene.image.Image;
import net.items.Item;

public class Tile {


	
	boolean doesCauseCollision = false;

	Item[] itemArray = new Item[10];
	
	int curItemArrayNumber = 0;
	
	
	public boolean causesCollision(){
		
		return doesCauseCollision;
		
	}
	
	
	
	public Item[] returnItemArray(){
		
		return itemArray;
		
	}
	
	public void setPickedUp(boolean b){
		
	}
	
	public Image returnTileImage(String cause){
		
		return null;
	}
	
	public boolean isSpecial(){
		return false;
	}
	
	public void doSpecial(){
		
		
	}
	public boolean getActive(){ return false; }
	
	public static String getName(){
		return null;
	}
	
	public static boolean getPickedUp(){
		return false;
	}
	
	public boolean isNeeded(){
		return false;
	}
	
	public String returnFloorType(){
		return null;
	}
	
	public void addItemToTileInventory(Item itemHandle){
		if(curItemArrayNumber > 9){
			curItemArrayNumber = 0;
		}
		
		itemArray[curItemArrayNumber] = itemHandle;
		curItemArrayNumber++;
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void setInactive() {
		// TODO Auto-generated method stub
		
	}
}
