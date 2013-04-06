package it.galaxyArtifacts.model;

public class Planet {

	public String name;
	public TYPES type;
	public static enum TYPES {
		ROCK, DESERT, TERRAN, OCEAN, INFERNO, IRRADIATED, SWAMP, TOXIC, TUNDRA
	}

	public Planet(String name, TYPES type) {
		this.name = name;
		this.type = type;
	}
}
