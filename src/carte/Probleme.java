package carte;

import carte.Carte;

public abstract class Probleme extends Carte {
	Type type;

	public Type getType() {
		return type;
	}

	protected Probleme(Type type) {
		super();
		this.type = type;
	}
	
	
}
