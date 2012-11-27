package com.transferback;
import java.util.ArrayList;


public class Insertion_Sort_main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Insertion_sort sort=new Insertion_sort();
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(5);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(1);
		sort.insertion_sort(al);

	}

}
