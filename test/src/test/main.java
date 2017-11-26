package test;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List x = new ArrayList<>();
		ArrayList y = new ArrayList<List>();
		x.add(1);
		x.add(3);
		x.add(5);
		y.add(x);
		x = new ArrayList<>();
		System.out.println(y.get(y.size()-1));
		x.add(1);
		x.add(4);
		x.add(5);
		y.add(x);
		y.set(1, x);
		
		System.out.println(y.indexOf(0));
		System.out.println(y.size());
		System.out.println(y.get(0));
		System.out.println(y.get(1));
	}

}
