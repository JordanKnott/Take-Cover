package net.thenightwolf.console;

import javax.swing.SwingUtilities;

import javafx.application.Platform;
import net.Start;
import net.engine.Debug;
import net.engine.Engine;
import net.engine.introUI.ScenarioSelect;

public class TakeCoverShell implements InputHandler{

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handle(String text) {
		// TODO Auto-generated method stub
		if(text.equals("exit") || text.equals("Exit"))
		{
			Platform.runLater(new Runnable(){

				@Override
				public void run() {
					Debug.terminal.close();

				}

			});

		}
		
		else if(text.equals("terminate") || text.equals("close"))
		{
			com.sun.javafx.application.PlatformImpl.tkExit();
			Platform.exit();
		}
		
		else if(text.startsWith("player"))
		{
			String[] playerArgs = text.split(" ");
			if(playerArgs[1].equals("items"))
			{
				try
				{
					int bufferInt = Integer.parseInt(playerArgs[2]);
					
					Engine.score.setItems(bufferInt);
				}
				catch(NumberFormatException e)
				{

				}


			}
			else if(playerArgs[1].equals("menu"))
			{
				try
				{
					int bufferInt = Integer.parseInt(playerArgs[2]);
					if(bufferInt == 2)
					{
						Platform.runLater(new Runnable(){

	
							public void run() {

								ScenarioSelect.runUI();
							}

						}); 

					}
				}
				catch(NumberFormatException e)
				{
					
				}
				
				
			}	
			
			
		}
		else if(text.startsWith("help")) {
			
			Debug.console.clearScreen();
			
			
			Debug.console.print("TakeCover v" + Start.version + " Engine Shell Help");
			Debug.console.print("--------------------------------------------------");
			Debug.console.print("help : displays this help message");
			Debug.console.print("");
			Debug.console.print("player : access to player variables");
			Debug.console.print("player items : sets the player's item correcct count.");
			Debug.console.print("player items [itemcount] e.g \"player items 7\"");
			Debug.console.print("");
			Debug.console.print("player menu : sets the player's current menu");
			Debug.console.print("player menu [menuID] e.g \"player items 2\"");
			Debug.console.print("");
			Debug.console.print("menu : displays menu's and their ID's");
			Debug.console.print("");
			Debug.console.print("clear : clears the terminal screen");
		}
		else if(text.startsWith("menu")) {
			Debug.console.print("TakeCover Menus");
			Debug.console.print("---------------");
			Debug.console.print("House1 - 1");
			Debug.console.print("ScenarioSelect - 2");
			Debug.console.print("House2 - 3");
			Debug.console.print("Road - 4");
			Debug.console.print("School - 5");
			

		}	
		else if(text.startsWith("clear")) {
			Debug.console.clearScreen();
			Debug.console.print("TakeCover [Version " + Start.version + "] Engine Shell");
			Debug.console.print("Created by NightWolf.");
			Debug.console.print("");
		}
		
	}

}
