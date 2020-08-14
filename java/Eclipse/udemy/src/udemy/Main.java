package udemy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File ("/Users/harrisontranimac/Desktop/udemy1/filewriting");
		FileReader fr = new FileReader(f);
		BufferedReader reader = new BufferedReader(fr);
		
		System.out.println(reader.readLine());
		System.out.println(reader.readLine());
		System.out.println(reader.readLine());
		
		String lineString = null;
		while ((lineString = reader.readLine()) != null) {
			System.out.println(lineString);
		}
		
		reader.close();
		
		

	}

}
