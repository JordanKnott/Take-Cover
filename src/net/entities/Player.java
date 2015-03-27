package net.entities;

import net.items.Item;
import net.items.Nothing;
public class Player {
	
	 Item helmet = new Nothing();
	 Item neck = new Nothing();
	 Item cape = new Nothing();
	 Item chest = new Nothing();
	 Item belt = new Nothing();
	 Item gloves = new Nothing();
	 Item leggings = new Nothing();
	 Item boots = new Nothing();
	 Item mainHand= new Nothing();
	 Item offHand = new Nothing();
	 
	 Item slot1 = new Nothing();
	 Item slot2 = new Nothing();
	 Item slot3 = new Nothing();
	 Item slot4 = new Nothing();
	 Item slot5 = new Nothing();
	 Item slot6 = new Nothing();
	 Item slot7 = new Nothing();
	 Item slot8 = new Nothing();
	 Item slot9 = new Nothing();
	 Item slot10 = new Nothing();
	 Item slot11 = new Nothing();
	 
	 private int curLevelID = 0;
	 private int playerX;
	 private int playerY;
	
	 
	 
	 
	Item equipment[] = {
			helmet,
			neck,
			cape,
			chest,
			belt,
			gloves,
			leggings,
			boots,
			mainHand,
			offHand
	};
	
	

	
	int playerMaxHealth= 100;
	int playerCurHealth=100;
	
	boolean zone1state;
	boolean zone2state;
	boolean zone3state;
	
	int curItemWinCount = 0;
	int curInvSpace = 0;
	int maxInvSpace = 0;
	public int getInvSpace(){
		return curInvSpace;
	}
	public int getMaxSpace(){
		return maxInvSpace;
	}
	
	public void setInvSpace(int space){
		curInvSpace = space;
		maxInvSpace = space;
	}
	
	public void increaseWinCount(){
		curItemWinCount++;
	}

	public void decreaseCurInventorySpace(){
		curInvSpace--;
	}
	
	public void resetPlayer(){
		curItemWinCount = 0;
		curInvSpace = 0;
	}
	
	public boolean hasWon(){
		if(curInvSpace <= 0){
			
			
			return true;
		}
		return false;
		
	}
	
	public Item getHelmetItemObect(){
		return helmet;
	};
	
	
	public void setPlayerCords(int playerX, int playerY){
		this.playerX = playerX;
		this.playerY = playerY;
	}
	
	public int returnPlayerX(){
		return playerX;
	}
	
	public int returnPlayerY(){
		return playerY;
	}
	
	public int returnPlayerMaxHealth(){
		return playerMaxHealth;
	}
	
	public int returnPlayerCurHealth(){
		return playerCurHealth;
	}
	
	public int returnCurrentLevelID(){
		return curLevelID;
	}
	
	public void setCurrentLevelID(int curLevelID){
		this.curLevelID = curLevelID;
	}
	// Score is how many items you got correct times by how many zones you won // 1 for none, 2 for one win, etc.
	public int getScore(){
		return curItemWinCount * getZoneStates();
	}
	
	public int getZoneStates(){
		int total = 1;
		if(zone1state == true){
			total++;
		}else if(zone2state == true){
			total++;
		}else if(zone3state == true){
			total++;
		}
		return total;
	}
	
	public void setZoneStatus(int zoneIndex, boolean zoneState){
		if(zoneIndex == 1){
			zone1state = zoneState;
		}else if(zoneIndex == 2){
			zone2state = zoneState;
		}else if(zoneIndex == 3){
			zone3state = zoneState;
		}
	}
	
}
