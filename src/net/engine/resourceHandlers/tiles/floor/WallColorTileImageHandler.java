package net.engine.resourceHandlers.tiles.floor;

import javafx.scene.image.Image;

public class WallColorTileImageHandler {

	
	String WallColor = getClass().getResource("/net/assets/tiles/walls/WallColor.png").toString();
	

    public Image wallColor = new Image(WallColor);
    
    public Image returnImage(){
    	return wallColor;
    }
}
