package net.engine.resourceHandlers.tiles.floor;

import javafx.scene.image.Image;

public class RedTileImageHandler {

	String BlankTile = getClass().getResource("/net/assets/tiles/floor/RedTile.png").toString();
	
    public Image blankTile = new Image(BlankTile);
    
    public Image returnImage(){
    	return blankTile;
    }
	
}
