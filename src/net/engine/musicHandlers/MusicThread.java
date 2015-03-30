package net.engine.musicHandlers;

import net.Start;
import net.engine.Engine;

public class MusicThread extends Thread {

	/*
	private boolean firstRun = true;
	
	
    public void run() {
    Start.stopTitleMusic();
    if(firstRun == true){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			System.out.println("Music thread: Stopped");
			Engine.threadRunning = false;
		}
		
		Sound sound = new Sound();
		sound.playBackground1();
		
		for(int i = 0; i < 11; i++){
			sound.setVolume(i * .1);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) { }
		}
		
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) { }
		
    }

    		
    	
    	
    	
    	while(Engine.threadRunning == true){
    		
    		if(Engine.musicState == true){
    			Sound sound = new Sound();
    			sound.playBackground1();
    			
    			for(int i = 0; i < 11; i++){
    				sound.setVolume(i * .1);
    				try {
    					Thread.sleep(350);
    				} catch (InterruptedException e) { sound.stopMusic(); }
    			}
    			
    			try {
    				Thread.sleep(100000);
    			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
    				System.out.println("Music thread: Stopped");
    				sound.stopMusic();
    			}
    			
    		}


    		
    		
    	}
    	
    	
    	
    	
    }
	
	*/
}
