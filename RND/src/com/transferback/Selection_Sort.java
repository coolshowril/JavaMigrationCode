package com.transferback;
import java.util.ArrayList;


public class Selection_Sort {

	public void selectionsort(ArrayList<Integer> al) {
		for(int outer=0;outer<al.size()-1;outer++)
		{
			int min = outer;
			for (int inner = outer + 1; inner < al.size(); inner++)
			{
				if (al.get(inner) < al.get(min))
					min = inner;
			}
			if (outer != min)
			{
				int temp = al.get(outer);
				al.set(outer, al.get(min));
				al.set(min, temp);

			}  
		}
		System.out.println(al);
	}
}