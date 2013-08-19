package it.galaxyArtifacts.player;

import it.galaxyArtifacts.command.CommandManager;
import it.galaxyArtifacts.player.interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

	public List<Player> players = new ArrayList<Player>();

	public PlayerManager() {
	}
	public PlayerManager add(Player p) {
		players.add(p);
		return this;
	}

	public CommandManager execute(CommandManager com) {
		for (Player p : players) {
			com.addAll(p.execute());
		}
		return com;
	}

}
