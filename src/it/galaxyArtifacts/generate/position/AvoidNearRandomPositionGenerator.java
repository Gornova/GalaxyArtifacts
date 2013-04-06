package it.galaxyArtifacts.generate.position;

import it.galaxyArtifacts.generate.interfaces.PositionGenerarable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

public class AvoidNearRandomPositionGenerator implements PositionGenerarable {

	private List<Point> points;
	private int maxWidth;
	private int maxHeight;
	private static final int MIN_DISTANCE = 5;

	public AvoidNearRandomPositionGenerator(int maxWidth, int maxHeight) {
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
				if (!nearOtherPoint(p)) {
					points.add(p);
					t++;
				}
			}
			i++;
			if (i > 1000) {
				Log.error("after 1000 try,not generated all points: "
						+ points.size() + "/" + n);
				end = true;
			}
		}
		return points;
	}

	private boolean nearOtherPoint(Point p) {
		for (Point check : points) {
			if (Math.abs(distance(check, p)) <= MIN_DISTANCE) {
				return true;
			}
		}
		return false;
	}

	private float distance(Point one, Point two) {
		Vector2f vone = new Vector2f(one.getX(), one.getY());
		Vector2f vtwo = new Vector2f(two.getX(), two.getY());
		return vone.distance(vtwo);
	}

	private boolean contains(Point p1) {
		for (Point p : points) {
			if (p.getX() == p1.getX() && p.getY() == p1.getY()) {
				return true;
			}
		}
		return false;
	}

}
