package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * notes:返回WebDriver
	 * @param browser
	 * @param url
	 * @param dr
	 * 
	 * 
	 */
	public static WebDriver openBrowser(String browser, String url, WebDriver dr){
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:/Users/Administrator/AppData/Local/Google/Chrome/Application/chromedriver.exe");
			dr = new  ChromeDriver();
		}else if(browser.equals("firefox")){
			System.setProperty("webdriver.firefox.driver","firefox path");
		}else{
			//...
		}
		dr.get(url);
		return dr;
	}
	
	public static void closeBrowser(WebDriver dr){
		dr.quit();
	}

}
