package net.thenightwolf.console;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javafx.scene.input.KeyCode;

public class ConsoleKeyListener implements KeyListener {

	String currentLine = "";
	
	private JConsole jc;
	
	
	public ConsoleKeyListener(JConsole jc)
	{
		this.jc = jc;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		int kc = e.getKeyCode();
		if(kc == 27) jc.exit();
		
	
			int id = e.getID();

			if (id == KeyEvent.KEY_TYPED) {
				char c = e.getKeyChar();
				jc.write(c);
				System.out.println("Key Typed");
			} else {
				int keyCode = e.getKeyCode();
				char key = e.getKeyChar();

				switch(keyCode){

				case 8:
					if(jc.getCursorX() - 1 > jc.promptLength){
						jc.setCursorPos(jc.getCursorX() - 1, jc.getCursorY());
						jc.write(" ",Color.GREEN,Color.BLACK);
						jc.setCursorPos(jc.getCursorX() - 1, jc.getCursorY());
						currentLine = currentLine.substring(0, currentLine.length() - 1);
					}
					break;
					//Shift
				case 16:
					break;

					//Escape
				case 27:
					
					break;

					//Tab
				case 9:
					break;

					//Ctrl
				case 17:
					break;

					//Alt
				case 18:
					break;

					//Caps Lock
				case 20:
					break;

					//Enter
				case 10:
					System.out.println(currentLine);
					jc.setCursorPos(0, jc.getCursorY() + 1);
					handleText(currentLine);
					currentLine = "";
					jc.prompt(">");
					break;

				default:
					if(e.isShiftDown()){
						jc.write(String.valueOf(key).toUpperCase(),Color.GREEN,Color.BLACK);
						currentLine = currentLine + String.valueOf(key).toUpperCase();
					}else {
						jc.write(String.valueOf(key).toLowerCase(),Color.GREEN,Color.BLACK);	
						currentLine = currentLine + String.valueOf(key).toLowerCase();
					}


					break;
				}


			}	
			jc.repaint();    
		
	}

	@Override
	public void keyReleased(KeyEvent e) {



	}

	@Override
	public void keyTyped(KeyEvent event) {
		
		

		
	}

	
	public void handleText(String text)
	{
		if(jc.inputerHandler != null){
			jc.inputerHandler.handle(text);
		}
	
	}
}
