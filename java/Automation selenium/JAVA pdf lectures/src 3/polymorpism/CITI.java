package polymorpism;

public class CITI extends RBI {

	public static void main(String[] args) {

		CITI obj = new CITI();
		System.out.println(obj.getHomeLoanROI());

		RBI obj2 = new CITI();
	}

	public double getHomeLoanROI() {

		return 10.5;

	}

	public Integer show() {

		return 10;

	}

}
