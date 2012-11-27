package com.transferback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class test {
	private static final List<String> PRIVATE_VALUES = new ArrayList<String>();
	@SuppressWarnings("rawtypes")
	public static final List VALUES = Collections.unmodifiableList(  PRIVATE_VALUES );
	public static void main(String[] args) {
		PRIVATE_VALUES.add("df");
		PRIVATE_VALUES.add("dfasd");
		List<String> unmodlist=Collections.unmodifiableList(  PRIVATE_VALUES );
		PRIVATE_VALUES.add("h");
		unmodlist.add("ge");
		print(PRIVATE_VALUES);
	}
	private static void print(List<String> privateValues) {
		Iterator<String> itr=privateValues.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	protected String testing(String s){
		return s;
		
	}
}
