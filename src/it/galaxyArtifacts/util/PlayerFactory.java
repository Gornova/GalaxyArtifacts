package it.galaxyArtifacts.util;

import it.galaxyArtifacts.model.Galaxy;
import it.galaxyArtifacts.player.ComputerPlayer;
import it.galaxyArtifacts.player.HumanPlayer;
import it.galaxyArtifacts.player.PlayerManager;
import it.galaxyArtifacts.player.interfaces.Player;

public class PlayerFactory {

	private PlayerFactory() {
	}

	public static Player buildHumanPlayer(Galaxy g) {
		return new HumanPlayer(g.getRandomStar());
	}

	public static Player buildComputerPlayer(Galaxy g) {
		return new ComputerPlayer(g.getRandomStar());
	}

	public static PlayerManager buildTestManager(Galaxy g) {
		PlayerManager manager = new PlayerManager();
		manager.add(buildHumanPlayer(g));
		manager.add(buildComputerPlayer(g));
		return manager;
	}
}
