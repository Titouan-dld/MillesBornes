package cartes; 

public class JeuDeCartes {

	private Configuration[] config = new Configuration[19];
	
	public JeuDeCartes() {
		config[0] = new Configuration(3, new Attaque(Type.ACCIDENT));
		config[1] = new Configuration(6, new Parade(Type.ACCIDENT));
		config[2] = new Configuration(1, new Botte(Type.ACCIDENT));
		config[3] = new Configuration(3, new Attaque(Type.CREVAISON));
		config[4] = new Configuration(6, new Parade(Type.CREVAISON));
		config[5] = new Configuration(1, new Botte(Type.CREVAISON));
		config[6] = new Configuration(3, new Attaque(Type.ESSENCE));
		config[7] = new Configuration(6, new Parade(Type.ESSENCE));
		config[8] = new Configuration(1, new Botte(Type.ESSENCE));
		config[9] = new Configuration(5, new Attaque(Type.FEU));
		config[10] = new Configuration(14, new Parade(Type.FEU));
		config[11] = new Configuration(1, new Botte(Type.FEU));
		config[12] = new Configuration(10, new Borne(25));
		config[13] = new Configuration(10, new Borne(50));
		config[14] = new Configuration(10, new Borne(75));
		config[15] = new Configuration(12, new Borne(100));
		config[16] = new Configuration(4, new Borne(200));
		config[17] = new Configuration(4, new DebutLimite());
		config[18] = new Configuration(6, new FinLimite());
	}
	
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
	
	private int compte(Carte carte, Carte[] tableauCarte) {
		int compte = 0;
		for(Carte carteTableau: tableauCarte) {
			if(carteTableau.equals(carte)) {
				compte++;
			}
		}
		return compte;
	}
	
	public boolean checkCount() {
		Carte[] sabot = this.donnerCartes();
		for(Configuration configCarte: config) {
			if(compte(configCarte.getCarte(), sabot) != configCarte.getNbExemplaires()) {
				return false;
			}
		}
		return true;
	}
	
	public Carte[] donnerCartes() {
		int size = 0;
		for(Configuration configCarte: config) {
			size += configCarte.getNbExemplaires();
		}
		Carte[] listeDesCartes = new Carte[size];
		int j = 0;
		for(Configuration configCarte: config) {
			for(int i = 0; i<configCarte.getNbExemplaires(); ++i) {
				listeDesCartes[j] = configCarte.getCarte();
				j ++;
			}
		}
		return listeDesCartes;
		
	}
	
	
	
}
