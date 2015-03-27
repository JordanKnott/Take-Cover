package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class FlashlightTileImageHandler {
	String FlashlightTileImage = getClass().getResource("/net/assets/items/Flashlight.png").toString();
	
    public Image flashlightTileImage = new Image(FlashlightTileImage);
    
    public Image returnImage(){
    	return flashlightTileImage;
    }
}
