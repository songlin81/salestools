package MyPackage;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import Chrome_Automation.Userlogin;

public class MessageBoard {
	
	WebDriver driver;
	
	@BeforeTest
	public void instantiate()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\chromedriver.exe");
		driver = new ChromeDriver(options);
	}
	
	@Test
	public void LogintoSystem()
	{
		driver.manage().window().maximize();
		driver.get("http://153.112.61.197/vss_connect_testr1/Login/Login.aspx?nextview=Welcome");
		Userlogin login=new Userlogin("TYP40US","Mack",driver);	
	}
}
