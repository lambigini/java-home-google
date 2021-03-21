package test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stubArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
 String readString = scanner.nextLine();

 while(readString!=null) {
     System.out.println(readString);

     if (readString.isEmpty()) {
         System.out.println("Read Enter Key.");
     }

     if (scanner.hasNextLine()) {
         readString = scanner.nextLine();
     } else {
         readString = null;
     }
     
     
 }
System.out.print(list);
 }
 

	

}
