package com.isen.model;

public class Case {

	private Ship ship;
	private boolean isHitted;

	public Case() {
		// TODO Auto-generated constructor stub
		this.ship = null;
	}

	public Case(Ship ship) {
		if (ship == null) {
			throw new NullPointerException();
		}
		this.ship = ship;
	}

	public boolean isEmpty() {
		if (this.ship == null) {
			return true;
		} else if (this.ship != null) {
			return false;
		}
		return true;
	}

	public Ship attacked() {
		if (this.ship != null && this.isHitted == false) {
			ship.hitted();
			this.isHitted = true;
			return this.ship;
		}
		return null;
	}

	public boolean isHitted() {
		return this.isHitted;
	}

	public Ship getShip() {
		return this.ship;
	}

	public void removeShip() {
		this.ship = null;
	}

}
