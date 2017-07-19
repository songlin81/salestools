package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.Assert;

import MyPackage.MessageBoard;

public  class SetPersonalSettings extends MessageBoard
{
	  @Test(dependsOnMethods={"LogintoSystem"})
	  void go2personalsettings()
	  {
	      WebElement element=driver.findElement(By.id("PageHeaderTopNavigationMenu_11"));

	      Actions action=new Actions(driver);
	      WebElement Psettings=driver.findElement(By.xpath("//tr[@id='PageHeaderTopNavigationMenu_11_3']"));

	      action.moveToElement(element).moveToElement(Psettings).click().perform();
	  }
	  
	  @Test(dependsOnMethods={"go2personalsettings"})
	  void setru()
	  {
	     driver.switchTo().frame("contentFrame");
	     Select rudropdown=new Select(driver.findElement(By.id("DefaultOrganisationDropDown")));
	     rudropdown.selectByVisibleText("999425, NEXTRAN CORPORATION - JACKSONVILLE,");  
	  }
	  
	  @Test(dependsOnMethods={"setru"})
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
	  }     
}      
       
                     
