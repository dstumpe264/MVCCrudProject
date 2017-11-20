package com.skilldistillery.mvc.data;

public enum Weapons {
	KEYBLADE(1), GUNCHUCKS(2), BATTLEAXE(3), GALAXYNOTE7(4), LASERKATANA(5);
	
	private int value;
	
	Weapons(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
