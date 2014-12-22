package com.chishenme.config;

public enum ModifierCode
{
	SYSTEM (0),
	SELF (1),
	CUSTOMER_SERVICE (2);
	
	private int modifierCode;
	
	ModifierCode(int modifierCode)
	{
		this.modifierCode = modifierCode;
	}
	
	public int getModifierCode()
	{
		return this.modifierCode;
	}
}
