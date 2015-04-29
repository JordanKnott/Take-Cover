package net.engine.musicHandlers;

import net.engine.Engine;

public class TitleMusic extends Thread{

	
	
    public void run() {
        
  
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		
		//Sound sound = new Sound();
		//sound.playTitleMusic();
		
		for(int i = 0; i < 11; i++){
			//sound.setTitleVolume(i * .1);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) { 
				///System.out.println("Interrupt!"); sound.stopMusic(); }
		}
		
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) { System.out.println("Interrupt!"); 
		//sound.stopMusic(); 
		}
		}
		
    

    }
}
