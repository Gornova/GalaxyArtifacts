package it.galaxyArtifacts.util;

import it.galaxyArtifacts.model.Galaxy;

public class GalaxyFactory {

	private GalaxyFactory() {
	}

	public static Galaxy buildTest() {
		return new Galaxy().addStars(20);
	}

}
