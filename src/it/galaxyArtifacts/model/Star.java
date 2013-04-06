package it.galaxyArtifacts.model;

import java.util.ArrayList;
import java.util.List;

public class Star {

	public String name;
	public TYPES type;
	public static enum TYPES {
		NOSTAR, BLACKHOLE, BLUE, ORANGE, RED, WHITE, YELLOW
	}
	public List<Planet> planets = new ArrayList<Planet>();

	public Star(String name, TYPES type) {
		this.name = name;
		this.type = type;
	}

	public Star addPlanet(Planet p) {
		if (!planets.contains(p)) {
			planets.add(p);
		}
		return this;
	}

}
