package com.skilldistillery.mvc.data;

public enum WarriorClass {
	BRUTE(1), WARLOCK(2);
	
	private int value;
	WarriorClass(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
}
