import java.lang.reflect.Field;



public class test {

	/**
	 * @param args
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 */
	protected void testing(String i){
		System.out.println();
	}
	public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		test1 ts=new test1();
		String agg="123454356";
		boolean test;
		try{
			System.out.println((String)test1.class.getDeclaredField(agg).get(agg));
			test=true;
		}
		catch(Exception e){
			test=false;
		}
		System.out.println(test);
		Field[] flds=ts.getClass().getFields();
		for(int i=0;i<flds.length;i++){			
			if(ts.getClass().getField(flds[i].getName()).get(flds[i].getName()).equals(agg)){
				System.out.println(flds[i].getName());
				break;
			}
		}
		
		
	}
}
class test1{
	public static final String Aggregate="12345";
	public static final String expression="123454356";
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		test1 tes=new test1();
	}
	
}