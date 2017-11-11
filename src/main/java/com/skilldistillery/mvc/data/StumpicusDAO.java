package com.skilldistillery.mvc.data;

import java.util.List;

public interface StumpicusDAO {
	Warrior getWarriorById();
	Warrior addWarrior();
	Warrior deleteWarrior();
	Warrior updateWarrior();
	List<Warrior> getAllWarriors();
	
}
