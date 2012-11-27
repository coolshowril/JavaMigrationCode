
public class Test634 {
	public static void main(String[] args) {
		String text="This is text123 textes texter helo textwe";
		String search="text";
		String temp=text;
		int length=0,lentemp=0;
		while(!temp.equals("")){
			temp=temp.substring(0, temp.indexOf(" ") != -1 ? temp.indexOf(" ") : temp.length());			
			if(temp.startsWith(search)){
				System.out.println(temp);
			}
			lentemp=temp.length();
			length=lentemp+length+1;
			if(length>text.length()){
				break;
			}
			temp=text.substring(length,text.length());
		}
	}

}
