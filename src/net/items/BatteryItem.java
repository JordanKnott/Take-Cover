package net.items;

public class BatteryItem extends Item{
	public String returnItemType(){
		
		return "battery";
		
	}
	public boolean isNeededItem(){
		return true;
	}
}
