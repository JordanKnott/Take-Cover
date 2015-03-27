package net.engine.resourceHandlers.tiles.walls;

import javafx.scene.image.Image;

public class RightWindowTileImageHandler {


	String RightWindow = getClass().getResource("/net/assets/tiles/walls/RightWindow.png").toString();
	

    public Image rightWindow = new Image(RightWindow);
    
    public Image returnImage(){
    	return rightWindow;
    }
}
