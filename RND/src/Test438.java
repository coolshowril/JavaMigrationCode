
public class Test438 {
	public static void main(String[] args) {
		int[] originalarray = new int[]{1,2,3,4,1,5,11,25,78,6,78,7,8,9,10};
		int max=originalarray[0],min=originalarray[0];
		int maxcount=0,mincount=0;
		for (int i = 0; i < originalarray.length; i++) {
			if(max<originalarray[i]){
				max=originalarray[i];
				maxcount=1;
			}
			else if(max==originalarray[i]) {
				maxcount++;
			}
			if(min>originalarray[i]){
				min=originalarray[i];
				mincount=1;
			}
			else if(min==originalarray[i]){
				mincount++;
			}
		}
		System.out.println(max+" - "+maxcount+" Times\n"+min+" - "+mincount+" Times");
	}

}
