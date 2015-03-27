package net.engine.resourceHandlers.tiles.floor;

import javafx.scene.image.Image;

public class RoofBlueImageHandler {

	String BlankTile = getClass().getResource("/net/assets/tiles/floor/RoofBlue.png").toString();
	
    public Image blankTile = new Image(BlankTile);
    
    public Image returnImage(){
    	return blankTile;
    }
	
}
