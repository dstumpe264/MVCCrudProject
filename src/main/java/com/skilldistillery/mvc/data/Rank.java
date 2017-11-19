package com.skilldistillery.mvc.data;

public enum Rank {
	PRIVATE(3), SERGEANT(2), CAPTAIN(1);
	
	private int value;
	Rank(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
}
