package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenQuotation extends MessageBoard {
    
	@Test(dependsOnMethods={"LogintoSystem"})
    void move_to_open_quotation()
    {
			driver.switchTo().frame("contentFrame");     
			WebElement getQuotationId=driver.findElement(By.xpath("//a[contains(text(), 'NJ2017005760-JK1')]"));
			Actions action=new Actions(driver);
			action.moveToElement(getQuotationId).click().build().perform();
			driver.switchTo().defaultContent();
    }
    
    @Test(dependsOnMethods={"move_to_open_quotation"})
    void check_inquiry()
    {		   	
    	WebElement RefreshButton=driver.findElement(By.name("DealContextMenu$RefreshButton"));
    	Actions action=new Actions(driver);
    		
        int counter = 0;
        boolean update = false;
        
        while(true) {
        	driver.switchTo().frame("contentFrame");
        	if(driver.findElements(By.xpath("//a[string-length(text())=6]")).size()>0) {
        		update = true;
        		break;
        	}
        	if(counter>4) {
        		break;
        	}
        	
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	driver.switchTo().defaultContent();
        	action.moveToElement(RefreshButton).click().build().perform();
        	
        	counter++;
        }
        
        if(update) {
        	driver.switchTo().defaultContent();
        	driver.switchTo().frame("contentFrame");
        	// for reference -- make a print out of the inquiryID
        	System.out.println(driver.findElement(By.xpath("//a[string-length(text())=6]")).getText());
        	driver.quit();
        	Assert.assertTrue(true);
        }
        else {
        	driver.quit();
    		Assert.assertTrue(false);
        }
        
        //for demo present today
        //select * from CalculationRow_Inquiry where CalculationRowId='62904985-5530-45F5-91BF-B9B1021DC601'
        //update CalculationRow_Inquiry set CalculationRowId='565A28F4-638B-4012-8834-10AD4A4B8126' where id='8BD416C1-620A-43E9-9DC1-71DD1992440D'
        //update CalculationRow_Inquiry set CalculationRowId='62904985-5530-45F5-91BF-B9B1021DC601' where id='8BD416C1-620A-43E9-9DC1-71DD1992440D'
    }
//    
//    @Test(dependsOnMethods={"add_template"})
//    void select_template()
//    {
//           driver.switchTo().frame("InternalPopMain");
//           Select ru_dropdown=new Select(driver.findElement(By.name("FindChassisWebTab$_ctl2$RUDropDownList")));
//           ru_dropdown.selectByIndex(0);
//    }
//    
//    @Test(dependsOnMethods={"select_template"})
//    void click_on_search()
//    {
//           WebElement search=driver.findElement(By.id("SearchButton"));
//           search.click();
//    }
//    
//    @Test(dependsOnMethods={"click_on_search"})
//    void click_template()
//    {
//           WebElement template=driver.findElement(By.xpath("//a[contains(text(),'Automation_sel')]"));
//           template.click();
//           driver.switchTo().defaultContent();
//    }
//    
//    @Test(dependsOnMethods={"click_template"})
//    void prepare_quotation()
//    {
//           //driver.switchTo().frame("contentFrame");
//           //driver.switchTo().frame("confirmdialog");
//           //WebElement save=driver.findElement(By.xpath("//div[contains(text(),'Save')]"));
//           WebElement save=driver.findElement(By.name("DealContextMenu$ProcessSaveButton"));
//           
//           save.click();
//           //WebDriverWait wait=new WebDriverWait(driver,10);
//         //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DealContextMenu_ProcessSaveButton")));
//    }
}
