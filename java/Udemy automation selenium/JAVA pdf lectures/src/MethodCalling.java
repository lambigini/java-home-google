
public class MethodCalling {
	
	
	// Static component --> cannot give a call to non-static component directly

	//static --> static (allowed)
	//non static --> non static, static (allowed)
	//non static components cannot be called without making an object
	// static --> OO
	
	/*
	 * 
	 * Compile
	 * Executed --> JVM
	 * 
	 * 
	 */
	public static void go3(){
		
		System.out.println("inside Go3 Method");
	}
	
	
	
	public static void main(String[] args) {

		MethodCalling m = new MethodCalling();
		m.go1();
		
		System.out.println("after calling go1 method");
		
		
		//go3();
		/*
		 * 
		 * Inside Go1 Method
		 * Inside Go Method
		 * Inside Go2 Method
		 * after calling go2 Method
		 * after calling go method
		 * after calling go1 method
		 * 
		 */
		
	}


	public void go(){
		
		System.out.println("Inside Go Method");
		go2();
		System.out.println("after calling go2 Method");
	}
	
	public void go1(){
		
		System.out.println("Inside Go1 Method");
		go();
		System.out.println("after calling go method");
	}

	public void go2(){
	
	System.out.println("Inside Go2 Method");
	}
}
