package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class AppleTileImageHandler {

	String BatteryTileImage = getClass().getResource("/net/assets/items/Apple.png").toString();
	
    private Image batteryTileImage = new Image(BatteryTileImage);
    
    public Image returnImage(){
    	return batteryTileImage;
    }
}
