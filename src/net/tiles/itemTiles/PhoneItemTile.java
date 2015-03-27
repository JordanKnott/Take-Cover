package net.tiles.itemTiles;

import javafx.scene.image.Image;
import net.engine.Engine;
import net.engine.resourceHandlers.itemTileImageHandlers.BatteryTileImageHandler;
import net.engine.resourceHandlers.itemTileImageHandlers.FlashlightTileImageHandler;
import net.engine.resourceHandlers.itemTileImageHandlers.PhoneTileImageHandler;
import net.engine.resourceHandlers.tiles.floor.BlankTileImageHandle;
import net.items.BatteryItem;
import net.items.Item;
import net.tiles.Tile;

public class PhoneItemTile extends Tile{
	PhoneTileImageHandler bTileImage = new PhoneTileImageHandler();
	BlankTileImageHandle blankTile = new BlankTileImageHandle();
	boolean doesCauseCollision = false;

	Item[] itemArray = new Item[10];
	
	int curItemArrayNumber = 0;
	Item batteryItem = new BatteryItem();

	static boolean pickedUp = false;
	private static String name = "Phone";
	public boolean causesCollision(){
		
		return doesCauseCollision;
		
	}
	
	public static String getName(){
		return name;
	}
	
	public static boolean getPickedUp(){
		return pickedUp;
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

		if( pickedUp == false ){
			return bTileImage.returnImage();
		}else if(pickedUp == true){
			return blankTile.returnImage();
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
	
	public boolean isNeeded(){
		return false;
	}
	

	public boolean hasItem(String itemInQuestion){

		return true;
	}
}
