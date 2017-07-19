package MyPackage;

import org.testng.annotations.Test;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Chrome_Automation.Userlogin;

public class MessageBoard {
	
	WebDriver driver;
	Driver dr;
	Map<String, String> mp;

	@BeforeTest
	public void instantiate()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		
		dr=new Driver("C:\\selenium\\drv.xlsx");
		mp = dr.getMap();
		System.setProperty(mp.get("webdriver"), mp.get("driverlocation"));

		driver = new ChromeDriver(options);
	}
	
	@Test(enabled = true)
	public void LogintoSystem()
	{
		driver.manage().window().maximize();
		driver.get(mp.get("url"));
		Userlogin login=new Userlogin(mp.get("username"), mp.get("brand"), driver);	
	}
}
