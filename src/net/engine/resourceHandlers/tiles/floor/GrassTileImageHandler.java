package net.engine.resourceHandlers.tiles.floor;

import javafx.scene.image.Image;

public class GrassTileImageHandler {

	String GrassTile = getClass().getResource("/net/assets/tiles/floor/GrassTile.png").toString();
	public Image grassTile = new Image(GrassTile);
	
	public Image returnImage(){
		return grassTile;
	}
    
	
}
