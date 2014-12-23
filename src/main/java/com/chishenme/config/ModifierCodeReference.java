package com.chishenme.config;

public enum ModifierCodeReference
{
	SYSTEM (0),
	SELF (1),
	CUSTOMER_SERVICE (2);
	
	private int modifierCode;
	
	ModifierCodeReference(int modifierCode)
	{
		this.modifierCode = modifierCode;
	}
	
	public int getModifierCode()
	{
		return this.modifierCode;
	}
}
