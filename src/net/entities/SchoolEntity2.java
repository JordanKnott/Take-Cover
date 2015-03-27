package net.entities;




import java.util.Random;

import javafx.application.Platform;
import javafx.scene.image.Image;
import net.Start;
import net.engine.AssetLoader;
import net.engine.Engine;
import net.engine.GameBoard;
import net.engine.ImageBoard;
import net.engine.ScriptThread;
import net.items.Item;
import net.tiles.SchoolFloorTile;
import net.tiles.Tile;

public class SchoolEntity2 extends Tile{

	private static int x;
	private static int y;
	
	private static boolean active;
	
	private static int curProg = 0;
	
	private static int textureID = 3;
	
	public SchoolEntity2(int x, int y, boolean active){
		SchoolEntity2.x = x;
		SchoolEntity2.y = y;
		SchoolEntity2.active = active;

		
	}
	
	public static void moveUp(){
		if(Engine.gameBoard.returnTile(x, y-1).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new SchoolFloorTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity2(x,y-1,active), x, y);
			
			
		}
	}
	
	public static void moveDown(){
		if(Engine.gameBoard.returnTile(x, y+1).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new SchoolFloorTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity2(x,y+1,active), x, y);
			
			
		}
	}
	
	public void moveLeft(){
		if(Engine.gameBoard.returnTile(x-1, y).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new SchoolFloorTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity2(x-1,y,active), x, y);
			
			
		}
	}
	
	public void moveRight(){
		if(Engine.gameBoard.returnTile(x+1, y).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new SchoolFloorTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity2(x+1,y,active), x, y);
			
			
		}
	}
	
	
	public void update(){
		/*Random gen = new Random();
		int chance = gen.nextInt(3);
		if(chance == 0){
			
			
		}
		*/
		//moveUp();
		
		if(curProg == 0){
			moveDown();
			curProg++;
		}else if(curProg == 1){
			moveDown();
			curProg++;
		}
		else if(curProg == 2){
			moveDown();
			curProg++;
		}
		else if(curProg == 3){
			moveDown();
			curProg++;
		}
		else if(curProg == 4){
			moveDown();
			curProg++;
		}
		else if(curProg == 5){
			moveDown();
			curProg++;
		}
		else if(curProg == 6){
			moveDown();
			curProg++;
		}
		else if(curProg == 7){
			moveRight();
			curProg++;
		}
		else if(curProg == 8){
			moveUp();
			curProg++;
		}	
		else if(curProg == 9){
			moveUp();
			curProg++;
		}	
		else if(curProg == 10){
			moveUp();
			curProg++;
		}	
		else if(curProg == 11){
			moveUp();
			curProg++;
		}	
		else if(curProg == 12){
			moveUp();
			curProg++;
		}	
		else if(curProg == 13){
			moveUp();
			curProg++;
		}	
		else if(curProg == 14){
			moveUp();
			curProg++;
		}	
		else if(curProg == 15){
			moveLeft();
			curProg = 0;
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Engine.redraw();
		
	}
	
	public boolean getActive(){
		return active;
	}
	
	public void setInactive(){
		active = false;
		GameBoard.addTileObject(new SchoolFloorTile(), x, y);
	}
	
	boolean doesCauseCollision = false;

	Item[] itemArray = new Item[10];
	
	int curItemArrayNumber = 0;
	
	
	public boolean causesCollision(){
		
		return doesCauseCollision;
		
	}
	
	public Item[] returnItemArray(){
		
		return itemArray;
		
	}
	
	public void addItemToItemArray(Item itemHandle){
		
		if(curItemArrayNumber == 9 ){
			curItemArrayNumber = 0;
		}
		itemArray[curItemArrayNumber] = itemHandle;
		
		curItemArrayNumber ++;
		
	}
	
	public Image returnTileImage(String cause){
		if(active == false){
			return AssetLoader.returnSchoolFloorImage();
		}
		else if(textureID == 0){
			
			return AssetLoader.returnCharacter1();
		}else if(textureID == 1){
			return AssetLoader.returnCharacter2();
		}else if(textureID == 2){
			return AssetLoader.returnCharacter3();
		}else if(textureID == 3){
			return AssetLoader.returnCharacter4();
		}else if(textureID == 4){
			return AssetLoader.returnCharacter5();
		}else if(textureID == 5){
			return AssetLoader.returnCharacter6();
		}else {
			return null;
		}
		
	}
		
	public boolean isSpecial(){
		return true;
	}
	
	public void doSpecial(){
		if(active){
			Engine.activateSaveDialog(this);
		}
	}
	public boolean hasItem(String itemInQuestion){

		return true;
	}
	
}
