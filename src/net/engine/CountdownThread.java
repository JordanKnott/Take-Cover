package net.engine;

import javafx.application.Platform;
import net.tiles.Tile;

public class CountdownThread extends Thread{
	
	private int ScenarioID;
	
	public CountdownThread(int ScenarioID){
		this.ScenarioID = ScenarioID;
	}
	 
	public void pulse(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Engine.mainPlayer().returnCurrentLevelID() == ScenarioID && Engine.inGame){
			Engine.time--;
			Platform.runLater(new Runnable() {
				public void run() {
					
     	    			Engine.itemLabel.setText("Countdown Timer: " + Engine.time);
				}
     	    	});
		
		}
	}
	
	public void run(){
		Engine.time = 75;
			for(int i = 0; i < 75 ; i++){
				pulse();
			}
			System.out.println("Countdown Thread: Started");
			System.out.println( Engine.inGame + " : " +Engine.mainPlayer().returnCurrentLevelID());
			if(Engine.mainPlayer().returnCurrentLevelID() == ScenarioID && Engine.inGame){
				
		      	 Platform.runLater(new Runnable() {
		       	       public void run() {

		       	    	Engine.runTimeout(ScenarioID);
		       	      }
		       	    });
		      
				System.out.println("Countdown Thread: Timeout");
			}
	      	 
		
		
		
	}
	
	
}