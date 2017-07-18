package Chrome_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

//@SuppressWarnings("unused")
public class Userlogin {
	
	public Userlogin(String UserName,String BrandName,WebDriver Driver)
	{
		Driver.findElement(By.xpath("//input[@name='UserNameInputText']")).sendKeys(UserName);
		Select brand_dropdown=new Select(Driver.findElement(By.id("Brand")));
		brand_dropdown.selectByVisibleText("Mack");
		Driver.findElement(By.xpath("//input[@name='CmdLogin']")).click();
		String Title=Driver.getTitle();
		if(!Driver.findElements(By.id("Cancel")).isEmpty())
		{
			Driver.findElement(By.id("Cancel")).click();
		}
		
		if(!Title.contains("VSS 4"))
		{
			System.out.println(UserName+""+"does not exists");
			Driver.quit();
		}
	}
} 