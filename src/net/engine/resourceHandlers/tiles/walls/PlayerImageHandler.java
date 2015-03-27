package net.engine.resourceHandlers.tiles.walls;

import javafx.scene.image.Image;

public class PlayerImageHandler {

	
	String defaultPlayerPath = getClass().getResource("/net/assets/tiles/entities/PlayerTile.png").toString();

	String concretePlayerPath = getClass().getResource("/net/assets/tiles/entities/CharacterConcrete.png").toString();

	String grassPlayerPath = getClass().getResource("/net/assets/tiles/entities/CharacterGrass.png").toString();

	String houseDoorPlayerPath = getClass().getResource("/net/assets/tiles/entities/CharacterHouseDoor.png").toString();

	String houseFloorPlayerPath = getClass().getResource("/net/assets/tiles/entities/CharacterHouseFloor.png").toString();

	String deepestDitchPath = getClass().getResource("/net/assets/tiles/entities/CharacterDeepestDitch.png").toString();
	
	String lightestDitchPath = getClass().getResource("/net/assets/tiles/entities/CharacterLightestDitch.png").toString();
	
	String secondDeepestDitch = getClass().getResource("/net/assets/tiles/entities/CharacterSecondDeepestDitch.png").toString();
	
	String secondLightestDitch = getClass().getResource("/net/assets/tiles/entities/CharacterSecondLightestDitch.png").toString();
	
	String yellowLinesPath = getClass().getResource("/net/assets/tiles/entities/CharacteYellowLines.png").toString();
	


    public Image defaultPlayerImage = new Image(defaultPlayerPath);
   
    public Image concretePlayerImage = new Image(concretePlayerPath);

    public Image grassPlayerImage = new Image(grassPlayerPath);

    public Image houseDoorPlayerImage = new Image(houseDoorPlayerPath);
    
    public Image houseFloorPlayerImage = new Image(houseFloorPlayerPath);
    
    public Image deepestDitchImage = new Image(deepestDitchPath);

    public Image lightestDitchImage = new Image(lightestDitchPath);
    
    public Image secondDeepestDitchImage = new Image(secondDeepestDitch);
    
    public Image secondLightestDitchImage = new Image(secondLightestDitch);
    
    public Image yellowLinesPathImage = new Image(yellowLinesPath);
    
    
}
