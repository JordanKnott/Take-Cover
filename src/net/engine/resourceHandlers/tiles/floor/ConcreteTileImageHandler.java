package net.engine.resourceHandlers.tiles.floor;

import javafx.scene.image.Image;

public class ConcreteTileImageHandler {

	
	String ConcreteTile = getClass().getResource("/net/assets/tiles/floor/ConcreteTile.png").toString();
	
    public Image concreteTile = new Image(ConcreteTile);
    
    public Image returnImage(){
    	return concreteTile;
    }
    
}
