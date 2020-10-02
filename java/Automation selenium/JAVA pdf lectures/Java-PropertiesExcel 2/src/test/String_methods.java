package test;

public class String_methods {


	public static void main(String[] args) {


		String s = new String();
		
		s = "Hello World";

		System.out.println(s);
		
		String x = "Java";
		
		String complete_string = s+" "+x;
		
		System.out.println(complete_string);
		
		String abc = "We"+" " + "are"+" " + "Learning"+" " + "String"+" " + ".";
		System.out.println(abc);
		
		boolean b = true;
		
		String a = "this is" + " "+ b;
		System.out.println(a);
		
		
		
		s = "The quick brown fox jumps over the laze little dog";
		
		System.out.println("Length of the String is :"+s.length());
		System.out.println(s.charAt(4));
		System.out.println(s.indexOf('o'));
		System.out.println(s.indexOf("o", 13));
		
		String actual = "yahoo.com";
		String expected = "yahoo.com";
		System.out.println(actual.equals(expected));
		
		String add = "7 + 3 =";
		System.out.println(add.substring(0, 1));
		System.out.println(add.substring(4, 5));
		
		int num1 = Integer.parseInt(add.substring(0, 1));
		int num2 = Integer.parseInt(add.substring(4, 5));
		int total = num1+num2;
		System.out.println(total);
		
		String final_value = String.valueOf(total);
		
		String arr[] = s.split("fox");
		
		for(int i=0; i<arr.length; i++){
			
			System.out.println(arr[i]);
		}
		
		
		//way2automation.com
		
		
	}

}
