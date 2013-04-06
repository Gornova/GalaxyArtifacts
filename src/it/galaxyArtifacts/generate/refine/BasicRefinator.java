package it.galaxyArtifacts.generate.refine;

import it.galaxyArtifacts.generate.interfaces.Refine;
import it.galaxyArtifacts.model.Connections;

import java.util.Random;

import org.newdawn.slick.util.Log;

public class BasicRefinator implements Refine {

	private Random rnd = new Random();

	@Override
	public Connections refine(Connections c) {
		// avoid a graph full connected
		for (int i = 0; i < c.n; i++) {
			int maxConn = rnd.nextInt(5) + 1;
			while (sum(c, i) > maxConn) {
				removeConnection(c, i);
			}
		}
		return c;
	}
	private void removeConnection(Connections c, int row) {
		for (int j = 0; j < c.n; j++) {
			if (c.matrix[row][j] == Connections.CONNECTED) {
				c.matrix[row][j] = Connections.NOTCONNECTED;
				return;
			}
		}
	}
	private int sum(Connections c, int row) {
		int sum = 0;
		for (int i = 0; i < c.n; i++) {
			if (i == row) {
				for (int j = 0; j < c.n; j++) {
					sum += c.matrix[i][j];
				}
			}
		}
		Log.debug("sum " + sum + " , row " + row);
		return sum;
	}
}
