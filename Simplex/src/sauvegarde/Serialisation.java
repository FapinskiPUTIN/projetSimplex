package sauvegarde;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import modele.Matrice;

public class Serialisation {



	public Serialisation() {

	}

	public static void ecrireFichier(String nomF,Matrice o) {
		try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(nomF+".obj"))) {
			stream.writeObject(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void ecrireFichierEnnonce(String nomF,String o) {
		try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(nomF+".obj"))) {
			stream.writeObject(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	//Lecture du toString() de matrice 
	public static String lireFichier(String nomF) {
		Matrice polyLecture = null;
		try (ObjectInputStream ip = new ObjectInputStream(new FileInputStream(nomF+".obj"))){
			polyLecture = (Matrice)ip.readObject();
			System.out.print(polyLecture.toString());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	public static void ecrireFichierTexte(String nomF,Matrice t) {


		try(PrintWriter pw=new PrintWriter(new FileOutputStream(nomF+".txt"));) {	
			pw.println(t.toString());
			pw.write("\r\n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static void ecrireFichierTexteEnnonce(String nomF,String t) {

		try(PrintWriter pw=new PrintWriter(new FileOutputStream(nomF+".txt"));) {	
			pw.println(t.toString());
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}


