package demo;

public class Test {
	
	public void abc(String str) throws DupReqExc {
		
		if(false) {
			throw new DupReqExc("DUPLICATE DATA");
		}
		
		System.out.println("AFTER EXCEPTION:: "+str);
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		try {
			t.abc("abc");
		} catch (DupReqExc e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
