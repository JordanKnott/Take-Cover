package net.engine.resourceHandlers.tiles.floor;

import javafx.scene.image.Image;

public class WallTileImageHandler {

	String WallTile = getClass().getResource("/net/assets/tiles/walls/Wall.png").toString();
    public Image wallTile = new Image(WallTile);
    
    public Image returnImage(){
    	return wallTile;
    }
}
