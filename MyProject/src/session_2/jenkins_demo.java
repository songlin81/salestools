package session_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class jenkins_demo {

    public static void main(String[] args) {
    	jenkins_demo jd=new jenkins_demo();
    	jd.zipper();
    }
    
	@Test
	public void zipper()
	{
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("chrome.switches","--disable-extensions");
//		System.setProperty("webdriver.chrome.driver", "C:\\\\Eclipse\\\\chromedriver.exe");	
//		WebDriver driver = new ChromeDriver(options);
//		driver.get("http://google.in");
		
		String Expectedtitle = "Google";
	
		String Actualtitle = "Google"; 	
		//String Actualtitle = driver.getTitle();
	
		System.out.println("Before Assetion " + Expectedtitle + Actualtitle);
	
		Assert.assertEquals(Actualtitle, Expectedtitle);
	
		System.out.println("After Assertion " + Expectedtitle + Actualtitle + " Title matched ");

        //driver.quit();
	}
	
}
