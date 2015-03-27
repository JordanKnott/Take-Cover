package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class WalkieTalkieTileImageHandler {

	String BatteryTileImage = getClass().getResource("/net/assets/items/WalkieTalkie.png").toString();
	
    private Image batteryTileImage = new Image(BatteryTileImage);
    
    public Image returnImage(){
    	return batteryTileImage;
    }
}
