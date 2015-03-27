package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class GasCanTileImageHandler {

	String BatteryTileImage = getClass().getResource("/net/assets/items/GasCan.png").toString();
	
    private Image batteryTileImage = new Image(BatteryTileImage);
    
    public Image returnImage(){
    	return batteryTileImage;
    }
}
