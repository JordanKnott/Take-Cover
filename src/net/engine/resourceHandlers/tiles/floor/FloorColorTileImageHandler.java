package net.engine.resourceHandlers.tiles.floor;

import javafx.scene.image.Image;

public class FloorColorTileImageHandler {

	
	String FloorColor = getClass().getResource("/net/assets/tiles/floor/FloorColor.png").toString();
	 
    public Image floorColor = new Image(FloorColor);
    
    public Image returnImage(){
    	return floorColor;
    }
	
}
