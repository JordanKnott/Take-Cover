package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class BlanketTileImageHandler {

	String BatteryTileImage = getClass().getResource("/net/assets/items/Blanket.png").toString();
	
    public Image batteryTileImage = new Image(BatteryTileImage);
    
    public Image returnImage(){
    	return batteryTileImage;
    }
}
