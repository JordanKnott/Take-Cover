package net.engine.resourceHandlers.tiles.floor;

import javafx.scene.image.Image;

public class GrassShade1TileImageHandler {

	
	String FloorColor = getClass().getResource("/net/assets/tiles/floor/Grass1.png").toString();
	 
    public Image floorColor = new Image(FloorColor);
    
    public Image returnImage(){
    	return floorColor;
    }
	
}
