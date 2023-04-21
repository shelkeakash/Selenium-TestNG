package Day3;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readingExcel {

	public static void main(String[] args) throws IOException {
		
		//File -> Workbook-> sheet-> cells
		
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\test.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// workbook.getSheetAt(0);
		
		int totalRows = sheet.getLastRowNum();
		
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("No. of rows : " + totalRows);
		System.out.println("No. of Cells : " + totalCells);
		
		for(int r=0;r<=totalRows;r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for(int c=0;c<totalCells;c++) {
				
				String value = currentRow.getCell(c).toString();
				System.out.print(value);
				System.out.println();
			}
		}
		workbook.close();
		fs.close();
	}

}
