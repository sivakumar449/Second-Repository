package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataInputprovider {
	
	public static String[][] getSheet() throws IOException {
		
		String[][] data = null;
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\Sivakumar\\workspace\\Starting\\Harish\\test Data\\Data.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int rowCount=sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		data=new String[rowCount][columnCount];
		for(int i=1;i<rowCount+1;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(a[i-1][j]);
			}
		}
		return data;

	}
}