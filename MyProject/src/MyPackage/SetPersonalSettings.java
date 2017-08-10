package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import MyPackage.MessageBoard;



public class SetPersonalSettings extends MessageBoard
{
	  @Test(dependsOnMethods={"LogintoSystem"})
	  void invoke() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	  {
		  Method method = getClass().getDeclaredMethod("go2personalsettings");
		  method.invoke(this);
	      
		  Method method2 = getClass().getDeclaredMethod("setru");
		  method2.invoke(this);
		  
		  Method method3 = getClass().getDeclaredMethod("save");
		  method3.invoke(this);
		  
		  System.out.println(getClass().getSimpleName());
		  String[][] strContents = dr.getExcelsheet(getClass().getSimpleName());
		  //go2personalsettings();
		  //setru();
		  //save();
	  }
	
//	  @Test(dependsOnMethods={"LogintoSystem"})
	  void go2personalsettings()
	  {
	      WebElement element=driver.findElement(By.id("PageHeaderTopNavigationMenu_11"));

	      Actions action=new Actions(driver);
	      WebElement Psettings=driver.findElement(By.xpath("//tr[@id='PageHeaderTopNavigationMenu_11_3']"));

	      action.moveToElement(element).moveToElement(Psettings).click().perform();
	  }
	  
//	  @Test(dependsOnMethods={"go2personalsettings"})
	  void setru()
	  {
	     driver.switchTo().frame("contentFrame");
	     Select rudropdown=new Select(driver.findElement(By.id("DefaultOrganisationDropDown")));
	     rudropdown.selectByVisibleText("999425, NEXTRAN CORPORATION - JACKSONVILLE,");  
	  }
	  
//	  @Test(dependsOnMethods={"setru"})
	  void save()
	  {
	         WebElement save=driver.findElement(By.id("SaveButton"));
	         if(save.isEnabled())
	         {
	               save.click();
	         }
	         
	         // TODO: log for report output
	         Reporter.log("RUSetting saved and Application is closed");
	         
	         // Assertion for TC
		     Select rudropdown=new Select(driver.findElement(By.id("DefaultOrganisationDropDown")));
	         WebElement option = rudropdown.getFirstSelectedOption();
	         Assert.assertEquals("999425, NEXTRAN CORPORATION - JACKSONVILLE, ", option.getText());
	         
	         getscreenshot();
	         
	         driver.quit();
	  }
	  
		@AfterClass
		public void tearDown() {
			if(driver!=null) {
				driver.quit();
			}
		}
		
		public void getscreenshot()
		{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("C:\\selenium\\screenshot.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}      
       
                     
