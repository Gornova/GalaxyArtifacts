package it.galaxyArtifacts.util;

import it.galaxyArtifacts.core.EntityManager;
import it.galaxyArtifacts.generate.connection.DelauneyConnection;
import it.galaxyArtifacts.generate.interfaces.Connectable;
import it.galaxyArtifacts.generate.interfaces.PositionGenerarable;
import it.galaxyArtifacts.generate.interfaces.Refine;
import it.galaxyArtifacts.generate.position.AvoidNearRandomPositionGenerator;
import it.galaxyArtifacts.generate.refine.BasicRefinator;
import it.galaxyArtifacts.model.Galaxy;
import it.galaxyArtifacts.model.Star;

import java.util.List;

import org.newdawn.slick.geom.Point;

public class EntityManagerFactory {

	private EntityManagerFactory() {
	}

	public static EntityManager buildGalaxyTest() {
		Galaxy g = GalaxyFactory.buildTest();
		EntityManager em = new EntityManager(g);
		PositionGenerarable pg = new AvoidNearRandomPositionGenerator(32, 23);
		List<Point> points = pg.getPoints(g.stars.size());
		int pointsIndex = 0;
		Connectable connectable = new DelauneyConnection();
		for (Star s : g.stars) {
			Point p = points.get(pointsIndex);
			pointsIndex++;
			em.add(EntityFactory.buildStar((int) p.getX(), (int) p.getY(), s));
		}
		connectable.connect(em, g.c);
		Refine refinator = new BasicRefinator();
		refinator.refine(g.c);
		return em;
	}

}
