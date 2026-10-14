package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class GestionCartes {
	
	private static int getRandom(int min, int max) {

		int range = (max - min) + 1;
     	return (int) ((range * Math.random()) + min);
	}
	
	public static <T> T extraire(List<T> liste) {
		int aleatoire = getRandom(0, liste.size()-1);
		
		return liste.remove(aleatoire);
	}
	
//	public static <T> T extraire(List<T> liste) {
//		int aleatoire = getRandom(0, liste.size());
//		
//		for(ListIterator<T> iterator = liste.listIterator(); iterator.hasNext();) {
//			T retour = iterator.next();
//			aleatoire -= 1;
//			if(aleatoire == 0) {
//				iterator.remove();
//				return retour;
//			}
//		}
//		return null;
//	}
	
	public static <T>List<T> melanger(List<T> liste) {
		List<T> melange = new ArrayList<>();
		while(!liste.isEmpty()) {
			melange.add(extraire(liste));
		}
		return melange;
	}
	
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		for(T element : liste1) {
			if(Collections.frequency(liste2, element)!=Collections.frequency(liste1, element) ) {
				return false;
			}
		}
		return true;
	}
	
	
	public static <T> List<T> rassembler(List<T> liste){
		List<T> rassemblement = new ArrayList<>();
		for(ListIterator<T> iterator = liste.listIterator(); iterator.hasNext();) {
			T element = iterator.next();
			int indice = rassemblement.indexOf(element);
			if(indice == -1) {
				rassemblement.add(element);
			} else {
				rassemblement.add(indice, element);
			}
		}
		return rassemblement;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste){
		for(ListIterator<T> iterator = liste.listIterator(); iterator.hasNext();) {
			T element = iterator.next();
			boolean first = true;
			for(ListIterator<T> iterator2 = liste.listIterator(); iterator2.hasNext();) {
				T element2 = iterator2.next();
				if(first) {
					element2 = iterator2.next();
					first = false;
				}
				while(element.equals(element2) && iterator2.hasNext()) {
					element = iterator.next();
					element2 = iterator2.next();
					if(!iterator2.hasNext()) {
						return true;
					}
				}
				if(element.equals(element2)) {
					return false;
				}
			}
		}
		return true;
	}
}
