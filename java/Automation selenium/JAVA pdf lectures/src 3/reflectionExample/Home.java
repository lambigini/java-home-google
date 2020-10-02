package reflectionExample;

import java.lang.reflect.Constructor;

public class Home {
	
	
	public static void main(String[] args) {
		
		
		Test t = new Test();
		Class clazz = t.getClass();
		System.out.println(clazz.getSimpleName());
		Constructor[] cons = clazz.getDeclaredConstructors();
		System.out.println(cons.length);
		
		
		for(Constructor con:cons){
			
			System.out.println(con.getName());
		}
		/*Method[] arrayOfMethods = clazz.getDeclaredMethods();
		
		System.out.println(clazz.getMethods().length);
		System.out.println(arrayOfMethods.length);
		
		
		for(Method m:arrayOfMethods){
			
			System.out.println(m.getName()+"---Return type is: --"+m.getReturnType());
		
			Parameter[] params = m.getParameters();
		
			for(Parameter param:params){
				
				System.out.println(param.getName());
			}
		
		}
		*/
		/*
		 * 
		 * Test --> Object --> Class object
		 * method - > get executed - > Method
		 * constructor - > called --> Constructor
		 * 
		 * Log in log files - log4j
		 * log.debug(doLogin test executed)
		 * log.debug(doUserReg test executed)
		 * 
		 * 
		 * @BeforeMethod
		 * public void beforeMethod(Method m){
		 * 
		 * 		(Test case exected is : +m.getName)
		 * 
		 * }
		 * 
		 * 
		 * @Test
		 * doLogin(String username, String password){
		 * 
		 * }
		 * 
		 * 
		 * @Test
		 * doUserReg(){
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 */
	
		
	}
	

}
