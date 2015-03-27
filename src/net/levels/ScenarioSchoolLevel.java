package net.levels;

import java.util.Random;

import net.engine.CountdownThread;
import net.engine.Engine;
import net.engine.GameBoard;
import net.engine.ScriptThread;
import net.entities.SchoolEntity;
import net.entities.SchoolEntity2;
import net.entities.SchoolEntity3;
import net.entities.SchoolEntity4;
import net.items.BatteryItem;
import net.items.Item;
import net.tiles.ConcreteTile;
import net.tiles.GrassTile;
import net.tiles.GrassTile1;
import net.tiles.GrassTile2;
import net.tiles.SchoolWallTile;
import net.tiles.TestTile;
import net.tiles.Tile;
import net.tiles.SchoolFloorTile;
import net.tiles.specTiles.TakeCoverTile;




public class ScenarioSchoolLevel extends Level {

	Tile ConcreteTile = new ConcreteTile();
	Tile GrassTile = new GrassTile();
	Tile Wall = new SchoolWallTile();
	Tile Floor = new SchoolFloorTile();
	
	Tile school = new SchoolEntity(18,14,true);
	Tile school2 = new SchoolEntity2(7,20,true);
	Tile school3 = new SchoolEntity3(50,8,true);
	Tile school4 = new SchoolEntity4(10,2,true);
	//Tile SchoolEntity = new SchoolTile();

	Tile safeTakeCoverTile = new TakeCoverTile(true, 2);
	Tile takeCoverTile = new TakeCoverTile(false, 2);
	Tile GrassShade1 = new GrassTile1();
	Tile GrassShade2 = new GrassTile2();
	Tile TestTile = new TestTile();
	
	Item battery = new BatteryItem();
	int chance;
	String[] winCondition = null;
	
	Random gen = new Random();
	public void populateGameBoard(GameBoard gameBoard){
		CountdownThread cThread = new CountdownThread(2);
		cThread.start();
		Thread thread = new ScriptThread(school);
		Thread thread2 = new ScriptThread(school2);
		Thread thread3 = new ScriptThread(school3);
		Thread thread4 = new ScriptThread(school4);
		thread.start();
		thread2.start();
		thread3.start();
		thread4.start();
		Engine.mainPlayer().setPlayerCords(9, 5);;
		Engine.setPlayerStorageSpace(10);
		Engine.mainPlayer().setCurrentLevelID(2);
		Engine.inGame = true;
		for(int iter = 0; iter < 75; iter++){
			for(int i = 0; i < 45; i++){
				GameBoard.addTileObject(GrassTile, iter, i);
			}
		}
		for(int iter = 0; iter < 75; iter++){
			for(int i = 0; i < 45; i++){
				chance = gen.nextInt(10);
				if(chance == 1){
					GameBoard.addTileObject(GrassShade1, iter, i);
				}
			}
		}
		
		
		for(int iter = 0; iter < 75; iter++){
			for(int i = 0; i < 45; i++){
				chance = gen.nextInt(10);
				if(chance == 1){
					GameBoard.addTileObject(GrassShade2, iter, i);
				}
			}
		}
		
		

	
		//TODO Concrete
		
		
		
		for(int iter = 5; iter < 41; iter++){
			for(int i = 1; i < 37; i ++){
				GameBoard.addTileObject(ConcreteTile, iter, i);
			}
		}
		
		GameBoard.addTileObject(ConcreteTile, 8, 0);
		GameBoard.addTileObject(ConcreteTile, 7, 0);
		
		
		for(int i = 0; i < 6; i ++){
			GameBoard.addTileObject(ConcreteTile, i, 3);
			GameBoard.addTileObject(ConcreteTile, i, 4);
		}
		
		for(int iter = 41; iter < 75; iter++){
			for(int i = 20; i < 25; i++ ){
				GameBoard.addTileObject(ConcreteTile, iter, i);
			}
		}
		
		
		for(int iter = 25; iter < 30; iter++){
			for(int i = 37; i < 45; i++ ){
				GameBoard.addTileObject(ConcreteTile, iter, i);
			}
		}
		
		//TODO Floor
		
		
		for(int iter = 9; iter < 41; iter++){
			for(int i = 5; i < 11; i++){
				GameBoard.addTileObject(Floor, iter, i);
			}
		}
		
		for(int iter = 5; iter < 37; iter++){
			for(int i = 9; i < 15; i++){
			GameBoard.addTileObject(Floor, i, iter);
			}
		}
			
		for(int i = 6; i < 37; i++){
			GameBoard.addTileObject(Floor, 7, i);
			GameBoard.addTileObject(Floor, 8, i);
		}
		
		for(int i = 7; i < 37; i++){
			GameBoard.addTileObject(Floor, 6, i);
			GameBoard.addTileObject(Floor, 5, i);
		}
		
		
		for(int i = 10; i < 41; i++){
			GameBoard.addTileObject(Floor, i, 3);
			GameBoard.addTileObject(Floor, i, 4);
		}
		
		for(int i = 11; i < 41; i++){
			GameBoard.addTileObject(Floor, i, 1);
			GameBoard.addTileObject(Floor, i, 2);
		}
		
		for(int iter = 15; iter < 29; iter++){
			for(int i = 11; i < 25; i ++){
				GameBoard.addTileObject(Floor, iter, i);
			}
		}
		
		//TODO Walls
		
		GameBoard.addTileObject(Wall, 9, 4);
		GameBoard.addTileObject(Wall, 8, 5);
		
		for(int i = 11; i < 41; i++){
			GameBoard.addTileObject(Wall, i, 1);

		}
		
		for(int i = 7; i < 37; i++){
			GameBoard.addTileObject(Wall, 5, i);

		}
		
		
		for(int i = 5; i < 15; i++){
			GameBoard.addTileObject(Wall, i, 36);
		}
		
		for(int i = 20; i < 37; i++){
			GameBoard.addTileObject(Wall, 15, i);
		}
		
		for(int i = 24; i < 41; i++){
			GameBoard.addTileObject(Wall, i, 11);
		}
		
		for(int i = 16; i < 28; i++){
			GameBoard.addTileObject(Wall, i, 24);
		}		
		
		for(int i = 11; i < 25; i++){
			GameBoard.addTileObject(Wall, 28, i);
		}
		
		for(int i = 1; i < 11; i++){
			GameBoard.addTileObject(Wall, 40, i);
		}
		
		for(int i = 9; i < 16; i++){
			GameBoard.addTileObject(Wall, i, 18);
			GameBoard.addTileObject(Wall, i, 22);
			GameBoard.addTileObject(Wall, i, 26);
			GameBoard.addTileObject(Wall, i, 32);
		}
		
		for(int i = 5; i < 12; i++){
			GameBoard.addTileObject(Wall, 21, i);
			GameBoard.addTileObject(Wall, 28, i);
			GameBoard.addTileObject(Wall, 34, i);
		}

		for(int i = 15; i < 19; i++){
			GameBoard.addTileObject(Wall, i, 20);
		}
		
		for(int i = 20; i < 25; i++){
			GameBoard.addTileObject(Wall, i, 12);
		}
		
		for(int i = 11; i < 15; i++){
			GameBoard.addTileObject(Wall, 24, i);
		}
		
		for(int i = 16; i < 20; i++){
			GameBoard.addTileObject(Wall, 16, i);
		}
		
		for(int i = 6; i < 14; i++){
			GameBoard.addTileObject(Wall, 16, i);
		}
		
		for(int i = 10; i < 18; i++){
			GameBoard.addTileObject(Wall, i, 12);
		}
		
		for(int i = 13; i < 16; i++){
			GameBoard.addTileObject(Wall, i, 6);
		}
		
		for(int i = 9; i < 12; i++){
			GameBoard.addTileObject(Wall, 10, i);
		}
		
		for(int i = 21; i < 24; i++){
			GameBoard.addTileObject(Wall, i, 20);
		}
		
		for(int i = 17; i < 21; i++){
			GameBoard.addTileObject(Wall, 24, i);
		}
		//Y = X^2 + 2X + 1;

		GameBoard.addTileObject(Wall, 9, 21);
		GameBoard.addTileObject(Wall, 9, 23);
		GameBoard.addTileObject(Wall, 9, 27);
		GameBoard.addTileObject(Wall, 9, 28);
		GameBoard.addTileObject(Wall, 9, 31);
		GameBoard.addTileObject(Wall, 9, 33);
	
		GameBoard.addTileObject(Wall, 22, 5);
		GameBoard.addTileObject(Wall, 25, 5);
		GameBoard.addTileObject(Wall, 26, 5);
		GameBoard.addTileObject(Wall, 27, 5);
		GameBoard.addTileObject(Wall, 29, 5);
		GameBoard.addTileObject(Wall, 30, 5);
		GameBoard.addTileObject(Wall, 33, 5);
		GameBoard.addTileObject(Wall, 35, 5);
		GameBoard.addTileObject(Wall, 38, 5);
		GameBoard.addTileObject(Wall, 39, 5);
		GameBoard.addTileObject(Wall, 40, 5);


		GameBoard.addTileObject(Floor, 20, 24);
		GameBoard.addTileObject(Floor, 21, 24);

		GameBoard.addTileObject(Floor, 28, 16);
		GameBoard.addTileObject(Floor, 28, 15);

		//gameBoard.addTileObject(SchoolEntity, 15, 44);
		
		GameBoard.addTileObject(school, 18, 14);
		
		GameBoard.addTileObject(school2, 7, 20);
		
		GameBoard.addTileObject(school3, 50, 8);
		GameBoard.addTileObject(school4, 10, 2);
		
		
		GameBoard.addTileObject(takeCoverTile, 13, 7);
		GameBoard.addTileObject(takeCoverTile, 13, 8);
		GameBoard.addTileObject(takeCoverTile, 13, 9);
		GameBoard.addTileObject(takeCoverTile, 12, 9);
		GameBoard.addTileObject(takeCoverTile, 11, 9);
		
		GameBoard.addTileObject(takeCoverTile, 10, 19);
		GameBoard.addTileObject(takeCoverTile, 10, 20);
		
		GameBoard.addTileObject(takeCoverTile, 10, 24);
		GameBoard.addTileObject(takeCoverTile, 10, 25);
		
		GameBoard.addTileObject(takeCoverTile, 10, 29);
		GameBoard.addTileObject(takeCoverTile, 10, 30);
		
		GameBoard.addTileObject(takeCoverTile, 10, 34);
		GameBoard.addTileObject(takeCoverTile, 10, 35);
		
		GameBoard.addTileObject(safeTakeCoverTile, 23, 6);
		GameBoard.addTileObject(safeTakeCoverTile, 24, 6);
		
		GameBoard.addTileObject(takeCoverTile, 31, 6);
		GameBoard.addTileObject(takeCoverTile, 32, 6);
		
		GameBoard.addTileObject(takeCoverTile, 36, 6);
		GameBoard.addTileObject(takeCoverTile, 37, 6);
		
	}
	
	
	
}
