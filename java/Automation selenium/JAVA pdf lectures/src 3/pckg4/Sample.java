package pckg4;

import pckg3.Test;

public class Sample extends Test {

	public static void main(String[] args) {

		/*
		 * Inheritance - one class object will inherit other class properties
		 * extends, implements
		 * A, B
		 * A extends B
		 * 
		 */

		Sample obj = new Sample();
		
		//System.out.println(obj.privateVariable);
		System.out.println(obj.publicVariable);
		System.out.println(obj.protectedVariable);
	//	System.out.println(obj.defaultVariable);
		
	
		

	}

}
