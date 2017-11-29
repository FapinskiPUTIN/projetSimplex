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
	public String equation(double tabLigne[]) {
		String temp="";
		for(int i=0;i<tabLigne.length;i++) {
			if(i<tabLigne.length) {
				temp=tabLigne[i]+"x"+(i+1)+"+";
			}else if(i<tabLigne.length-2) {
				temp=tabLigne[i]+"x"+(i+1)+"<=";
			}else {
				temp=tabLigne[i]+"";
			}
		}
		return temp;
	}

	@Override
	public String toString() {
		return "Matrice [matrice=" + matrice + "]";
	}

}
