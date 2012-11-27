package com.transferback;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Testing
{
	public static void main(String[] args) 
	{
		int i,dummy;
		Set<Integer> s1= new HashSet<Integer>();
		s1.add(3);
		s1.add(4);
		s1.add(5);
		s1.add(6);
		s1.add(7);
		s1.add(8);
		Set<Integer> s2= new HashSet<Integer>();
		s2.add(1);
		s2.add(2);
		s2.add(3);
		s2.add(4);
		s2.add(5);
		s2.add(6);
		Set<Integer> difference= new HashSet<Integer>();
		System.out.println("set1"+s1);
		System.out.println("set2"+s2);
		System.out.println("Please select one of the below");
		System.out.println("1.Intersection\n2.Union\n3.Difference");
		Scanner scanner= new Scanner(System.in);
		i=scanner.nextInt();
		switch(i)
		{
		case 1:
			System.out.println("Intersection");
			s1.retainAll(s2);
			System.out.println(s1);
			break;
		case 2:
			System.out.println("Union");
			s1.addAll(s2);
			System.out.println(s1);
			break;
		case 3:
			System.out.println("Difference");
			Iterator<Integer> itr=s1.iterator();
			while(itr.hasNext())
			{
				dummy=itr.next();
				if(s2.contains(dummy)){
					
					}
				else{
					difference.add(dummy);
				}
					
			}
			s1.removeAll(s2);
			System.out.println(s1);
			//System.out.println(difference);
			break;
		default:
			System.out.println("Invalid choice");
			break;
			
		}
		
	}

}
