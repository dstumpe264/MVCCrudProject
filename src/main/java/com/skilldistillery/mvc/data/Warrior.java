package com.skilldistillery.mvc.data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Warrior {

	private int id;

	@Size(min = 2, max = 25, message = "Pick a number 2 and 25 characters.")
	private String name;

	@NotNull(message="You must select a rank.")
	private Rank rank;
	@NotNull(message="You must select a weapon.")
	private Weapons weapon;
	@NotNull(message="You must select a class.")
	private WarriorClass wClass;

	public Warrior() {
	}

	public Warrior(int id, String name, Rank rank, Weapons weapon, WarriorClass wClass) {
		super();
		this.id = id;
		this.name = name;
		this.rank = rank;
		this.weapon = weapon;
		this.wClass = wClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Weapons getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}

	public WarriorClass getwClass() {
		return wClass;
	}

	public void setwClass(WarriorClass wClass) {
		this.wClass = wClass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Warrior [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", rank=");
		builder.append(rank);
		builder.append(", weapon=");
		builder.append(weapon);
		builder.append(", wClass=");
		builder.append(wClass);
		builder.append("]");
		return builder.toString();
	}

}
