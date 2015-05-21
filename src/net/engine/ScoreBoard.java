package net.engine;

public class ScoreBoard {

	
	private int currentPlayerScore;
	
	private int scenariosDone;
	private int correctItems;
	private int schoolMatesSaved;
	
	public ScoreBoard(){
	
		
		
	}
	
	public int returnScenDone(){
		return scenariosDone;
	}
	
	public int returnItems(){
		return correctItems;
	}
	
	public int returnSchool(){
		return schoolMatesSaved;
	}
	
	public int returnScore(){
		int firstSum = scenariosDone * 5;
		if(schoolMatesSaved == 3 || schoolMatesSaved == 4){
			currentPlayerScore = firstSum + 5;
		}
		return currentPlayerScore + 5 + correctItems;
	}
	
	public void increaseSchool(){
		schoolMatesSaved++;
	}
	
	public void increaseScenario(){
		scenariosDone++;
	}
	
	public void increaseItems(){
		correctItems++;
	}
	public void setItems(int item){
		correctItems = item;
	}
	
	public void resetScore(){
		currentPlayerScore = 0;
		scenariosDone = 0;
		correctItems = 0;
	}
	
}
