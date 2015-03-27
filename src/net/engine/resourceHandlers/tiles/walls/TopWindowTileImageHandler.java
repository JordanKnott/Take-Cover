package net.engine.resourceHandlers.tiles.walls;

import javafx.scene.image.Image;

public class TopWindowTileImageHandler {

	
	String TopWindow = getClass().getResource("/net/assets/tiles/walls/TopWindow.png").toString();
    public Image topWindow = new Image(TopWindow);
	
    public Image returnImage(){
    	return topWindow;
    }
}
