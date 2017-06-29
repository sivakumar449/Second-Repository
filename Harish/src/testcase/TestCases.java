package testcase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.GenericWrappers;

public class TestCases extends GenericWrappers {
	
 @Test(dataProvider="getSheet")	
	public void firstest(String Username,String Password,String browser,String url,String index1,String index2,String index3) throws IOException{
	   
	 //RemoteWebDriver RemoteWebDriver;
	invokeApp(browser,url);
	 
	 new LoginPage(driver)
	.enterUsername(Username)
	.enterPassword(Password)
	.clickSignin()
	.clickOneWayTrip()
	.selectPassengers(index1)
	.selectDepartingFrom(index2)
	.selectAriving(index3)
	.clickBusinessClass()
	.continueThird();
  }	
		

}
