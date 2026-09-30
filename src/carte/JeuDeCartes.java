package carte;

import java.util.ArrayList;
import java.util.List;

public class JeuDeCartes {

	private Configuration[] config = new Configuration[19];
	
	public String affichageJeuCartes() {
		String affichage = "";
		for(Configuration configCarte: config) {
			affichage += "" + configCarte.getNbExemplaires() + "  " + configCarte.getCarte() + "\n";
		}
		return affichage;
	}
	
	private class Configuration {
		
		private int nbExemplaires;
		private Carte carte;

		private Configuration(int nbExemplaires, Carte carte) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}
		
		
	}
	public Carte[] donnerCartes() {
		int size = 0;
		for(Configuration configCarte: config) {
			size += configCarte.getNbExemplaires();
		}
		Carte[] listeDesCartes = new Carte[size];
		for(Configuration configCarte: config) {
			for(int i = 0; i<configCarte.getNbExemplaires(); ++i) {
				listeDesCartes[i] = configCarte.getCarte();
			}
		}
		return listeDesCartes;
		
	}
	
	
	
}
