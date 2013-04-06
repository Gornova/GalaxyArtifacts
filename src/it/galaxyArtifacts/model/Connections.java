package it.galaxyArtifacts.model;

import it.galaxyArtifacts.core.Entity;

import org.newdawn.slick.util.Log;

public class Connections {

	public int[][] matrix;
	public int n;

	public static final int NOTCONNECTED = 0;
	public static final int CONNECTED = 1;

	public Connections(int n) {
		this.n = n;
		clear();
	}

	public Connections clear() {
		matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = NOTCONNECTED;
			}
		}
		return this;
	}

	public Connections connect(Entity one, Entity two) {
		return set(one, two, true);
	}

	public Connections discconnect(Entity one, Entity two) {
		return set(one, two, false);
	}

	private Connections set(Entity one, Entity two, boolean connect) {
		if (one == null || two == null) {
			Log.debug("could not connect two entities if one is null");
			return this;
		}
		if (connect) {
			matrix[one.id][two.id] = CONNECTED;
			Log.debug("connect (" + one.id + "," + two.id + ")");
		} else {
			matrix[one.id][two.id] = NOTCONNECTED;
			Log.debug("notconnect (" + one.id + "," + two.id + ")");
		}
		return this;
	}

}
