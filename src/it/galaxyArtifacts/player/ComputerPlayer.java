package it.galaxyArtifacts.player;

import it.galaxyArtifacts.command.DummyCommand;
import it.galaxyArtifacts.command.interfaces.Command;
import it.galaxyArtifacts.model.Star;
import it.galaxyArtifacts.player.interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer implements Player {

	private Star homeWorld;

	public ComputerPlayer(Star homeWorld) {
		this.homeWorld = homeWorld;
	}

	@Override
	public List<Command> execute() {
		// TODO: put logic here
		List<Command> d = new ArrayList<Command>();
		d.add(new DummyCommand());
		return d;
	}

	@Override
	public Star getHomeWorld() {
		return homeWorld;
	}

}
