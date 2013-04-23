package it.galaxyArtifacts;

import it.galaxyArtifacts.gui.twl.TWLStateBasedGame;

import java.net.URL;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Main extends TWLStateBasedGame {

	public Main(String title) {
		super(title);
	}

	@Override
	protected URL getThemeURL() {
		return getClass().getResource("simple.xml");
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new GameState());
	}

	public static void main(String[] args) throws SlickException {
		Main game = new Main("Galaxy Artifacts - Sprint 2");
		AppGameContainer container = new AppGameContainer(game);
		container.setDisplayMode(1024, 768, false);
		container.setAlwaysRender(true);
		container.setShowFPS(false);
		container.setTargetFrameRate(40);
		container.start();
	}
}
