package net.tiles.itemTiles;

import javafx.scene.image.Image;
import net.engine.AssetLoader;
import net.engine.Engine;
import net.items.Item;
import net.tiles.Tile;

public class CanTile extends Tile{

	boolean doesCauseCollision = false;

	

	
	
	Item[] itemArray = new Item[10];
	
	int curItemArrayNumber = 0;
	//Item canItem = new BatteryItem();

	static boolean pickedUp = false;
	private static String name = "Can of food";
	public static String getName(){
		return name;
	}
	
	public static boolean getPickedUp(){
		return pickedUp;
	}
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
		//itemArray[0] = batteryItem;
		if( pickedUp == false ){
			return AssetLoader.returnCanImage();
		}else if(pickedUp == true){
			return AssetLoader.returnFloorColorImage();
		}
		return null;
	}
		
	public boolean isSpecial(){
		return true;
	}
	
	public void doSpecial(){
		if(pickedUp == false){
			Engine.activateDialog(getName(),isNeeded(),this);
		}

	}
	
	public void setPickedUp(boolean state){
		this.pickedUp = state;
	}
	public boolean isNeeded(){
		return true;
	}
	

	public boolean hasItem(String itemInQuestion){

		return true;
	}
}