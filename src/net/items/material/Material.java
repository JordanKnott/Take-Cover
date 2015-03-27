package net.items.material;

public enum Material {

	//materials and their base Multiplier
	COPPER (0.5f),
	BRONZE (0.7f),
	IRON (1.0f),
	STEEL (1.3f), 
	SILVER(1.5f);
	
    private final float baseMultiplier; 

    Material(float baseMultiplier) {
        this.baseMultiplier = baseMultiplier;
    }
    

    float returnBaseMultiplier(){
    	return baseMultiplier;
    }
    
}
