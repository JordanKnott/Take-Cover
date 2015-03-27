package net.items.material;

public enum SpecMaterial {

	ANGELIC(2f,1.5f,"DEMON"),
	DEMONIC(2f,1.5f,"ANGEL");
	
	private final float baseMultiplier;
	private final float specMultiplier;
	private final String creatureType;
	
	SpecMaterial(float baseMultiplier, float specMultiplier, String creatureType)
	{
		this.baseMultiplier = baseMultiplier;
		this.specMultiplier = specMultiplier;
		this.creatureType = creatureType;
	}
	
	public float returnBaseMultiplier()
	{
		return baseMultiplier;
	}
	public float returnSpecMultipier()
	{
		return specMultiplier;
	}
	public String returnCreatureType()
	{
		return creatureType;
	}
	
}
