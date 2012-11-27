import java.util.Scanner;


public class Test442 {
	public static void main(String[] args) {
		
		int[] originalarray = new int[]{1,1,2,2,2,3,3,3,3,4,5,6,6,6,6};
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number of times we can permit a value in array: ");
		int times=scanner.nextInt();
		int checkval=originalarray[0];
		int pos=0,count=0;
		for (int i = 0; i < originalarray.length; i++) {
			if(checkval == originalarray[i]){
				if(count<=times-1){
					originalarray[pos]=originalarray[i];
					pos++;
				}
				count++;				
			}
			else{
				checkval=originalarray[i];
				originalarray[pos]=originalarray[i];
				pos++;
				count=1;
				
			}
		}
		originalarray = (int[])resizeArray(originalarray, pos);
		for (int i = 0; i < originalarray.length; i++) {
			System.out.println(originalarray[i]);
		}
	}
	
	private static int[] resizeArray(int[] originalarray, int pos) {
		int[] returnint=new int[pos];
		for (int i = 0; i < pos; i++) {
			returnint[i]=originalarray[i];
			
		}
		return returnint;
	}
}
