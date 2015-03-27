package net.engine;

import javafx.application.Platform;
import net.tiles.Tile;

public class CountdownThread extends Thread{
	
	private int ScenarioID;
	private int time = 30;
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
		time--;
		if(Engine.mainPlayer().returnCurrentLevelID() == ScenarioID && Engine.inGame){
			Platform.runLater(new Runnable() {
				public void run() {
					
     	    			Engine.itemLabel.setText("Countdown Timer: " + time);
				}
     	    	});
		
		}
	}
	
	public void run(){
		
			for(int i = 0; i < 30; i++){
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