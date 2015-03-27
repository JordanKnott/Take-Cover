package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class WaterBottleTileImageHandler {

	String BatteryTileImage = getClass().getResource("/net/assets/items/WaterBottle.png").toString();
	
    private Image batteryTileImage = new Image(BatteryTileImage);
    
    public Image returnImage(){
    	return batteryTileImage;
    }
}
