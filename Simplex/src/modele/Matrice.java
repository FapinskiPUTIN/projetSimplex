package modele;

import java.util.ArrayList;
import java.util.List;

public class Matrice {
	private ArrayList<List<Double>> matrice;
	Simplex test = new Simplex();
	public Matrice() {
		matrice = new ArrayList<>();
		
	}
	public void creerLigne(double tabLigne[], int i, int nbContrainte) throws ArrayIndexOutOfBoundsException{
		int j;
		List<Double> ligne = new ArrayList<Double>(); 
		for(j = 0;j<tabLigne.length-1;j++) {
			ligne.add(tabLigne[j]);
		}
		for(j=1;j<=nbContrainte;j++) {
			if(j==i) {
				ligne.add((double) 1);
			}else {
				ligne.add((double) 0);
			}
		}
		ligne.add(tabLigne[tabLigne.length-1]);
		matrice.add(ligne);
		
	}
	public void creerLigneZ(double tabLigneZ[], int nbContrainte) {
		List<Double> ligne = new ArrayList<Double>();
		for(int j = 0;j<tabLigneZ.length;j++) {
			ligne.add(tabLigneZ[j]);
		}
		for(int j=1;j<=nbContrainte;j++) {
			ligne.add((double) 0);
		}
		matrice.add(ligne);
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
