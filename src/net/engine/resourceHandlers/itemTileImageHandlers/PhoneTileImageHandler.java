package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class PhoneTileImageHandler {
	String FlashlightTileImage = getClass().getResource("/net/assets/items/Phone.png").toString();
	
    public Image flashlightTileImage = new Image(FlashlightTileImage);
    
    public Image returnImage(){
    	return flashlightTileImage;
    }
}
