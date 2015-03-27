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

public class SchoolEntity4 extends Tile{

	private static int x;
	private static int y;
	
	private static boolean active;
	
	private static int curProg = 0;
	
	private static int textureID = 1;
	
	public SchoolEntity4(int x, int y, boolean active){
		SchoolEntity4.x = x;
		SchoolEntity4.y = y;
		SchoolEntity4.active = active;
		//Random gen = new Random();
		//textureID = gen.nextInt(5);
		
	}
	
	
	public static void moveUp(){
		if(Engine.gameBoard.returnTile(x, y-1).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new SchoolFloorTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity4(x,y-1,active), x, y);
			
			
		}
	}
	
	public static void moveDown(){
		if(Engine.gameBoard.returnTile(x, y+1).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new SchoolFloorTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity4(x,y+1,active), x, y);
			
			
		}
	}
	
	public void moveLeft(){
		if(Engine.gameBoard.returnTile(x-1, y).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new SchoolFloorTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity4(x-1,y,active), x, y);
			
			
		}
	}
	
	public void moveRight(){
		if(Engine.gameBoard.returnTile(x+1, y).causesCollision()){
			System.out.println("causes collision");
		}else {
			GameBoard.addTileObject(new SchoolFloorTile(), x, y);
			GameBoard.addTileObject(new SchoolEntity4(x+1,y,active), x, y);
			
			
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
			moveRight();
			curProg++;
		}else if(curProg == 1){
			moveRight();
			curProg++;
		}else if(curProg == 2){
			moveRight();
			curProg++;
		}else if(curProg == 3){
			moveRight();
			curProg++;
		}else if(curProg == 4){
			moveRight();
			curProg++;
		}else if(curProg == 5){
			moveRight();
			curProg++;
		}else if(curProg == 6){
			moveRight();
			curProg++;
		}else if(curProg == 7){
			moveRight();
			curProg++;
		}else if(curProg == 8){
			moveRight();
			curProg++;
		}else if(curProg == 9){
			moveRight();
			curProg++;
		}else if(curProg == 10){
			moveRight();
			curProg++;
		}else if(curProg == 11){
			moveRight();
			curProg++;
		}else if(curProg == 12){
			moveRight();
			curProg++;
		}else if(curProg == 13){
			moveRight();
			curProg++;
		}else if(curProg == 14){
			moveRight();
			curProg++;
		}else if(curProg == 15){
			moveRight();
			curProg++;
		}else if(curProg == 16){
			moveRight();
			curProg++;
		}else if(curProg == 17){
			moveRight();
			curProg++;
		}else if(curProg == 18){
			moveRight();
			curProg++;
		}else if(curProg == 19){
			moveRight();
			curProg++;
		}else if(curProg == 20){
			moveRight();
			curProg++;
		}else if(curProg == 21){
			moveRight();
			curProg++;
		}else if(curProg == 22){
			moveRight();
			curProg++;
		}else if(curProg == 23){
			moveRight();
			curProg++;
		}else if(curProg == 24){
			moveRight();
			curProg++;
		}else if(curProg == 25){
			moveRight();
			curProg++;
		}else if(curProg == 26){
			moveRight();
			curProg++;
		}else if(curProg == 27){
			moveRight();
			curProg++;
		}else if(curProg == 28){
			moveRight();
			curProg++;
		}else if(curProg == 29){
			moveRight();
			curProg++;
		}else if(curProg == 30){
			moveRight();
			curProg++;
		}else if(curProg == 31){
			moveDown();
			curProg++;
		}else if(curProg == 32){
			moveDown();
			curProg++;
		}else if(curProg == 33){
			moveLeft();
			curProg++;
		}else if(curProg == 34){
			moveLeft();
			curProg++;
		}else if(curProg == 35){
			moveLeft();
			curProg++;
		}else if(curProg == 36){
			moveLeft();
			curProg++;
		}else if(curProg == 37){
			moveLeft();
			curProg++;
		}else if(curProg == 38){
			moveLeft();
			curProg++;
		}else if(curProg == 39){
			moveLeft();
			curProg++;
		}else if(curProg == 40){
			moveLeft();
			curProg++;
		}else if(curProg == 41){
			moveLeft();
			curProg++;
		}else if(curProg == 41){
			moveLeft();
			curProg++;
		}else if(curProg == 42){
			moveLeft();
			curProg++;
		}else if(curProg == 43){
			moveLeft();
			curProg++;
		}else if(curProg == 44){
			moveLeft();
			curProg++;
		}else if(curProg == 45){
			moveLeft();
			curProg++;
		}else if(curProg == 46){
			moveLeft();
			curProg++;
		}else if(curProg == 47){
			moveLeft();
			curProg++;
		}else if(curProg == 48){
			moveLeft();
			curProg++;
		}else if(curProg == 49){
			moveLeft();
			curProg++;
		}else if(curProg == 50){
			moveLeft();
			curProg++;
		}else if(curProg == 51){
			moveLeft();
			curProg++;
		}else if(curProg == 52){
			moveLeft();
			curProg++;
		}else if(curProg == 53){
			moveLeft();
			curProg++;
		}else if(curProg == 54){
			moveLeft();
			curProg++;
		}else if(curProg == 55){
			moveLeft();
			curProg++;
		}else if(curProg == 56){
			moveLeft();
			curProg++;
		}else if(curProg == 57){
			moveLeft();
			curProg++;
		}else if(curProg == 58){
			moveLeft();
			curProg++;
		}else if(curProg == 59){
			moveLeft();
			curProg++;
		}else if(curProg == 60){
			moveLeft();
			curProg++;
		}else if(curProg == 61){
			moveLeft();
			curProg++;
		}else if(curProg == 62){
			moveUp();
			curProg++;
		}else if(curProg == 63){
			moveUp();
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