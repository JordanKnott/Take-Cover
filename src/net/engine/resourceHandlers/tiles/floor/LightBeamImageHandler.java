package net.engine.resourceHandlers.tiles.floor;

import javafx.scene.image.Image;

public class LightBeamImageHandler {

	String BlankTile = getClass().getResource("/net/assets/tiles/floor/LightBeam.png").toString();
	
    public Image blankTile = new Image(BlankTile);
    
    public Image returnImage(){
    	return blankTile;
    }
	
}
