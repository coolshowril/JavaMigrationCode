package com.transferback;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.logging.Logger;


@SuppressWarnings("unused")
public class Comparator {
	public static void main(String[] args) {
		String temp,dummy="AC";
		int diff,diff1;
		List<String> list=new ArrayList<String>();
		List<Integer> list_diff=new ArrayList<Integer>();
		List<String> Sorted=new ArrayList<String>();
		list.add("za");
		list.add("aa");
		list.add("ad");
		list.add("ab");
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext())
		{
			temp=iterator.next();
			//System.out.println(dummy.compareTo(temp.substring(temp.indexOf(" ")+1)));
			list_diff.add(dummy.compareTo(temp.substring(temp.indexOf(" ")+1)));
		}
		System.out.println(list_diff);
		java.util.Comparator<Object> comparator = Collections.reverseOrder();
		Collections.sort(list_diff,comparator);
		System.out.println(list_diff);
		for(int i=0;i<list_diff.size();i++)
		{
			for(int j=0;j<list.size();j++)
			{
				temp=list.get(j);
				if(dummy.compareTo(temp.substring(temp.indexOf(" ")+1))==list_diff.get(i) && !Sorted.contains(temp) )
				{
					Sorted.add(temp);
				}
			}
		}
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(Sorted);
		

	}
}
