package net.engine.resourceHandlers.itemTileImageHandlers;

import javafx.scene.image.Image;

public class CanTileImageHandler {

	String CanTileImage = getClass().getResource("/net/assets/items/Can.png").toString();
	
    public Image canTileImage = new Image(CanTileImage);
    
    public Image returnImage(){
    	return canTileImage;
    }
}