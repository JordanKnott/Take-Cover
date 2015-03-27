package net.levels;

import java.util.Random;

import net.engine.CountdownThread;
import net.engine.Engine;
import net.engine.GameBoard;
import net.engine.ScriptThread;

import net.items.BatteryItem;
import net.items.Item;
import net.tiles.CarWindowTile;
import net.tiles.ConcreteTile;
import net.tiles.DeepestDitchTile;
import net.tiles.DoorColor;
import net.tiles.GrassTile;
import net.tiles.GrassTile1;
import net.tiles.GrassTile2;
import net.tiles.HeadLightTile;
import net.tiles.HoodTile;
import net.tiles.LightBeamTile;
import net.tiles.LightBlueCarTile;
import net.tiles.LightestDitchTile;
import net.tiles.RoofBlueTile;
import net.tiles.SecondDeepestDitchTile;
import net.tiles.SecondLightTile;
import net.tiles.TailLightTile;
import net.tiles.TestTile;
import net.tiles.Tile;
import net.tiles.TireTile;
import net.tiles.YellowLinesTile;
import net.tiles.specTiles.TakeCoverTile;






public class ScenarioRoadLevel extends Level {

	Tile Grass = new GrassTile();
	Tile Tire = new TireTile();
	Tile Window = new CarWindowTile();
	Tile Concrete = new ConcreteTile();
	Tile DeepestDitch = new DeepestDitchTile();
	Tile Headlight = new HeadLightTile();
	Tile Hood = new HoodTile();
	Tile LightBeam = new LightBeamTile();
	Tile LightBlue = new LightBlueCarTile();
	Tile LightestDitch = new LightestDitchTile();
	Tile Roof = new RoofBlueTile();
	Tile SecondDeepestDitch = new SecondDeepestDitchTile();
	Tile SecondLightestDitch = new SecondLightTile();
	Tile TailLight = new TailLightTile();
	Tile YellowLines = new YellowLinesTile();
	
	Tile takeCoverTile = new TakeCoverTile(false,3);
	Tile safeTakeCoverTile = new TakeCoverTile(true,3);
	Tile Door = new DoorColor();

	Tile GrassShade1 = new GrassTile1();
	Tile GrassShade2 = new GrassTile2();
	Tile TestTile = new TestTile();
	
	Item battery = new BatteryItem();
	int chance;
	String[] winCondition = null;


	Random gen = new Random();

	public void populateGameBoard(GameBoard gameBoard){
		CountdownThread cThread = new CountdownThread(3);
		cThread.start();
		Engine.inGame = true;
		Engine.mainPlayer().setPlayerCords(10, 10);;
		Engine.setPlayerStorageSpace(8);
		Engine.mainPlayer().setCurrentLevelID(3);


		
		for(int iter = 0; iter < 75; iter++){
			for(int i = 0; i < 45; i++){
				GameBoard.addTileObject(Grass, iter, i);
			}
		}
		

		

		
		for(int iter = 25; iter < 50; iter++){
			for(int i = 0; i < 45; i++) {
				GameBoard.addTileObject(Concrete, iter, i);
			}
		}
		
		

		
		

		
		
		for(int iter = 52; iter < 54; iter++){
			for(int i = 0; i < 45; i++) {
				GameBoard.addTileObject(LightestDitch, iter, i);
			}
		}
		
		
		
		for(int iter = 64; iter < 66; iter++){
			for(int i = 0; i < 45; i++) {
				GameBoard.addTileObject(LightestDitch, iter, i);
			}
		}
		

		

		
		
		for(int iter = 54; iter < 56; iter++){
			for(int i = 0; i < 45; i++) {
				GameBoard.addTileObject(SecondLightestDitch, iter, i);
			}
		}
	
		
		for(int iter = 62; iter < 64; iter++){
			for(int i = 0; i < 45; i++) {
				GameBoard.addTileObject(SecondLightestDitch, iter, i);
			}
		}
		
		

		
		for(int iter = 56; iter < 57; iter++){
			for(int i = 0; i < 45; i++) {
				GameBoard.addTileObject(SecondDeepestDitch, iter, i);
			}
		}
		
		
		for(int iter = 61; iter < 62; iter++){
			for(int i = 0; i < 45; i++) {
				GameBoard.addTileObject(SecondDeepestDitch, iter, i);
			}
		}
		

		
		for(int iter = 57; iter < 61; iter++){
			for(int i = 0; i < 45; i++) {
				GameBoard.addTileObject(safeTakeCoverTile, iter, i);
			}
		}
		
		
		for(int iter = 37; iter < 39; iter++){
			for(int i = 0; i < 3 ; i++) {
				GameBoard.addTileObject(YellowLines, iter, i);
			}
		}
		
		
		for(int iter = 37; iter < 39; iter++){
			for(int i = 6; i < 9 ; i++) {
				GameBoard.addTileObject(YellowLines, iter, i);
			}
		}
		
		
		for(int iter = 37; iter < 39; iter++){
			for(int i = 12; i < 15 ; i++) {
				GameBoard.addTileObject(YellowLines, iter, i);
			}
		}
	
		
		for(int iter = 37; iter < 39; iter++){
			for(int i = 18; i < 21 ; i++) {
				GameBoard.addTileObject(YellowLines, iter, i);
			}
		}
		
		
		for(int iter = 37; iter < 39; iter++){
			for(int i = 24; i < 27 ; i++) {
				GameBoard.addTileObject(YellowLines, iter, i);
			}
		}
		
		
		for(int iter = 37; iter < 39; iter++){
			for(int i = 30; i < 33 ; i++) {
				GameBoard.addTileObject(YellowLines, iter, i);
			}
		}
		
		
		for(int iter = 37; iter < 39; iter++){
			for(int i = 36; i < 39 ; i++) {
				GameBoard.addTileObject(YellowLines, iter, i);
			}
		}
		
		
		for(int iter = 37; iter < 39; iter++){
			for(int i = 42; i < 45 ; i++) {
				GameBoard.addTileObject(YellowLines, iter, i);
			}
		}
		
		
		for(int iter = 14 ; iter < 17; iter++){		
				GameBoard.addTileObject(Tire, 39, iter);
		}
		
			
		for(int iter = 22 ; iter < 25; iter++){		
			GameBoard.addTileObject(Tire, 39, iter);
	}
		
		
		for(int iter = 14 ; iter < 17; iter++){		
			GameBoard.addTileObject(Tire, 48, iter);
	}	
		
		
		for(int iter = 22 ; iter < 25; iter++){		
			GameBoard.addTileObject(Tire, 48, iter);
	}	
		
		
		for(int iter = 16 ; iter < 18; iter++){		
			GameBoard.addTileObject(LightBlue, 40, iter);
	}	
		
		
		for(int iter = 21 ; iter < 23; iter++){		
			GameBoard.addTileObject(LightBlue, 40, iter);
	}	
		
		
		for(int iter = 16 ; iter < 18; iter++){		
			GameBoard.addTileObject(LightBlue, 47, iter);
	}	
		
		
		for(int iter = 21 ; iter < 23; iter++){		
			GameBoard.addTileObject(LightBlue, 47, iter);
	}	
		
		
		for(int iter = 40; iter < 48; iter++){
			for(int i = 18; i < 21 ; i++) {
				GameBoard.addTileObject(Roof, iter, i);
			}
		}
		
		
		for(int iter = 40; iter < 48; iter++){
			for(int i = 13; i < 16 ; i++) {
				GameBoard.addTileObject(Hood, iter, i);
			}
		}
		
		
		for(int iter = 40; iter < 48; iter++){
			for(int i = 23; i < 26 ; i++) {
				GameBoard.addTileObject(Hood, iter, i);
			}
		}
		
		
	
		for(int iter = 41; iter < 47; iter++){
			for(int i = 16; i < 18 ; i++) {
				GameBoard.addTileObject(Window, iter, i);
			}
		}
		
		
		for(int iter = 41; iter < 47; iter++){
			for(int i = 21; i < 23 ; i++) {
				GameBoard.addTileObject(Window, iter, i);
			}
		}
		
		
		for(int iter = 41 ; iter < 43; iter++){		
			GameBoard.addTileObject(Headlight, iter, 13);
	}
		
		
		for(int iter = 45 ; iter < 47; iter++){		
			GameBoard.addTileObject(Headlight, iter, 13);
	}
		
		
		for(int iter = 41 ; iter < 43; iter++){		
			GameBoard.addTileObject(TailLight, iter, 25);
	}
		
		
		for(int iter = 45 ; iter < 47; iter++){		
			GameBoard.addTileObject(TailLight, iter, 25);
	}	
		
		
		for(int iter = 39; iter < 49; iter++){
			for(int i = 7; i < 11 ; i++) {
				GameBoard.addTileObject(LightBeam, iter, i);
			}
		}
		
		
		for(int iter = 40 ; iter < 42; iter++){		
			GameBoard.addTileObject(LightBeam, iter, 5);
	}
		
		
		for(int iter = 46 ; iter < 48; iter++){		
			GameBoard.addTileObject(LightBeam, iter, 5);
	}
		
		
		for(int iter = 39 ; iter < 43; iter++){		
			GameBoard.addTileObject(LightBeam, iter, 6);
	}
		
		
		for(int iter = 45 ; iter < 49; iter++){		
			GameBoard.addTileObject(LightBeam, iter, 6);
	}	
		
		
		
		for(int iter = 40 ; iter < 48; iter++){		
			GameBoard.addTileObject(LightBeam, iter,11);
	}	
		
		
		for(int iter = 41 ; iter < 43; iter++){		
			GameBoard.addTileObject(LightBeam, iter,12);
	}	
		
		
		for(int iter = 45 ; iter < 47; iter++){		
			GameBoard.addTileObject(LightBeam, iter,12);
	}
		
		
		for(int iter = 8 ; iter < 10; iter++){		
			GameBoard.addTileObject(LightBeam, 38,iter);
	}
		
		
		for(int iter = 8 ; iter < 10; iter++){		
			GameBoard.addTileObject(LightBeam, 49,iter);
	}
		
		


		
		


		
		
		
		
		for(int iter = 6; iter < 11; iter++){
			for(int iter2 = 12; iter2 < 16; iter2++ ){
				GameBoard.addTileObject(Concrete, iter, iter2);
			}
		}
		
		
		for(int iter = 5; iter < 12; iter++){
			GameBoard.addTileObject(Tire, iter, 11);
		}
		

		for(int iter = 5; iter < 12; iter++){
			GameBoard.addTileObject(Tire, iter, 16);
		}
		
		for(int iter = 12; iter < 16; iter++){
			GameBoard.addTileObject(Tire, 5, iter);
		}
		
		
		for(int iter = 12; iter < 16; iter++){
			GameBoard.addTileObject(Tire, 11, iter);
		}
		
		GameBoard.addTileObject(Door, 11, 14);
		
		
		for(int iter = 6; iter < 11; iter++){
			for(int iter2 = 12; iter2 < 16; iter2++ ){
				GameBoard.addTileObject(takeCoverTile, iter, iter2);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
