package it.galaxyArtifacts.player.interfaces;

import it.galaxyArtifacts.command.interfaces.Command;
import it.galaxyArtifacts.model.Star;

import java.util.List;

public interface Player {

	public List<Command> execute();

	public Star getHomeWorld();

}
