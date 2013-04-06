package it.galaxyArtifacts.entities;

import it.galaxyArtifacts.core.Entity;
import it.galaxyArtifacts.model.Star;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class StarEntity extends Entity {

	public Star star;

	public StarEntity(int mx, int my, Star star, Image img) {
		super(mx, my);
		this.star = star;
		this.img = img;
		this.cx = x + img.getWidth() / 2;
		this.cy = y + img.getHeight() / 2;
	}

	@Override
	public void render(GameContainer container, Graphics g) {
		super.render(container, g);
		g.drawString(star.name, x, y + 32);
	}

	@Override
	public void update(GameContainer container) {
	}

}
