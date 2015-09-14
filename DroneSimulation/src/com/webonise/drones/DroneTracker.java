package com.webonise.drones;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.websocket.Session;

import com.google.gson.Gson;

public class DroneTracker implements Observer {

	Drone drone = null;
	Session session;

	public DroneTracker(Drone drone, Session session) {
		this.drone = drone;
		this.session = session;
	}

	@Override
	public void update(Observable obs, Object arg1) {
		if (this.drone == obs)
		{			
			try {
				Gson gson = new Gson();
				Coordinates coOrdinates = drone.getCoOrdinates();
				String json = gson.toJson(coOrdinates);
				session.getBasicRemote().sendText(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
