package it.galaxyArtifacts.generate;

import it.galaxyArtifacts.model.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetGenerator {

	public List<Planet> planets = new ArrayList<Planet>();

	public PlanetGenerator() {
	}

	public PlanetGenerator generate(String starname, int n) {
		for (int i = 0; i < n; i++) {
			// TODO: for now just terran planets
			Planet p = new Planet(NameGenerator.planetName(starname),
					Planet.TYPES.TERRAN);
			planets.add(p);
		}
		return this;
	}
}
