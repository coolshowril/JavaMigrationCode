package com.transferback;

public class PerfectNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n=33550336,pnum=0;
		for(int i=1;i<=n/2;i++)
		{
			if(n%i==0)
			{
				System.out.println(i+" is the Factor of "+n);
				pnum=pnum+i;
			}
		}
		if(pnum==n)
		{
			System.out.println(n+" is Perfect number");
		}
		else
		{
			System.out.println(n+" is not a Perfect number");
		}
	}

}
