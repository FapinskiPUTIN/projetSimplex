package modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Simplex {
	private int lignePivot, colonnePivot, i, j;
	public Simplex() {
		
	}
	
	public void colonnePivot(ArrayList<List<Double>> m, int nbVar) {
		this.colonnePivot = 0;
		double max = 0;
		for(i=0;i<nbVar;i++){
			if(m.get(m.size()-1).get(i)>max) {
				this.colonnePivot = i;
				max = m.get(m.size()-1).get(i) ;
			}
		}
	}

	public void lignePivot(ArrayList<List<Double>> m, int nbCont) {
		this.lignePivot = 0;
		double min = m.get(0).get(m.get(0).size()-1)/m.get(0).get(colonnePivot);
		for(i=0;i<nbCont;i++) {
			if(m.get(i).get(m.get(i).size()-1)/m.get(i).get(colonnePivot) <= min) {
				min = m.get(0).get(m.get(0).size()-1)/m.get(0).get(colonnePivot);;
				lignePivot = i;
			}
		}
	}
	public void pivotUnitaire(ArrayList<List<Double>> m) {
		double diviseur = m.get(lignePivot).get(colonnePivot);
		for(i=0;i<=m.get(lignePivot).size()-1;i++) {
			m.get(lignePivot).set(i, m.get(lignePivot).get(i)/diviseur);
		}
	}
	public void entrerBase(ArrayList<List<Double>> m, int nbCont) {
		double multi;
		for(i=0;i<=nbCont;i++) {
			multi = m.get(i).get(colonnePivot);
			if(i!=lignePivot) {
				while(m.get(i).get(colonnePivot)!=0) {
					for(j=0;j<m.get(i).size();j++) {
						m.get(i).set(j,m.get(i).get(j)-(multi*m.get(lignePivot).get(j)));
					}
				}	
			}
		}
	}
	public String solutionBase(ArrayList<List<Double>> m, int nbCont) {
		String tmp="[";
		int flag = 0, cpteur;
		for(j=0;j<m.get(0).size()-1;j++) {
			cpteur = 0;
			for(i=0;i<m.size()-1;i++) {
				if(m.get(i).get(j)==1 || m.get(i).get(j) == 0) {
					cpteur++; 
					if(m.get(i).get(j)==1) {
						flag = i;
					}
				}
			}
			if(cpteur == nbCont) {
				tmp+=" "+m.get(flag).get(m.get(flag).size()-1)+" ";
			}else {
				tmp+=" 0 ";
			}
		}
		tmp+="] Z = "+Math.abs(m.get(m.size()-1).get(m.get(0).size()-1))+"\n\n";
		return tmp;
	}
	public boolean iteration(ArrayList<List<Double>> m) {
		for(j=0;j<m.get(m.size()-1).size()-1;j++) {
			if(m.get(m.size()-1).get(j)>0) {
				return false;
			}
		}
		return true;
	}
	
}
