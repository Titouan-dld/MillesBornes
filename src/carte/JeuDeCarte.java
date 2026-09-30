package carte;

public class JeuDeCarte {

	private Configuration[] config = new Configuration[19];
	
	public String affichageJeuDeCarte() {
		String affichage = new StringBuilder("");
		for(Configuration configCarte: config) {
			
		}
		return(" ");
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
}
