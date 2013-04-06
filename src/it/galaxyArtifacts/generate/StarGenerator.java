package it.galaxyArtifacts.generate;

import it.galaxyArtifacts.model.Star;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarGenerator {

	public static final int MAX_PLANETS = 10;

	public List<Star> stars = new ArrayList<Star>();
	private Random rnd = new Random();

	public StarGenerator() {
	}

	public StarGenerator generate(int n) {
		for (int i = 0; i < n; i++) {
			// TODO: for now just yellow stars
			Star s = new Star(NameGenerator.starName(), Star.TYPES.YELLOW);
			PlanetGenerator pg = new PlanetGenerator().generate(s.name,
					rnd.nextInt(MAX_PLANETS) + 1);
			s.planets = pg.planets;
			stars.add(s);
		}
		return this;
	}
}
