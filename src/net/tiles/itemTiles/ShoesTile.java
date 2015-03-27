package net.tiles.itemTiles;
import javafx.scene.image.Image;
import net.engine.AssetLoader;
import net.engine.Engine;
import net.items.BatteryItem;
import net.items.Item;
import net.tiles.Tile;

public class ShoesTile extends Tile{

	private boolean doesCauseCollision = false;

	private Item[] itemArray = new Item[10];
	
	private int curItemArrayNumber = 0;
	private Item batteryItem = new BatteryItem();

	private static boolean pickedUp = false;
	private static String name = "Shoes";
	public boolean causesCollision(){
		
		return doesCauseCollision;
		
	}
	
	public Item[] returnItemArray(){
		
		return itemArray;
		
	}
	public static String getName(){
		return name;
	}
	public String returnFloorType(){
		return "HouseFloor";
	}
	
	public static boolean getPickedUp(){
		return pickedUp;
	}
	public void addItemToItemArray(Item itemHandle){
		
		if(curItemArrayNumber == 9 ){
			curItemArrayNumber = 0;
		}
		itemArray[curItemArrayNumber] = itemHandle;
		
		curItemArrayNumber ++;

	}
	
	public Image returnTileImage(String cause){
		itemArray[0] = batteryItem;
		if( pickedUp == false ){
			return AssetLoader.returnShoesImage();
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
	
	public boolean isNeeded(){
		return true;
	}
	
	public void setPickedUp(boolean state){
		this.pickedUp = state;
	}
	public boolean hasItem(String itemInQuestion){

		return true;
	}
}