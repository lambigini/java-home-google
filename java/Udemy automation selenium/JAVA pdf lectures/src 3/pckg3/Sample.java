package pckg3;

public class Sample {

	public static void main(String[] args) {

		Test obj = new Test();

		//System.out.println(obj.privateVariable); //-- no accessible outside class
		System.out.println(obj.publicVariable);
		System.out.println(obj.protectedVariable);
		System.out.println(obj.defaultVariable);

	}

}
