package net.engine.resourceHandlers;

import javafx.scene.image.Image;

public class MainMenuImageHandler {

	
	String Title = getClass().getResource("/net/assets/menu/TITLE.png").toString();
	

	String BlackBackground =  getClass().getResource("/net/assets/menu/BlackBackground.png").toString();
	
	
	
    public Image title = new Image(Title);
    public Image blackBackground = new Image(BlackBackground);
	
	
}
