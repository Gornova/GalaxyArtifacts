package it.galaxyArtifacts.util;

import it.galaxyArtifacts.core.Entity;
import it.galaxyArtifacts.entities.StarEntity;
import it.galaxyArtifacts.model.Star;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EntityFactory {

	private EntityFactory() {
	}

	public static Entity buildStar(int mx, int my, Star star) {
		return new StarEntity(mx, my, star, getImage(star));
	}

	private static Image getImage(Star star) {
		try {
			return new Image("res/stars/yellow01.png");
		} catch (SlickException e) {
			e.printStackTrace();
			return null;
		}
	}

}
