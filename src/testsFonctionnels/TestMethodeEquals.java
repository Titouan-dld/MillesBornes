package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {

	
	public static void main(String[] args) {
		Carte borne25Nb1 = new Borne(25);
		Carte borne25Nb2 = new Borne(25);
		
		Carte feuRouge1 = new Attaque(Type.FEU);
		Carte feuRouge2 = new Attaque(Type.FEU);
		
		Carte feuVert = new Parade(Type.FEU);
		
		System.out.println("Deux cartes de 25km sont identique ? " + borne25Nb1.equals(borne25Nb2));
		System.out.println("Deux cartes de feux rouges sont identique ? " + feuRouge1.equals(feuRouge2));
		System.out.println("La carte feu rouge et la carte feu vert sont identique ? " + feuRouge1.equals(feuVert));
		
	}
}
