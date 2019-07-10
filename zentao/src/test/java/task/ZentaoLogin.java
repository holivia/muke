package task;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ReadProperties;

public class ZentaoLogin {
	public static void login(WebDriver dr,String username, String password) throws InterruptedException, FileNotFoundException, IOException{
		dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "username"))).sendKeys(username);		//使elements更容易维护，提取XPath（通过文件的方式，所以放到elements，）
		dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "password"))).sendKeys(password);	//使代码的可维护性变强了
		dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "loginbutton"))).click();
		Thread.sleep(1000);
	}
	
	
}
