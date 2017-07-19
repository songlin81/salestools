package Chrome_Automation;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import MyPackage.Driver;

public class Browser {
	
	static String driverPath = "C:\\Eclipse\\";
	
	public static WebDriver driver;
	
	static Driver dr;
	static Map<String, String> mp;
	
	public static WebDriver getBrowser(String browserType) {
		switch (browserType) {
		case "firefox":
			return	driver = new FirefoxDriver();
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions");
			dr=new Driver("C:\\selenium\\drv.xlsx");
			mp = dr.getMap();
			System.setProperty(mp.get("webdriver"), mp.get("driverlocation"));
			driver = new ChromeDriver(options);
			return driver;
		case "IE":
			System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
			return	driver = new InternetExplorerDriver();
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			return driver = new FirefoxDriver();
		}
	}
}
