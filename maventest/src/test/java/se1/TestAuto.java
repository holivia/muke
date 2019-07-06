package se1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;
import org.uncommons.reportng.JUnitXMLReporter;

public class TestAuto {
	WebDriver dr;
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeTest(String browser,String url) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:/Users/Administrator/AppData/Local/Google/Chrome/Application/chromedriver.exe");;
		dr = new  ChromeDriver();
		dr.get("https://www.baidu.com");
	}

	@Test
	public void atest1() throws InterruptedException{	
		dr.findElement(By.id("kw")).sendKeys("A");
		Thread.sleep(1000);
		dr.findElement(By.id("su")).click();
		Thread.sleep(1000);
		
	}
	
	@Test(priority=2)
	public void btest2() throws InterruptedException{	
		dr.findElement(By.id("kw")).sendKeys("B");
		Thread.sleep(1000);
		dr.findElement(By.id("su")).click();
		Thread.sleep(1000);
		
	}
	
	@Test(priority=1)
	public void ctest3() throws InterruptedException{	
		dr.findElement(By.id("kw")).sendKeys("C");
		Thread.sleep(1000);
		dr.findElement(By.id("su")).click();
		Thread.sleep(1000);
		
	}
	@AfterTest
	public void afterTest(){
		dr.quit();	
	}
}
