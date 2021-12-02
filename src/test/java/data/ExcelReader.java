package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fileInputStream;
	
	public FileInputStream getFileInputstream() {
		
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userData.xlsx";
		File srcFile = new File(filePath);
		
		try {
			fileInputStream = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test data file not found : " + e.getMessage());
			System.exit(0);
		}
	
		return fileInputStream;
	}
	
	public Object[][] getExcelData() throws IOException{
		
		fileInputStream = getFileInputstream();
		
		XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		int totalNumberOfRows = (sheet.getLastRowNum() + 1);
		int totalNumberOfColumns = 4;
		
		String[][] excelData = new String[totalNumberOfRows][totalNumberOfColumns];
		
		for (int i = 0; i < totalNumberOfRows; i++) {
			for (int j = 0; j < totalNumberOfColumns; j++) {
				XSSFRow row = sheet.getRow(i);
				excelData[i][j] = row.getCell(j).toString();
			}
		}
		
		workBook.close();
		
		return excelData;

	}
	
}
