package pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

import utils.DataInputprovider;
import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {
	
	public LoginPage(RemoteWebDriver driver)
	{
		this.driver=driver;
		
	}
	public LoginPage enterUsername(String username) throws IOException
	{
		enterByName("userName", username);
		return this;
	}
	public LoginPage enterPassword(String password) throws IOException
	{
		enterByName("password", password);
		return this;
	}
	//this method is used for clicking on login button
	public FindFlightsPage clickSignin()
	{
		clickByName("login");
		return new FindFlightsPage(driver);
	}
}
