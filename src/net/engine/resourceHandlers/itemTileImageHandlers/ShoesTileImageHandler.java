package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class ShoesTileImageHandler {

	String BatteryTileImage = getClass().getResource("/net/assets/items/Shoes.png").toString();
	
    private Image batteryTileImage = new Image(BatteryTileImage);
    
    public Image returnImage(){
    	return batteryTileImage;
    }
}
