
public class Test437 {
	public static void main(String[] args) {
		int[] originalarray = new int[]{1,2,3,4,5,11,25,6,78,7,8,9,10};
		int k=0,maxvalue=0;
		for (int i = 0; i < originalarray.length; i++) {
			k=0;
			for (int j = 0; j < originalarray.length; j++) {
				if(originalarray[i]>=originalarray[j]){
					k++;
				}
				else{
					break;
				}
			}
			if(k==originalarray.length){
				maxvalue=originalarray[i];
				break;
			}
		}	
		System.out.println("Max is : "+maxvalue);
	}
}
