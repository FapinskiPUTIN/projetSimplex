package util;

import java.util.Arrays;
import java.util.Scanner;

import modele.Matrice;
import sauvegarde.Serialisation;

public class mainSimplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lc = new Scanner (System.in);
		Matrice m = new Matrice();
		int nbVar = 0, nbCont;
		String valTemp,tempFinal = "";
		String valZTemp;
		double valCont;
		String temp[] ;

		Serialisation s = new Serialisation();

		System.out.println("Nombre de variables : \n-------------------\n");
		nbVar = lc.nextInt();
		double[] valInt = new double[nbVar+1];
		String valeurs[] = new String[nbVar+1];
		lc.nextLine();

		System.out.println("Entrez votre Z : \n----------------\n");
		valZTemp=lc.nextLine();
		String valZ[] = new String[nbVar+1];
		double[] valZD = new double[nbVar+1];

		valZ = valZTemp.split(" +");
		
		tempFinal+="Max Z = ";
		for(int j=0;j<valZ.length;j++) {
			if(j<valZ.length-1) {
			tempFinal+=valZD[j]=Double.parseDouble(valZ[j]);
			tempFinal+="x"+(j+1)+" +";
			}else {
			tempFinal+=valZD[j]=Double.parseDouble(valZ[j]);
			tempFinal+="x"+(j+1);
			}
			
			System.out.println("val "+(j+1)+" : "+valZD[j]);
		}
		tempFinal+="\n";
		

		System.out.println("Nombre de contraintes :\n-----------------\n ");
		nbCont = lc.nextInt();
		lc.nextLine();
		temp= new String[nbCont];
		
		for(int i=0;i<nbCont;i++) {
			System.out.println("Entrez les valeurs de cette manière (ex : 1 2 8 12 ...) : \n");
			valTemp=lc.nextLine();

			valeurs = valTemp.split(" +");
			for(int j=0;j<valeurs.length;j++) {
				valInt[j]=Double.parseDouble(valeurs[j]);
				System.out.println("val "+(j+1)+" : "+valInt[j]);	
			}

			
			temp[i]="";
			for(int k=0;k<valInt.length;k++) {

				if(k<valInt.length && k!=valInt.length-2 && k!=valInt.length-1 ) {
					temp[i]+=valInt[k]+"x"+(k+1)+" + ";
				}else if(k==(valInt.length-2)) {
					temp[i]+=valInt[k]+"x"+(k+1)+" <= ";
				}else if(k==valInt.length-1) {
					temp[i]+=valInt[k]+"";
				}
			}	
			m.creerLigne(valInt, i);
		}
		System.out.println(m.toString());

		for(int i=0;i<temp.length;i++) {
			System.out.println("Contrainte"+(i+1)+temp[i]); //Il affichera ici Null pour l'élément 0
			tempFinal+=temp[i]+"\n";

		}

		
		s.ecrireFichierEnnonce("test1", tempFinal);
		s.ecrireFichierTexteEnnonce("test1", tempFinal);


		System.out.println("au revoir");
	}

}
