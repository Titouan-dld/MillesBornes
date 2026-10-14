package cartes;

public class Borne extends Carte {

	private Integer km;

	public Borne(Integer km) {
		super();
		this.km = km;
	}
	
	@Override
	public String toString() {
		return "Bornes de " + km;
	}
	
	public Integer getKm() {
		return km;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne borne) {
			return km.equals(borne.getKm());
		}
		return false;
	}
	
}
