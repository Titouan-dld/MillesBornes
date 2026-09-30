package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import carte.Carte;

public class Sabot implements Iterable<Carte>{

	private Carte[] sabot;
	private int nbCartes;
	private int nombreOperation = 0;
	
	public Sabot(Carte[] sabot) {
		this.sabot = sabot;
		this.nbCartes = sabot.length;
	}
	
	public boolean estVide() {
		return (nbCartes == 0);
	}
	
	public void ajouterCarte(Carte carte) {
		if(nbCartes>sabot.length) {
			throw new IllegalStateException("Taille de la pile depasser");
		}
		sabot[nbCartes] = carte;
		nbCartes++;
		nombreOperation++;
	}
	

	private class Iterateur<E extends Carte> implements Iterator<Carte>{
		
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nombreOperationReference = nombreOperation;
		
		public boolean hasNext() {
			return indiceIterateur<nbCartes;
		}
		
		private void verificationConcurrence() {
			if(nombreOperation != nombreOperationReference) {
				throw new ConcurrentModificationException();
			}
		}
		
		public Carte next() {
			verificationConcurrence();
			nombreOperation++;
			nombreOperationReference++;
			indiceIterateur++;
			nextEffectue = true;
			return sabot[indiceIterateur];
		}
		
		public void remove() {
			verificationConcurrence();
			for(int i = indiceIterateur; i<nbCartes; i++) {
				sabot[i-1] = sabot[i];
			}
			sabot[nbCartes] = null;
			nbCartes--;
			nombreOperation++;
			nombreOperationReference++;
			
		}
	}
	
	@Override
	public Iterator<Carte> iterateur() {
		return new Iterateur<Carte>();
	}
	
	public Carte piocher() {
		Iterateur iter = iterateur();
		if(iter.hasNext()) {
			Carte carte = iter.next();
			iter.remove();
			return carte;
		} 
	}
}
