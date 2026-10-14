package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.Carte;

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
	
	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte>{
		
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
			Carte carte = sabot[indiceIterateur];
			indiceIterateur++;
			nextEffectue = true;
			return carte;
		}
		
		public void remove() {
			verificationConcurrence();
			
			if (!nextEffectue) {
			    throw new IllegalStateException();
			}
			nextEffectue = false;
			
			for(int i = indiceIterateur; i<nbCartes; i++) {
				sabot[i-1] = sabot[i];
			}
			sabot[nbCartes-1] = null;
			nbCartes--;
			nombreOperation++;
			nombreOperationReference++;
			indiceIterateur += -1;
		}
	}
	
	public Carte piocher() {
		Iterateur iter = (Iterateur) iterator();
		if(iter.hasNext()) {
			Carte carte = iter.next();
			iter.remove();
			return carte;
		} 
		else {
			throw new IllegalStateException("Iterator doesn't has next");
		}
	}
}
