package encapsulation;

public class ATM {

	
	public static void main(String[] args) {
		

		Bank obj = new Bank();
		
		obj.updatePin(123456, 1234, 234332);
		
		obj.withdrawAmount(123456, 234332, 1000);
		
		
	}
}
