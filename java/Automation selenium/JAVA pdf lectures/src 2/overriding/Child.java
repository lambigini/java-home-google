package overriding;

public class Child extends Parent{
	
	
	public void show(){
		
		
	}

	
	
	public void display(){
		
		
		
	}
	
	public static void add(){
		
		System.out.println("add - Child ()");
	}
	
	
	public static void main(String[] args) {
		
		Parent c = new Child();
		c.show();
		c.add();
		//c.display();
	}
	
}
