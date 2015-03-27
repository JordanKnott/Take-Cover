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
import net.tiles.GrassTile;
import net.tiles.SchoolFloorTile;
import net.tiles.Tile;

public class SchoolEntity3 extends Tile{

	private static int x;
	private static int y;
	
	private static boolean active;
	
	private static int curProg = 0;
	
	private static int textureID = 1;
	
	public SchoolEntity3(int x, int y, boolean active){
		SchoolEntity3.x = x;
		SchoolEntity3.y = y;
		SchoolEntity3.active = active;
		//Random gen = new Random();
		//textureID = gen.nextInt(5);
		
	}
	
	
	public static void moveUp(){
		if(Engine.gameBoard.returnTile(x, y-1).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new GrassTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity3(x,y-1,active), x, y);
			
			
		}
	}
	
	public static void moveDown(){
		if(Engine.gameBoard.returnTile(x, y+1).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new GrassTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity3(x,y+1,active), x, y);
			
			
		}
	}
	
	public void moveLeft(){
		if(Engine.gameBoard.returnTile(x-1, y).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new GrassTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity3(x-1,y,active), x, y);
			
			
		}
	}
	
	public void moveRight(){
		if(Engine.gameBoard.returnTile(x+1, y).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new GrassTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity3(x+1,y,active), x, y);
			
			
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
			moveRight();
			curProg++;
		}
		else if(curProg == 6){
			moveRight();
			curProg++;
		}
		else if(curProg == 7){
			moveRight();
			curProg++;
		}
		else if(curProg == 8){
			moveRight();
			curProg++;
		}
		else if(curProg == 9){
			moveRight();
			curProg++;
		}
		else if(curProg == 10){
			moveRight();
			curProg++;
		}
		else if(curProg == 11){
			moveRight();
			curProg++;
		}
		else if(curProg == 12){
			moveRight();
			curProg++;
		}
		else if(curProg == 13){
			moveRight();
			curProg++;
		}
		else if(curProg == 14){
			moveUp();
			curProg++;
		}
		else if(curProg == 15){
			moveUp();
			curProg++;
		}
		else if(curProg == 16){
			moveUp();
			curProg++;
		}
		else if(curProg == 17){
			moveUp();
			curProg++;
		}
		else if(curProg == 18){
			moveUp();
			curProg++;
		}
		else if(curProg == 19){
			moveUp();
			curProg++;
		}
		else if(curProg == 20){
			moveLeft();
			curProg++;
		}
		else if(curProg == 21){
			moveLeft();
			curProg++;
		}
		else if(curProg == 22){
			moveLeft();
			curProg++;
		}
		else if(curProg == 23){
			moveLeft();
			curProg++;
		}
		else if(curProg == 24){
			moveLeft();
			curProg++;
		}
		else if(curProg == 25){
			moveLeft();
			curProg++;
		}
		else if(curProg == 26){
			moveLeft();
			curProg++;
		}
		else if(curProg == 27){
			moveLeft();
			curProg++;
		}
		else if(curProg == 28){
			moveLeft();
			curProg++;
		}
		else if(curProg == 29){
			moveDown();
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
			return AssetLoader.returnGrassImage();
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
