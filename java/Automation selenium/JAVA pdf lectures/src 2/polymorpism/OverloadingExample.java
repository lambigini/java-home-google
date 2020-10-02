package polymorpism;

public class OverloadingExample {
	
	
	public static void main(int a){
		
		
	}
	
	//varargs

	public static void main(String[] args) {

		OverloadingExample obj = new OverloadingExample();
		//obj.doLogin("asdfsdfs", "asdfsdf");
		// obj.add(10, 20);
		//obj.add(1,2);
	/*	byte b1=10;
		byte b2=20;
		obj.add(b1,b2);*/
		obj.addition(10,10,20,30);
		
		

	}

	
	
	public void addition(int... a){
		
		int[] var = a;
		
		
	}
	public void add(int a, double b) {

	}
	
	public void add(double a, int b) {

	}
	
/*	public void add(double a, double b){
		
		
	}*/

	/*public void add(byte a, byte b) {

	}

	public void add(int a, double var) {

	}

	public void add(double var, int a) {

	}

	
	 * public int add(int a, int b) {
	 * 
	 * return 10; }
	 

	public void add(int a, int b, int c) {

	}

	public void doLogin(String username, String password) {

	}

	public void doLogin(int mobileNumber, String password) {

	}

*/}
