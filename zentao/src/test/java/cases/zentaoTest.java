package cases;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import task.Production;
import task.ZentaoLogin;
import util.Browser;
import util.RangeDatabyPOI;

public class zentaoTest {
	WebDriver dr;
	//Logger logger = Logger.getLogger(Test.class);
	String browser;
	String url;
	String username;
	String password;
	
	@DataProvider(name="test0707")
	public Object[][] getExcelData() throws IOException{
		String filePath = "D:\\Users\\Administrator\\workspace\\zentao\\src\\test\\java\\data\\zentao.xlsx";
		Object[][] array = RangeDatabyPOI.poiRangeData(filePath, "创建产品");
		return array;
	}
	
	
	/**
	 * 参数初始化
	 * @param browser
	 * @param url
	 * @param password 
	 * @param username 
	 * @throws InterruptedException
	 */
	@Parameters({"browser","url","username","password"})
	@BeforeTest
	public void beforeTest(String browser, String url, String username, String password) throws InterruptedException{
		//logger.info("borwser is " +browser+",url is "+url);
		this.browser=browser;
		this.url=url;
		this.username=username;
		this.password=password;
	}

	@Test(dataProvider="test0707")	//会循环输出excel的每一行
	public void test(String proname, String procode, String prodescription) throws InterruptedException, FileNotFoundException, IOException{	//cols*：代表每行的每一列	
		dr = Browser.openBrowser(browser, url, dr);	//打开浏览器
		ZentaoLogin.login(dr, username, password);	//账户登录
		Production.createProdution(dr, proname, procode, prodescription);	//创建产品
	}
	
	@AfterTest
	public void afterTest(){
		Browser.closeBrowser(dr);
	}
}








