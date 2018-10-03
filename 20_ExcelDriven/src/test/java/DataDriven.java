import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) {

	}
	
	
	public ArrayList<String> getData(String testCaseName) {
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		ArrayList<String> contents = new ArrayList<String>();
		
		try {
			fis = new FileInputStream(
					"/home/edwin/Udemy/SeleniumWebDriver/udemy-selenium-basic/20_ExcelDriven/demodata.xlsx");
			workbook = new XSSFWorkbook(fis);
			int sheets = workbook.getNumberOfSheets();
			int testCasesColumn = 0;

			for (int i = 0; i < sheets; i++) {
				if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
					XSSFSheet sheet = workbook.getSheetAt(i);

					Iterator<Row> rows = sheet.iterator();
					Row topRow = rows.next();
					
					Iterator<Cell> cells = topRow.cellIterator();
					while (cells.hasNext()) {
						Cell cell = cells.next();
						if (cell.getStringCellValue().equalsIgnoreCase("Testcases")) {
							testCasesColumn = cell.getColumnIndex();
						}
					}
					
					while (rows.hasNext()) {
						Row row = rows.next();
						
						if (row.getCell(testCasesColumn).getStringCellValue().
								equalsIgnoreCase(testCaseName)) {
							Iterator <Cell> values = row.cellIterator();
							while (values.hasNext()) {
								Cell cell = values.next();
								
								if (cell.getCellType() == CellType.STRING) {
									contents.add(cell.getStringCellValue());
								} else {
									contents.add(NumberToTextConverter.
											toText(cell.getNumericCellValue()));
								}
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return contents;
	}
}