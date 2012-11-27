
public class Test435 {
	public static void main(String[] args) {
		int[] originalarray = new int[]{1,2,3,4,5,11,25,6,78,7,8,9,10};
		int max=originalarray[0],secmax=0;
		for (int i = 0; i < originalarray.length; i++) {
			if(max<originalarray[i]){
				secmax=max;
				max=originalarray[i];
			}
		}
		System.out.println(secmax+"\n"+max);		
	}
}
