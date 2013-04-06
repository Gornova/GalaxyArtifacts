package it.galaxyArtifacts.generate.connection;

import it.galaxyArtifacts.core.Entity;
import it.galaxyArtifacts.core.EntityManager;
import it.galaxyArtifacts.entities.StarEntity;
import it.galaxyArtifacts.generate.interfaces.Connectable;
import it.galaxyArtifacts.model.Connections;

import java.util.ArrayList;
import java.util.List;

public class RandomConnection implements Connectable {

	/**
	 * Create random connection between entities
	 */
	public void connect(EntityManager em, Connections c) {
		List<Entity> stars = new ArrayList<Entity>();
		for (Entity e : em.entities) {
			if (e instanceof StarEntity) {
				stars.add(e);
			}
		}
		int index = 0;
		for (Entity e : stars) {
			if (index >= 1) {
				c.connect(e, stars.get(index - 1));
			}
			index++;
		}
	}

}
