package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class BallTileImageHandler {

	String BatteryTileImage = getClass().getResource("/net/assets/items/Ball.png").toString();
	
    private Image batteryTileImage = new Image(BatteryTileImage);
    
    public Image returnImage(){
    	return batteryTileImage;
    }
}
