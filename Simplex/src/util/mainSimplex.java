package util;

import java.util.Scanner;

import modele.Matrice;

public class mainSimplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lc = new Scanner (System.in);
		Matrice m = new Matrice();
		int nbVar = 0, nbCont;
		String valTemp;
		String valZTemp;
		double valCont;
		
		System.out.println("Nombre de variables : ");
		nbVar = lc.nextInt();
		double[] valInt = new double[nbVar+1];
		String valeurs[] = new String[nbVar+1];
		lc.nextLine();
		
		System.out.println("Entrez votre Z : ");
		valZTemp=lc.nextLine();
		String valZ[] = new String[nbVar+1];
		double[] valZD = new double[nbVar+1];
		
		valZ = valZTemp.split(" +");
		for(int j=0;j<valZ.length;j++) {
			valZD[j]=Double.parseDouble(valZ[j]);
			System.out.println("val "+j+" : "+valZD[j]);
		}
		
		System.out.println("Nombre de contraintes : ");
		nbCont = lc.nextInt();
		lc.nextLine();
		
		for(int i=1;i<=nbCont;i++) {
			System.out.println("Entrez les valeurs de cette manière (ex : 1 2 8 12 ...)");
			valTemp=lc.nextLine();
			/*System.out.println("Entrez la contrainte");
			valCont=lc.nextDouble();
			lc.nextLine();*/
			valeurs = valTemp.split(" +");
			for(int j=0;j<valeurs.length;j++) {
				valInt[j]=Double.parseDouble(valeurs[j]);
				System.out.println("val "+j+" : "+valInt[j]);	
			}
			m.creerLigne(valInt, i, nbCont);
		}
		m.creerLigneZ(valZD, nbCont);
		System.out.println(m.toString());
		System.out.println(m.resoudre(nbVar, nbCont));
		System.out.println("au revoir");
	}

}
