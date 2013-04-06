package it.galaxyArtifacts.model;

import it.galaxyArtifacts.core.Entity;
import it.galaxyArtifacts.generate.StarGenerator;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {

	public Connections c;

	public List<Star> stars = new ArrayList<Star>();

	public StarGenerator sg = new StarGenerator();

	public Galaxy() {
		// 1024x768 resolution, matrix with 32x23 tiles of 32 pixels
		c = new Connections(Entity.TILE_SIZE);
	}

	public Galaxy addStars(int n) {
		sg.generate(n);
		stars.clear();
		stars.addAll(sg.stars);
		return this;
	}

}
