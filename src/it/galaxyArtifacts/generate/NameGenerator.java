package it.galaxyArtifacts.generate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NameGenerator {

	private static final String[] names = {"Sol", "Crypto", "Antares", "Ulmia",
			"Fargo", "Orion", "Virgo", "Sirrah", "Altair", "Arcturus", "Mirak",
			"Furud", "Gomesia", "Avior", "Menkent", "Kurlah", "Tze",
			"Delphini", "Kuma", "Beid", "Wasat", "Zozma", "Matar", "Megrez"};

	private static Random rnd = new Random();

	private static Map<String, Integer> planets = new HashMap<String, Integer>();

	private NameGenerator() {
	}

	public static String starName() {
		return names[rnd.nextInt(names.length)];
	}

	public static String planetName(String starname) {
		if (!planets.containsKey(starname)) {
			planets.put(starname, 1);
			return starname + 1;
		}
		planets.put(starname, planets.get(starname) + 1);
		return starname + planets.get(starname);
	}

	public static void main(String[] args) {
		String star = NameGenerator.starName();
		System.out.println(star);
		System.out.println(NameGenerator.planetName(star));
		System.out.println(NameGenerator.planetName(star));
		System.out.println(NameGenerator.planetName(star));
		System.out.println(NameGenerator.planetName(star));
		System.out.println(NameGenerator.planetName(star));
	}

}
