package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class BatteryTileImageHandler {

	String BatteryTileImage = getClass().getResource("/net/assets/items/Battery.png").toString();
	
    public Image batteryTileImage = new Image(BatteryTileImage);
    
    public Image returnImage(){
    	return batteryTileImage;
    }
}
