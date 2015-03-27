package net.baseTables;

public class AttackPowerTable {

	//returns base damage depending on how many units of attack power there are.
	private int attackPower;
	private int baseDamage;


	public int returnBaseDamage(int attackPower)
	{
		if(attackPower >= 1 && attackPower <= 250 ){
			baseDamage = attackPower * 20;
		}else if(attackPower >= 251 && attackPower <= 500){
			baseDamage = attackPower * 40;
		}else if(attackPower >= 501 && attackPower <= 750){
			baseDamage = attackPower * 60;
		}else if(attackPower >= 751 && attackPower <= 1500){
			baseDamage = attackPower * 80;
		}else if(attackPower >= 1501){
			baseDamage = attackPower * 100;
		}else{
			baseDamage = 0;
		}
		return baseDamage;
	}
	
}
