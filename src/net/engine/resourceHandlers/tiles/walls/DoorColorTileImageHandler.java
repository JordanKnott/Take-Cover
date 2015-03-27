package net.engine.resourceHandlers.tiles.walls;

import javafx.scene.image.Image;

public class DoorColorTileImageHandler {
	
	String DoorColor = getClass().getResource("/net/assets/tiles/walls/DoorColor.png").toString();
	   public Image doorColor = new Image(DoorColor);
	   
	   public Image returnImage(){
		   return doorColor;
	   }
}
