package defaulPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class WritingExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet0 = workbook.createSheet("firstSheet");
		
//		Row row0 = sheet0.createRow(0);
//		
//		Cell cellA = row0.createCell(0);
//		Cell cellB = row0.createCell(1);
//		
//		cellA.setCellValue("first cell");
//		cellB.setCellValue("second cell");

		for (int rows = 0; rows < 10; rows++) {
			Row row = sheet0.createRow(rows);
			for (int cols = 0; cols < 10; cols++) {
				Cell cell = row.createCell(cols);
				cell.setCellValue((int)(Math.random()*100));
			}
		}
		
		
		File file = new File("/Users/harrisontranimac/Desktop/udemy1/book1.xlsx");
		
		FileOutputStream fo = new FileOutputStream(file);
		
		workbook.write(fo);
		
		fo.close();
		
		System.out.println("File created");
		
		

		

	}

}
