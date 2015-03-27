package net.tiles.specTiles;

import javafx.scene.image.Image;
import net.engine.AssetLoader;
import net.engine.Engine;
import net.items.BatteryItem;
import net.items.Item;
import net.tiles.Tile;

public class TakeCoverTile extends Tile{

	private boolean doesCauseCollision = false;

	private Item[] itemArray = new Item[10];
	
	private int curItemArrayNumber = 0;
	private Item batteryItem = new BatteryItem();

	private int LevelID;
	private boolean isSafe;
	
	private static String name = "Take Cover";
	public static String getName(){
		return name;
	}
	
	public TakeCoverTile(boolean isSafe, int LevelID){
		this.isSafe = isSafe;
		this.LevelID = LevelID;
	}
	
	
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
	

		return AssetLoader.returnRedImage();

	}
		
	public boolean isSpecial(){
		return true;
	}
	public void doSpecial(){

		Engine.activateTakeCoverDialog(isSafe, LevelID);
		

	}
	public boolean hasItem(String itemInQuestion){

		return true;
	}
}