package cartes;

public class FinLimite extends Limite {

	@Override
	public String toString() {
		return "Fin de limite de vitesse 50";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof FinLimite;
	}
	
}
