package task;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.ReadProperties;

public class Production {
	public static void createProdution(WebDriver dr,String proname, String procode, String prodescription) throws InterruptedException, FileNotFoundException, IOException{
		dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "productnav"))).click();
		dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "productcreate"))).click();
		
		dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "proname"))).sendKeys(proname);		//使elements更容易维护，提取XPath（通过文件的方式，所以放到elements，）
		dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "procode"))).sendKeys(procode);	//使代码的可维护性变强了
		//js展示下拉框
		JavascriptExecutor jser = (JavascriptExecutor) dr;
		jser.executeScript("document.getElementById('PO').style.display='block'");
		WebElement ownerWebElement = dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "proowoner")));
		Select proSelect = new Select(ownerWebElement);
		proSelect.selectByValue("hlh");
		proSelect = new Select(dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "protype"))));
		proSelect.selectByValue("branch");
		//富文本框
		dr.switchTo().frame(0);
		dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "prodescription"))).sendKeys(prodescription);
		dr.switchTo().defaultContent();
		/**
		 * 滚动到元素的位置可见，两种方法
		 * jser.executeScript("arguments[0].scrollIntoView(true)",dr.findElement(By.xpath("//*[@id='submit']")));
		 * jser.executeScript("document.getElementById('submit').scrollIntoView(true)");
		 */
		jser.executeScript("document.getElementById('submit').scrollIntoView(true)");
		dr.findElement(By.xpath(ReadProperties.getprop("elements", "element", "probutton"))).click();
		
		Thread.sleep(2000);
	}
}
