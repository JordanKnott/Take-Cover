package net.levels;

import net.engine.Engine;
import net.engine.GameBoard;
import net.engine.ScriptThread;

import net.tiles.CarWindowTile;
import net.tiles.ConcreteTile;
import net.tiles.DeepestDitchTile;
import net.tiles.DoorColor;
import net.tiles.GrassTile;
import net.tiles.GrassTile1;
import net.tiles.HeadLightTile;
import net.tiles.HoodTile;
import net.tiles.LightBeamTile;
import net.tiles.LightBlueCarTile;
import net.tiles.LightestDitchTile;
import net.tiles.RoofBlueTile;
import net.tiles.SecondDeepestDitchTile;
import net.tiles.SecondLightTile;
import net.tiles.TailLightTile;
import net.tiles.Tile;
import net.tiles.TireTile;
import net.tiles.YellowLinesTile;
import net.tiles.specTiles.TakeCoverTile;

public class ScenarioRoad2Level extends Level{

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
	Tile Door = new DoorColor();
	Tile takeCoverTile = new TakeCoverTile(false,3);
	Tile safeTakeCoverTile = new TakeCoverTile(true,3);

	
	
	public void populateGameBoard(GameBoard gameBoard){
	
		Engine.mainPlayer().setPlayerCords(10, 10);;
		
		Engine.mainPlayer().setCurrentLevelID(4);

		
		
		for(int iter = 0; iter < 75; iter++){
			for(int i = 0; i < 45; i++){
				GameBoard.addTileObject(Grass, iter, i);
			}
		}
		
		
		
		for(int iter = 25; iter < 30; iter++){
			for(int iter2 = 12; iter2 < 16; iter2++ ){
				GameBoard.addTileObject(Concrete, iter, iter2);
			}
		}
		
		
		for(int iter = 24; iter < 31; iter++){
			GameBoard.addTileObject(Tire, iter, 11);
		}
		

		for(int iter = 24; iter < 31; iter++){
			GameBoard.addTileObject(Tire, iter, 16);
		}
		
		for(int iter = 12; iter < 16; iter++){
			GameBoard.addTileObject(Tire, 24, iter);
		}
		
		
		for(int iter = 12; iter < 16; iter++){
			GameBoard.addTileObject(Tire, 30, iter);
		}
		
		GameBoard.addTileObject(Door, 30, 14);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		for(int iter = 25; iter < 30; iter++){
			for(int iter2 = 12; iter2 < 16; iter2++ ){
				GameBoard.addTileObject(takeCoverTile, iter, iter2);
			}
		}

	}
	
}
