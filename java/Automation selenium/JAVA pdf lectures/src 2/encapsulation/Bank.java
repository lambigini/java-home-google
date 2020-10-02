package encapsulation;

public class Bank {

	
	
	public int accountNo=123456;
	private int pinNo=1234;
	private double balanceAmount=1000000;
	
	
	
	
	public double getBalanceAmount() {
		return balanceAmount;
	}



	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}



	public int getAccountNo() {
		return accountNo;
	}



	public void setPinNo(int pinNo) {
		this.pinNo = pinNo;
	}



	public void withdrawAmount(int accNo,int pin,int amount){
		
		if(accNo==accountNo && pin==pinNo){
			
			if(amount<=balanceAmount){
				
				balanceAmount=balanceAmount-amount;
				System.out.println("Amount withdrwal : "+amount);
				
				
			}else{
				
				System.out.println("Insufficient Balance !!!");
			}
			
		}else{
			
			System.out.println("Invalid credentials !!!");
			
		}
	}
	
	
	
	public void updatePin(int accNo, int oldPin, int newPin){
		
		if(accNo==accountNo && oldPin==pinNo){
			
			pinNo=newPin;
			System.out.println("Pin changed successfully !!!");
			
			
		}else{
			
			System.out.println("Invalid credentials");
		}
		
	}
	
	public double depositCash(int accNo,int pin, double amount){
		
		
		if(accNo==accountNo && pin==pinNo){
			
			balanceAmount=balanceAmount+amount;
			return balanceAmount;
		}else{
			
			System.out.println("Invalid Credentials");
			return balanceAmount;
			
		}
		
	}
}
