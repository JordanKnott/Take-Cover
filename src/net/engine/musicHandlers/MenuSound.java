package net.engine.musicHandlers;

import java.io.File;
import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MenuSound {

	
	/*String soundFilename =  getClass().getResource("/net/assets/menu/BlackBackground.png").toString();
	
	Media hit = new Media(new File(soundFilename ).toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(hit);
	public void playSound(){
		mediaPlayer.play();
	}
	
	*/
	  
	final URL resource = getClass().getResource("MenuSound.mp3");
	final Media media = new Media(resource.toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	final URL resource1 = getClass().getResource("MenuSound2.mp3");
	final Media media1 = new Media(resource1.toString());
	final MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
	
	public void playBackground1(){
		//mediaPlayer.play();
		//
	}
	
	public void playBackground2(){
		//mediaPlayer1.play();
	}
	
	public void stopMusic(){
		mediaPlayer.stop();
		mediaPlayer1.stop();
	}
}