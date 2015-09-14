package com.webonise.server;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.webonise.drones.Drone;
import com.webonise.drones.DroneThread;
import com.webonise.drones.DroneTracker;

@ServerEndpoint("/echo")
public class DroneMapper {

	Drone drone;
	DroneTracker droneTracker;
	DroneThread droneRunner;
	Gson gson;

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("User "+session.getId() + " has opened a connection");
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println(session.getId() + " request in queue");
		try {
			Drone drone = new Drone();
			DroneTracker tracker = new DroneTracker(drone, session);
			drone.addObserver(tracker);
			droneRunner = new DroneThread(drone);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@OnClose
	public void onClose(Session session) {
		droneRunner.stopDrone();
		System.out.println("Session " + session.getId() + " has ended");
	}
}