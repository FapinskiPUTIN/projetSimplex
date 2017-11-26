package util;

import java.util.Scanner;

public class mainSimplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lc = new Scanner (System.in);
		int nbVar = 0, nbCont;
		String valTemp;
		String valZTemp;
		double valCont;
		
		
		
		
		System.out.println("Nombre de variables : ");
		nbVar = lc.nextInt();
		double[] valInt = new double[nbVar];
		String valeurs[] = new String[nbVar];
		lc.nextLine();
		
		System.out.println("Entrez votre Z : ");
		valZTemp=lc.nextLine();
		String valZ[] = new String[nbVar];
		double[] valZD = new double[nbVar];
		
		valZ = valZTemp.split(" +");
		for(int j=0;j<valZ.length;j++) {
			valZD[j]=Double.parseDouble(valZ[j]);
			System.out.println("val "+j+" : "+valZD[j]);
		}
		
		System.out.println("Nombre de contraintes : ");
		nbCont = lc.nextInt();
		lc.nextLine();
		
		for(int i=0;i<nbCont;i++) {
		System.out.println("Entrez les valeurs de cette manière (ex : 1 2 8 12 ...)");
		valTemp=lc.nextLine();
		System.out.println("Entrez la contrainte");
		valCont=lc.nextDouble();
		lc.nextLine();
		
		valeurs = valTemp.split(" +");

		for(int j=0;j<valeurs.length;j++) {
			valInt[j]=Double.parseDouble(valeurs[j]);
			System.out.println("val "+j+" : "+valInt[j]);
			
		}
			System.out.println(valCont);
			//salut
		}
		System.out.println("au revoir");
		
		
	}

}
