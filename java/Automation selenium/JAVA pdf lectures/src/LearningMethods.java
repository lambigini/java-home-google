
public class LearningMethods {
	
	
	int i; //declation, intialize
	
	int j;
	// display
	
	//Return type --> dataType of the value returned by method
	
	//Keyword --> return
	
	public void show(){
		
		int a;
		int b;
		String c;
	}
	
	public int display(int k,String a, char c, float f, boolean b){ //declare --> define
	//starts 
		/*
		 * 
		 * all definitions goes here !!!
		 * 
		 */
		int j = 100;
		System.out.println("Inside Display Method");
		
		//String x = "Hello";
		//return "hello"; // last statement
		return 10;
		//return 1000;
	 //ends
	}
	

	public static void main(String[] args) {

/*
		LearningMethods learn = new LearningMethods();
		learn.show();
		//learn.display(k, a, c, f, b);
		
		LearningMethods learn1 = new LearningMethods();
		learn1.show();*/
		
		
	/*	Home h = new Home(); // h --> Object --> i = 10
		h.i++; // Object1 --> i = 11;
		
		Home h1 = new Home(); // h1 --> Object2 --> i = 10
		h1.i++;// Object2 --> i = 11;
		
		Home h2 = new Home(); // h2 --> Object3 --> i = 10;
		System.out.println(h2.i); //10
*/		
		/*
		 * Parameters vs Arguments
		 * 
		 * 
		 */
		
		
		Calculator calc = new Calculator();
		int i = calc.getSum(10, 4); 
		System.out.println("The sum is : "+i);
		
		System.out.println(calc.getMult(10, 4));
		System.out.println(calc.getDiv(10, 4));
		System.out.println(calc.getSub(10, 4));
	}

}
