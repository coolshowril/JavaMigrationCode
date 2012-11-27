package com.transferback;
import java.util.ArrayList;
import java.util.Random;


public class Selection_Sort_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		/*al.add(5);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(1);*/
		Random randomGenerator = new Random();
		for(int i=1;i<=10000;i++)
		{
			al.add(randomGenerator.nextInt(10000));
		}
		Selection_Sort s=new Selection_Sort();
		System.out.println(al);
		long start=System.currentTimeMillis();
		s.selectionsort(al);
		long end=System.currentTimeMillis();
		System.out.println("Total Execution time:"+(end-start));

	}

}
