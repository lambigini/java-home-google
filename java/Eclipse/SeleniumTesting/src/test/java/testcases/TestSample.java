package testcases;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		inputFromExcel ed = new inputFromExcel();
		ArrayList data = ed.getdata("TC1");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
	}

}
