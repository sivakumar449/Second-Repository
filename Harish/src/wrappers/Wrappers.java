package wrappers;

import java.io.IOException;

import pages.LoginPage;

public interface Wrappers {

	public void enterByName(String name,String text) throws IOException;
	public void clickByName(String name);
	public void invokeApp(String browser,String url) throws IOException;
	public void clickByXpath(String xpathvalue);
	public void selectIndexByName(String name, String index);
	public void closeBrower();
}
