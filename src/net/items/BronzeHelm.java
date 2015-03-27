package net.items;

import net.items.enchantments.Enchantment;
import net.items.material.Material;

public class BronzeHelm extends Item{

	//base stats
	private int strength = 5;
	private int endurance = 5;
	private int stamina = 5;
	
	private float quality;
	
	
	public BronzeHelm(float quality){
		this.quality = quality;
			
	}
	
	public BronzeHelm(float quality, Enchantment enchantment)
	{
		this.quality = quality;
		strength = enchantment.returnAdjustedStrength(strength);
		endurance = enchantment.returnAdjustedStrength(endurance);
		stamina = enchantment.returnAdjustedStrength(stamina);
	}
	
	public int returnStrength()
	{
		return strength;
	}
	
	public int returnEndurance()
	{
		return endurance;
	}
	
	public int returnStamina()
	{
		return stamina;
	}
	
	
	
}
