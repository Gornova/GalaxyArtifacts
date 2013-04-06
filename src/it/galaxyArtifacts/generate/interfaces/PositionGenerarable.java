package it.galaxyArtifacts.generate.interfaces;

import java.util.List;

import org.newdawn.slick.geom.Point;

public interface PositionGenerarable {

	/**
	 * Create a list of point in a square matrix of lenght n
	 */
	public List<Point> getPoints(int n);

}
