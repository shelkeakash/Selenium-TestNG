package Day3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fs = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet();
		
		Scanner sc = new Scanner(System.in);
		//XSSFRow row = sheet.createRow(0);
		/*
		row.createCell(0).setCellValue("Welcome");
		row.createCell(1).setCellValue("Welcome1");
		row.createCell(2).setCellValue("Welcome2");
		*/
		
		for(int r=0;r<=3;r++) {
			XSSFRow currentRow = sheet.createRow(r);
			for(int c=0;c<2;c++) {
				System.out.println("Enter a value : ");
				String value = sc.next();
				
				currentRow.createCell(c).setCellValue(value);
				
			}
		}
		
		System.out.println("Writing done!!!");
		workbook.write(fs);
		workbook.close();
		fs.close();
	}

}
