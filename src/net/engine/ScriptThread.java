package net.engine;

import javafx.application.Platform;
import net.entities.SchoolEntity;
import net.tiles.Tile;

public class ScriptThread extends Thread{
	
	Tile iHandle;
	
	public ScriptThread(Tile school){
		iHandle = school;
	}
	
	public void run(){
		
		
		while(iHandle.getActive()){
			try {
				Thread.sleep(Engine.updateRate);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	      	 Platform.runLater(new Runnable() {
	       	       public void run() {

	       	    	iHandle.update();
	       	      }
	       	    });
		
		}
		
	}
	
	
}
