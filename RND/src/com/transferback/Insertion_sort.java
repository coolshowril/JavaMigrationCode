package com.transferback;
import java.util.ArrayList;


public class Insertion_sort {

	public void insertion_sort(ArrayList<Integer> al) {
		
		int currentindex=1,floorindex=0;
		for(floorindex=1;floorindex<al.size();floorindex++)
		{
			int temp=al.get(floorindex);
			for(currentindex=floorindex;currentindex>=0;currentindex--)
			{
				if(currentindex==0 || al.get(currentindex-1)<=temp)
				{
					al.set(currentindex, temp);
					break;
					
				}
				else
				{
					al.set(currentindex, al.get(currentindex-1));
				}
			}
		}
		System.out.println(al);
	}
	

}
