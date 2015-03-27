package net.tiles;

import javafx.scene.image.Image;
import net.items.Item;
import net.engine.resourceHandlers.itemTileImageHandlers.BatteryTileImageHandler;
import net.engine.resourceHandlers.tiles.floor.BlankTileImageHandle;
import net.engine.resourceHandlers.tiles.floor.ConcreteTileImageHandler;
import net.engine.resourceHandlers.tiles.floor.SecondDeepestDitchImageHandler;



public class SecondDeepestDitchTile extends Tile{
	SecondDeepestDitchImageHandler secondDeepestDitchImageHandler = new SecondDeepestDitchImageHandler();
	BlankTileImageHandle BlankTileImageHandle = new BlankTileImageHandle();
	
	boolean doesCauseCollision = false;

	Item[] itemArray = new Item[10];
	
	int curItemArrayNumber = 0;
	
	
	public boolean causesCollision(){
		
		return doesCauseCollision;
		
	}
	public String returnFloorType(){
		return "SecondDeepestDitch";
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

				
				
				return secondDeepestDitchImageHandler.returnImage();
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
