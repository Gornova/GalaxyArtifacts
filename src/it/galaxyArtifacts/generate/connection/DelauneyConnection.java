package it.galaxyArtifacts.generate.connection;

import il.ac.idc.jdt.DelaunayTriangulation;
import il.ac.idc.jdt.Point;
import il.ac.idc.jdt.Triangle;
import it.galaxyArtifacts.core.Entity;
import it.galaxyArtifacts.core.EntityManager;
import it.galaxyArtifacts.entities.StarEntity;
import it.galaxyArtifacts.generate.interfaces.Connectable;
import it.galaxyArtifacts.model.Connections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DelauneyConnection implements Connectable {

	/**
	 * Connect entities using DelaunayTriangulation
	 * 
	 * @see DelaunayTriangulation
	 */
	public void connect(EntityManager em, Connections c) {
		List<Entity> stars = new ArrayList<Entity>();
		for (Entity e : em.entities) {
			if (e instanceof StarEntity) {
				stars.add(e);
			}
		}
		DelaunayTriangulation dt = new DelaunayTriangulation(convert(stars));
		connect(em, c, dt);
	}

	private void connect(EntityManager em, Connections c,
			DelaunayTriangulation dt) {
		Triangle curr = null;
		Iterator<Triangle> it = dt.trianglesIterator();
		while (it.hasNext()) {
			curr = it.next();
			if (!curr.isHalfplane()) {
				int mx = (int) curr.getA().getX();
				int my = (int) curr.getA().getY();
				Entity one = em.findEntity(mx, my);
				mx = (int) curr.getB().getX();
				my = (int) curr.getB().getY();
				Entity two = em.findEntity(mx, my);
				mx = (int) curr.getC().getX();
				my = (int) curr.getC().getY();
				Entity three = em.findEntity(mx, my);
				// connect them
				c.connect(one, two);
				c.connect(two, three);
				c.connect(three, one);
			}
		}
	}

	private Collection<Point> convert(List<Entity> entities) {
		Collection<Point> points = new ArrayList<Point>();
		for (Entity e : entities) {
			points.add(new Point(e.mx, e.my));
		}
		return points;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 1));
		points.add(new Point(1, 10));
		points.add(new Point(3, 3));
		DelaunayTriangulation dt = new DelaunayTriangulation(points);
		Triangle curr = null;
		Iterator<Triangle> it = dt.trianglesIterator();
		while (it.hasNext()) {
			curr = it.next();
		}
	}
}
