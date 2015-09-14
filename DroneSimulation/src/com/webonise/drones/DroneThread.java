package com.webonise.drones;

import java.util.Timer;
import java.util.TimerTask;

public class DroneThread {
	Timer timer;
	Drone drone;

	public DroneThread(Drone drone) {
		this.drone = drone;
		timer = new Timer();
		timer.scheduleAtFixedRate(new DroneRunner(), 0, 1000);
		System.out.println("Drone init");
	}

	class DroneRunner extends TimerTask {
		public void run() {
			Coordinates coOrdinates = drone.getCoOrdinates();
			coOrdinates.setLongitude(coOrdinates.getLongitude() + 0.005);
			drone.setCoOrdinates(coOrdinates);
		}
	}

	public void stopDrone() {
		timer.cancel();
	}
}
