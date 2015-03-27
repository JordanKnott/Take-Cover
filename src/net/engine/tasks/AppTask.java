package net.engine.tasks;

import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import net.Start;
import net.engine.Engine;
import net.engine.introUI.GameIntroUI;

public class AppTask extends TimerTask {

	public static int sceneStartWidth;
	public static int sceneStartHeight;
	
	
	
        @Override
        public void run() {
           
        	 Platform.runLater(new Runnable() {
        	       public void run() {

        	    	   Engine.setCurrentMenu(2);
	    	    		GameIntroUI.runUI();
	    	    		Engine.optionsLocked = false;
        	      }
        	    });
        
    }



}