package modele;

import java.util.ArrayList;
import java.util.List;

public class Matrice {
	private ArrayList<List> matrice;
	public Matrice() {
		matrice = new ArrayList<>();
	}
	public void creerLigne(double tabLigne[], int i) {
		List ligne = new ArrayList<Double>(); 
		for(int j = 0;j<tabLigne.length;j++) {
			ligne.add(tabLigne[j]);
		}
		matrice.add(ligne);
	}
	@Override
	public String toString() {
		return "Matrice [matrice=" + matrice + "]";
	}
	
}
