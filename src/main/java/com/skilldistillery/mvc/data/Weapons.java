package com.skilldistillery.mvc.data;

public enum Weapons {
	KEYBLADE(1), SWORD(2);
	
	private int value;
	
	Weapons(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
