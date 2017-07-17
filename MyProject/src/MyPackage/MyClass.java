package MyPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyClass {

    public static void main(String[] args) {

    	System.setProperty("webdriver.gecko.driver","C:\\software\\geckodriver-v0.18.0-win64\\geckodriver.exe");
       //Create a new instance of Firefox Browser
       WebDriver driver = new FirefoxDriver();

       //Open the URL in firefox browser
       driver.get("https://www.google.ca/");

       //Maximize the Browser window
       //driver.manage().window().maximize();

       //Get the current page URL and store the value in variable 'str'
       String str = driver.getCurrentUrl();

       //Print the value of variable in the console
       System.out.println("The current URL is " + str);
   }
}