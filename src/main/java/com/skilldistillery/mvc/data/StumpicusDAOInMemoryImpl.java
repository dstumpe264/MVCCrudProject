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
		army.put(id, new Warrior(id++, "Stumpzilla", Rank.CAPTAIN, Weapons.GOLDENGUN, WarriorClass.DEVILDOG));
		army.put(id, new Warrior(id++, "Stumperella", Rank.CAPTAIN, Weapons.KEYBLADE, WarriorClass.WETBOY));
		army.put(id, new Warrior(id++, "Stumpinator", Rank.SERGEANT, Weapons.KEYBLADE, WarriorClass.BRUTE));
		army.put(id, new Warrior(id++, "Stumpalumpagus", Rank.SERGEANT, Weapons.LIGHTSABER, WarriorClass.DEVILDOG));
		army.put(id, new Warrior(id++, "Stumpalicious", Rank.SERGEANT, Weapons.GUNCHUCKS, WarriorClass.DEVILDOG));
		army.put(id, new Warrior(id++, "Stumpify", Rank.SERGEANT, Weapons.GOLDENGUN, WarriorClass.WARLOCK));
		army.put(id, new Warrior(id++, "Sir Stumpalot", Rank.CAPTAIN, Weapons.ALIENBLASTER, WarriorClass.WARLOCK));
		army.put(id, new Warrior(id++, "Stumpinidas", Rank.CAPTAIN, Weapons.GUNCHUCKS, WarriorClass.WETBOY));
		army.put(id, new Warrior(id++, "Killer Stump", Rank.PRIVATE, Weapons.GUNCHUCKS, WarriorClass.WETBOY));

		
	}

	@Override
	public Warrior getWarriorById(int id) {
		return army.get(id);
	}

	@Override
	public Warrior addWarrior(Warrior w) {
		w.setId(id++);
		return army.put(w.getId(), w);
	}

	@Override
	public Warrior deleteWarrior(Warrior w) {
		return army.remove(w.getId());
	}

	@Override
	public Warrior updateWarrior(Warrior w) {
		return army.put(w.getId(), w);
	}

	@Override
	public List<Warrior> getAllWarriors() {
		return new ArrayList<Warrior>(army.values());
	}

}
