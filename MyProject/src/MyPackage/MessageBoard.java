package MyPackage;

import org.testng.annotations.Test;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import Chrome_Automation.Browser;
import Chrome_Automation.Userlogin;

public class MessageBoard {
	
	WebDriver driver;
	Driver dr;
	Map<String, String> mp;

	@BeforeClass
	public void setUp() {
		driver = Browser.getBrowser("chrome");
	}
	
	@BeforeTest
	public void instantiate()
	{	
		dr=new Driver("C:\\Git\\MyProject\\sources\\drv.xlsx");
		mp = dr.getMap();
	}
	
	@Test(enabled = true)
	public void LogintoSystem()
	{
		driver.manage().window().maximize();
		driver.get(mp.get("url"));
		Userlogin login=new Userlogin(mp.get("username"), mp.get("brand"), driver);	
	}
}
