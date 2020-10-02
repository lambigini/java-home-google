package collectionsExample;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {


		
		Set<String> set = new HashSet<String>();
		
		set.add("Raman");
		set.add("Way2Automation");
		set.add("Selenium");
		set.add("Appium");
		set.add("Raman");
		
		System.out.println(set);
	/*	
		for(int i=0; i<set.size(); i++){
			
			System.out.println();
		}*/
		/*
		for(String var:set){
			
			System.out.println(var);
		}*/
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()){
			
			String var = itr.next();
			if(var.equals("Appium")){
			System.out.println(var);
			}
		}

	}

}
