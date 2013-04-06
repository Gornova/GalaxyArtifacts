package it.galaxyArtifacts.core;

import it.galaxyArtifacts.core.interfaces.Renderable;
import it.galaxyArtifacts.core.interfaces.Updatable;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.util.Log;

public abstract class Entity implements Updatable, Renderable {

	public static final int TILE_SIZE = 32;

	public final int id;
	private static int idGenerator = 0;

	protected Image img;

	// on matrix coordinate
	public int mx;
	public int my;

	// on screen coordinates
	public int x;
	public int y;

	// center of entity
	public int cx;
	public int cy;

	public Entity(int mx, int my) {
		this.mx = mx;
		this.my = my;
		this.x = mx * TILE_SIZE;
		this.y = my * TILE_SIZE;
		id = ++idGenerator;
		Log.debug("id for new entity " + id);
	}

	@Override
	public void render(GameContainer container, Graphics g) {
		if (img != null) {
			img.draw(x, y);
		}
	}

	public static void clearIdGenerator() {
		idGenerator = 0;
	}

}
