package it.galaxyArtifacts.generate.position;

import it.galaxyArtifacts.generate.interfaces.PositionGenerarable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.geom.Point;
import org.newdawn.slick.util.Log;

public class RandomPositionGenerator implements PositionGenerarable {

	private List<Point> points;
	private int maxWidth;
	private int maxHeight;

	public RandomPositionGenerator(int maxWidth, int maxHeight) {
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		points = new ArrayList<Point>();
	}

	@Override
	public List<Point> getPoints(int n) {
		if (n <= 0) {
			Log.debug("n must be positive");
			return new ArrayList<Point>();
		}
		Random rw = new Random();
		Random rh = new Random();
		int t = 0;
		int i = 0;
		boolean end = false;
		while (t < n && !end) {
			Point p = new Point(rw.nextInt(maxWidth), rh.nextInt(maxHeight));
			if (!contains(p)) {
				points.add(p);
				t++;
			}
			i++;
			if (i > 1000) {
				end = true;
			}
		}
		return points;
	}

	private boolean contains(Point p1) {
		for (Point p : points) {
			if (p.getX() == p1.getX() && p.getY() == p1.getY()) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		RandomPositionGenerator pg = new RandomPositionGenerator(32, 23);
		for (Point p : pg.getPoints(10)) {
			System.out.println(p.getX() + "," + p.getY());
		}
	}
}
