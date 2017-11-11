package com.skilldistillery.mvc.data;

import java.util.List;

public interface StumpicusDAO {
	Warrior getWarriorById(int id);
	Warrior addWarrior(Warrior w);
	Warrior deleteWarrior(Warrior w);
	Warrior updateWarrior(Warrior w);
	List<Warrior> getAllWarriors();
	
}
