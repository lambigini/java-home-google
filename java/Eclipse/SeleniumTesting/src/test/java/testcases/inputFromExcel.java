package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CORBA.PUBLIC_MEMBER;

public class inputFromExcel {

//	public static void main(String[] args) throws IOException {
		public ArrayList<String> getdata(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fisFileInputStream = new FileInputStream("/Users/harrisontranimac/Desktop/TestDataExcel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fisFileInputStream);
		
		 int sheets =  workbook.getNumberOfSheets();
	
	for (int i = 0; i < sheets; i++) {
		if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
			XSSFSheet sheet = workbook.getSheetAt(i);
			Iterator<Row> rowsIterator = sheet.iterator();
			Row firstRow = rowsIterator.next();
			Iterator<Cell> ce = firstRow.cellIterator();
			int k = 0;
			int column = 0;
			while (ce.hasNext()) {
				Cell value = ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcase")) {
					//grab desire column
					column = k;
				}
				k++;
				
			}
//			System.out.println(column);
			
			
			while(rowsIterator.hasNext()) {
				Row r = rowsIterator.next();
				
			if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
				Iterator<Cell> cv = r.cellIterator();
				while(cv.hasNext()) {
//					System.out.println(cv.next().getStringCellValue());
//					a.add(cv.next().getStringCellValue());
					
					Cell c = cv.next();
					if( c.getCellType() == XSSFCell.CELL_TYPE_STRING) {
						a.add(c.getStringCellValue());
					} else 
					{
						a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					}
				}
				
			}
			}
		}
	}
return a;
}
}