package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class LaptopTileImageHandler {

	String BatteryTileImage = getClass().getResource("/net/assets/items/Laptop.png").toString();
	
    private Image batteryTileImage = new Image(BatteryTileImage);
    
    public Image returnImage(){
    	return batteryTileImage;
    }
}
