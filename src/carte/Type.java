package carte;

public enum Type {
	FEU("Feu rouge", "Feu vert", "Prioritaire"), 
	ESSENCE( "Panne d'essence", "essence", "camion citerne"), 
	CREVAISON("Crevaison", "Roue de secours", "Increvable"), 
	ACCIDENT("Accident", "Reparation", "As du volant");

	private String attaque;
	private String parade;
	private String Botte;
	
	private Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		Botte = botte;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return Botte;
	}
	
	
	
}
