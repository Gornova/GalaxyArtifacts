package it.galaxyArtifacts.core;

import it.galaxyArtifacts.core.interfaces.Renderable;
import it.galaxyArtifacts.core.interfaces.Updatable;
import it.galaxyArtifacts.entities.StarEntity;
import it.galaxyArtifacts.model.Connections;
import it.galaxyArtifacts.model.Galaxy;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class EntityManager implements Updatable, Renderable {

	public List<Entity> entities = new ArrayList<Entity>();
	public Galaxy galaxy;

	public EntityManager() {
		Entity.clearIdGenerator();
	}

	public EntityManager(Galaxy g) {
		this.galaxy = g;
		Entity.clearIdGenerator();
	}

	public EntityManager add(Entity e) {
		if (!entities.contains(e)) {
			entities.add(e);
		}
		return this;
	}

	public EntityManager remove(Entity e) {
		if (entities.contains(e)) {
			entities.remove(e);
		}
		return this;
	}

	@Override
	public void render(GameContainer container, Graphics g) {
		renderStarlanes(container, g);
		renderEntities(container, g);
	}

	private void renderEntities(GameContainer container, Graphics g) {
		for (Entity e : entities) {
			if (e instanceof Renderable) {
				e.render(container, g);
			}
		}
	}

	private void renderStarlanes(GameContainer container, Graphics g) {
		for (int i = 0; i < galaxy.c.n; i++) {
			for (int j = 0; j < galaxy.c.n; j++) {
				if (galaxy.c.matrix[i][j] == Connections.CONNECTED) {
					Entity start = findEntity(i);
					Entity end = findEntity(j);
					g.drawLine(start.cx, start.cy, end.cx, end.cy);
				}
			}
		}
	}
	@Override
	public void update(GameContainer container) {
		for (Entity e : entities) {
			if (e instanceof Updatable) {
				e.update(container);
			}
		}
	}

	public Entity findEntity(int id) {
		for (Entity e : entities) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public Entity findEntity(int mx, int my) {
		for (Entity e : entities) {
			if (e.mx == mx && e.my == my) {
				return e;
			}
		}
		return null;
	}

	public StarEntity findStarEntity(int mx, int my) {
		for (Entity e : entities) {
			if (e instanceof StarEntity) {
				if (e.mx == mx && e.my == my) {
					return (StarEntity) e;
				}
			}
		}
		return null;
	}

}
