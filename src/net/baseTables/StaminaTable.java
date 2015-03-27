package net.baseTables;

public class StaminaTable {

	//returns base damage depending on how many units of attack power there are.
	private int stamina;
	private int baseHealth;


	public int returnBaseDamage(int stamina)
	{
		if(stamina >= 1 && stamina <= 200 ){
			baseHealth = stamina * 50;
		}else if(stamina >= 201 && stamina <= 400){
			baseHealth = stamina * 100;
		}else if(stamina >= 401 && stamina <= 600){
			baseHealth = stamina * 200;
		}else if(stamina >= 601 && stamina <= 800){
			baseHealth = stamina * 300;
		}else if(stamina >= 801){
			baseHealth = stamina * 400;
		}else{
			baseHealth = 0;
		}
		return stamina;
	}
	
}
