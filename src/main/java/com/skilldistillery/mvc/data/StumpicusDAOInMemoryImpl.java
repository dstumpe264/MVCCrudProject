package com.skilldistillery.mvc.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class StumpicusDAOInMemoryImpl implements StumpicusDAO {
	Map<Integer, Warrior> army;
	private int id = 1;
	
	public StumpicusDAOInMemoryImpl() {
		army = new HashMap<>();
		loadStarterArmy();
	}
	
	private void loadStarterArmy() {
		army.put(id, new Warrior(id++, "Stumpzilla", 1, Weapons.SWORD, WarriorClass.BRUTE));
		army.put(id, new Warrior(id++, "Stumperella", 1, Weapons.SWORD, WarriorClass.BRUTE));
		army.put(id, new Warrior(id++, "Stumpinator", 1, Weapons.SWORD, WarriorClass.BRUTE));
		army.put(id, new Warrior(id++, "Stumpalumpagus", 1, Weapons.SWORD, WarriorClass.BRUTE));
		army.put(id, new Warrior(id++, "Stumpify", 1, Weapons.SWORD, WarriorClass.BRUTE));
		army.put(id, new Warrior(id++, "Killer Stump", 1, Weapons.SWORD, WarriorClass.BRUTE));

		
	}

	@Override
	public Warrior getWarriorById(int id) {
		Warrior w = null;
		return w;
	}

	@Override
	public Warrior addWarrior(Warrior w) {
		w.setId(id++);
		return army.put(w.getId(), w);
	}

	@Override
	public Warrior deleteWarrior(Warrior w) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Warrior updateWarrior(Warrior w) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Warrior> getAllWarriors() {
		return new ArrayList<Warrior>(army.values());
	}

}
