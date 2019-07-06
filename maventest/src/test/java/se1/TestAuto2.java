package se1;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import datadriven.RangeDatabyPOI;

public class TestAuto2 {
	WebDriver dr;
	

	@DataProvider(name="test0703")
	public Object[][] getExcelData() throws IOException{
		String filePath="D:\\Users\\Administrator\\workspace\\maventest\\muketest.xlsx";
		Object[][] array= RangeDatabyPOI.poiRangeData(filePath, "sheet1");
		return array;
	}
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeTest(String browser,String url) throws InterruptedException{
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:/Users/Administrator/AppData/Local/Google/Chrome/Application/chromedriver.exe");;
			dr = new  ChromeDriver();
		}
		dr.get(url);
	}

	@Test(dataProvider="test0703")	//会循环输出excel的每一行
	public void test(String cols1,String cols2) throws InterruptedException{	//cols*：代表每行的每一列	
		dr.findElement(By.id("kw")).clear();
		dr.findElement(By.id("kw")).sendKeys(cols1);
		Thread.sleep(1000);
		dr.findElement(By.id("su")).click();
		Thread.sleep(1000);
		dr.findElement(By.id("kw")).clear();
		dr.findElement(By.id("kw")).sendKeys(cols2);
		Thread.sleep(1000);
		dr.findElement(By.id("su")).click();
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void afterTest(){
		dr.quit();	
	}
}
