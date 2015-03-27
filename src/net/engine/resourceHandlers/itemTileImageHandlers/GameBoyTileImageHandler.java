package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class GameBoyTileImageHandler {

	String BatteryTileImage = getClass().getResource("/net/assets/items/GameBoy.png").toString();
	
    private Image batteryTileImage = new Image(BatteryTileImage);
    
    public Image returnImage(){
    	return batteryTileImage;
    }
}
