package it.galaxyArtifacts.gui;

import it.galaxyArtifacts.model.Planet;
import it.galaxyArtifacts.model.Star;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SelectionElement extends GuiElement {

	private Image img;
	private Star model;

	public SelectionElement(float x, float y, boolean visible, Star model) {
		super(x, y);
		this.visible = visible;
		this.model = model;
		try {
			img = new Image("res/gui/system_selection1.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void render(GameContainer container, Graphics g) {
		if (img != null && visible) {
			g.drawImage(img, x - img.getWidth() / 2, y - img.getHeight() / 2);
		}
		int b = 32;
		g.drawRoundRect(x - 5, y + b - 5, calculateWidth(model, g) + 10,
				calculateHeight(model, g) + 10, 10);

		g.drawString("Type " + model.type.toString(), x, y + b);
		b += 16;
		g.drawString("Planets", x, y + b);
		b += 16;
		for (Planet p : model.planets) {
			g.drawString(p.name + " type " + p.type, x, y + b);
			b += 16;
		}
	}

	private int calculateHeight(Star model, Graphics g) {
		return g.getFont().getHeight("a") * (model.planets.size() + 3);
	}

	private float calculateWidth(Star model, Graphics g) {
		float size = model.name.length();
		for (Planet p : model.planets) {
			int s = g.getFont().getWidth(p.name + " type " + p.type);
			size = s > size ? s : size;
		}
		return size;
	}

	@Override
	public void update(GameContainer container) {

	}

}
