package com.webonise.drones;

import java.util.Observable;

public class Drone extends Observable {
	Coordinates coOrdinates;

	public Drone() {
		coOrdinates = new Coordinates();
		coOrdinates.setLattitude(18.5106787);
		coOrdinates.setLongitude(73.777601);
	}

	public Coordinates getCoOrdinates() {
		return coOrdinates;
	}

	public void setCoOrdinates(Coordinates coOrdinates) {
		this.coOrdinates = coOrdinates;
		setChanged();
		notifyObservers();
	}
}