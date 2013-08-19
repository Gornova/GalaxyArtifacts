package it.galaxyArtifacts.player;

import it.galaxyArtifacts.command.interfaces.Command;
import it.galaxyArtifacts.model.Star;
import it.galaxyArtifacts.player.interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer implements Player {

	private Star homeWorld;

	public HumanPlayer(Star homeWorld) {
		this.homeWorld = homeWorld;
	}

	@Override
	public List<Command> execute() {
		return new ArrayList<Command>();
	}

	@Override
	public Star getHomeWorld() {
		return homeWorld;
	}

}
