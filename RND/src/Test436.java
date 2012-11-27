import java.util.Scanner;


public class Test436 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter the Size of Array");
		int length=scanner.nextInt();
		int[] originalarray = new int[length];
		for (int i = 0; i < originalarray.length; i++) {
			System.out.print("Please enter the value at: "+i+" position ");
			originalarray[i]=scanner.nextInt();
		}
		int k=0;
		System.out.print("\nPlease Enter the value you want to search: ");
		int searchitem=scanner.nextInt();
		for (int i = 0; i < originalarray.length; i++) {
			if(originalarray[i] == searchitem){
				System.out.println("The value " +searchitem+" found at "+i+ "position");
				k++;
			}
		}
		if(k == 0){
			System.out.println("Search Item not found in the Array");
		}
	}
}
