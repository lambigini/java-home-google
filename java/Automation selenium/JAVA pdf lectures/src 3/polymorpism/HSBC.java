package polymorpism;

public class HSBC extends RBI {

	
	public static void main(String[] args) {

		HSBC obj = new HSBC();
		System.out.println(obj.getHomeLoanROI());

	}
	
	
	public double getHomeLoanROI() {

		return 10.25;

	}
	
	public AMEX getObject(){
		
		AMEX obj = new AMEX();
		return obj;
	}

	
}
