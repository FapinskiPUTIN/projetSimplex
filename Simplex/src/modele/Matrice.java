package modele;

import java.util.ArrayList;
import java.util.List;

public class Matrice {
	private ArrayList<List<Double>> matrice;
	public Matrice() {
		matrice = new ArrayList<>();
	}
	public void creerLigne(double tabLigne[], int i, int nbContrainte) throws ArrayIndexOutOfBoundsException{
		int j;
		List<Double> ligne = new ArrayList<Double>(); 
		for(j = 0;j<tabLigne.length-1;j++) {
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

	public ArrayList<List<Double>> getMatrice() {
		return matrice;
	}
	public void setMatrice(ArrayList<List<Double>> matrice) {
		this.matrice = matrice;
	}
	public String resoudre(int nbVar, int nbCont) {
		String tmp = "";
		boolean test2;
		do {
			test.colonnePivot(matrice, nbVar);
			test.lignePivot(matrice, nbCont);
			test.pivotUnitaire(matrice);
			tmp += toString();
			test.entrerBase(matrice, nbCont);
			tmp += toString();
			tmp += test.solutionBase(matrice, nbCont);
			test2 = test.iteration(matrice);
		}while(test2 != true);
		return tmp;
	}
	@Override
	public String toString() {
		String tmp = "";
		for(int i = 0;i < matrice.size();i++) {
			tmp+=matrice.get(i)+"\n";
		}
		return tmp+"\n";
	}
	
}
