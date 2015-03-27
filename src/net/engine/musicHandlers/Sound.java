package net.engine.musicHandlers;

import java.io.File;
import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {

	
	/*String soundFilename =  getClass().getResource("/net/assets/menu/BlackBackground.png").toString();
	
	Media hit = new Media(new File(soundFilename ).toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(hit);
	public void playSound(){
		mediaPlayer.play();
	}
	
	*/
	
	final URL resource = getClass().getResource("song.mp3");
	final Media media = new Media(resource.toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	final URL resource2 = getClass().getResource("Namamanee.mp3");
	final Media media2 = new Media(resource2.toString());
	final MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
	
	
	public void setup(){
		mediaPlayer.setVolume(0);
		
	}
	
	public void setVolume(double x){
		mediaPlayer.setVolume(x);
	}
	public void setTitleVolume(double x){
		mediaPlayer2.setVolume(x);
		
	}
	
	public void playBackground1(){
		mediaPlayer.play();
		
	}
	
	public void playTitleMusic(){
		mediaPlayer2.play();
	}
	
	
	
	public void stopMusic(){
		mediaPlayer.stop();
		mediaPlayer2.stop();
	}
}
