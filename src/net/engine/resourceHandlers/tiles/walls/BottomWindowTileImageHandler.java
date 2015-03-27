package net.engine.resourceHandlers.tiles.walls;

import javafx.scene.image.Image;

public class BottomWindowTileImageHandler {

	String BottomWindow = getClass().getResource("/net/assets/tiles/walls/BottomWindow.png").toString();
	

    public Image bottomWindow = new Image(BottomWindow);
    
    public Image returnImage(){
    	return bottomWindow;
    }
}
