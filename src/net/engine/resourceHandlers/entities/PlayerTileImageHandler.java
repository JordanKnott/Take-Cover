package net.engine.resourceHandlers.entities;

import javafx.scene.image.Image;

public class PlayerTileImageHandler {
	String PlayerTile = getClass().getResource("/net/assets/tiles/entities/PlayerTile.png").toString();
	
	public Image playerTile = new Image(PlayerTile);
	
	public Image returnImage(){
		return playerTile;
	}
}
