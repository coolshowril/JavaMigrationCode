
public class Test412 {
	public static void main(String[] args) {
		int[] originalarray = new int[]{1,2,3,4,5,6,7,8,9,10};
		int a;		
		int swappos=originalarray.length-1;
		for(int i=0;i<originalarray.length/2;i++){
			a=originalarray[swappos];
			originalarray[swappos]=originalarray[i];
			originalarray[i]=a;
			swappos--;
		}
		for(int i=0;i<originalarray.length;i++){
			System.out.println(originalarray[i]);
		}
	}
}
