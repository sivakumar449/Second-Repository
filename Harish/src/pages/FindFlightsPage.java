package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import wrappers.GenericWrappers;

public class FindFlightsPage extends GenericWrappers{
	/*clicking on find flights button
	 * */
	public FindFlightsPage(RemoteWebDriver driver)
	{
		this.driver=driver;
	}
	
	public FindFlightsPage clickOneWayTrip()
	{
		clickByXpath("//input[@name='tripType'][2]");
		return this;
	}
	//kjdfdkjfdbjbf
	
	public FindFlightsPage selectPassengers(String index)
	{
		selectIndexByName("passCount", index);
		return this;
	}
	public FindFlightsPage selectDepartingFrom(String index)
	{
		selectIndexByName("fromPort", index);
		return this;
	}
	public FindFlightsPage selectAriving(String index)
	{
		selectIndexByName("toPort", index);
		return this;
	}
	public FindFlightsPage clickBusinessClass()
	{
		clickByXpath("//input[@name='servClass'][1]");
		return this;
	}
	public void continueThird()
	{
		clickByName("findFlights");
		
	}
	

}
