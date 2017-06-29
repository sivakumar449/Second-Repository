package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pages.LoginPage;

public class GenericWrappers implements Wrappers{
	public RemoteWebDriver driver;
	static int i=1;
	@Override
	public void enterByName(String name, String text) throws IOException {
		// TODO Auto-generated method stub
		try
		{
			driver.findElementByName(name).sendKeys(text);
			takeSnap();
			
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element is not found");
		}
	}

	@Override
	public void clickByName(String name) {
		// TODO Auto-generated method stub
		driver.findElementByName(name).click();
		try {
			takeSnap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	//@BeforeTest
	public void invokeApp(String browser,String url) throws IOException {

		//String browser ="chrome";
		//String url="http://newtours.demoaut.com/";
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Sivakumar\\workspace\\Starting\\Harish\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		takeSnap();
		}
	public void takeSnap() throws IOException
	{
		File src= driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snap/snap"+i+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
	}

	@Override
	public void clickByXpath(String xpathvalue) {
		// TODO Auto-generated method stub

		try {
			driver.findElementByXPath(xpathvalue).click();
			takeSnap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void selectIndexByName(String name, String index) {
		// TODO Auto-generated method stub

		WebElement web=driver.findElementByName(name);
		Select sec=new Select(web);
		int ind= Integer.parseInt(index);
		sec.selectByIndex(ind);
		try {
			takeSnap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	@SuppressWarnings("deprecation")
	@DataProvider(name="getSheet")
	public static String[][] getData() throws IOException {

		String[][] a = null;

		FileInputStream fis=new FileInputStream(new File("C:\\Users\\Sivakumar\\workspace\\Starting\\Harish\\test Data\\Data.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowCount=sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		a=new String[rowCount][columnCount];
		for(int i=1;i<rowCount+1;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				a[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(a[i-1][j]);
			}
		}

		return a;
	}
	@AfterTest
	public void closeBrower()
	{
		driver.close();
	}

}
