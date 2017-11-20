package com.skilldistillery.mvc.data;

public enum WarriorClass {
	BRUTE(1), BASHER(2), RANGER(3), MAGICMAN(4), SHAPESHIFTER(5);
	
	private int value;
	WarriorClass(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
}
