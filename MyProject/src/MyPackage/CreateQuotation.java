package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testcases.SetPersonalSettings;

public class CreateQuotation extends SetPersonalSettings {
    
	@Test(dependsOnMethods={"takefocus"})
    void move_to_create_quotation()
    {
           WebElement quotation=driver.findElement(By.xpath("//td[contains(text(),'Quotation')]"));
           Actions action=new Actions(driver);
           action.moveToElement(quotation).click().build().perform();
           WebElement create_quotation=driver.findElement(By.xpath("//div[contains(text(),'Create Quotation')]"));
           action.moveToElement(create_quotation).click().build().perform();
    }
    
    @Test(dependsOnMethods={"move_to_create_quotation"})
    void add_template()
    {
           driver.switchTo().frame("contentFrame");
           WebElement add_vehicle=driver.findElement(By.xpath("//button[@id='btnAddVehicleGroup']"));
           Actions action=new Actions(driver);
           action.moveToElement(add_vehicle).click().build().perform();
           WebElement add_template=driver.findElement(By.xpath("//button[@id='btnAddTemplate']"));
           action.moveToElement(add_template).click().build().perform();
           driver.switchTo().defaultContent();
    }
    
    @Test(dependsOnMethods={"add_template"})
    void select_template()
    {
           driver.switchTo().frame("InternalPopMain");
           Select ru_dropdown=new Select(driver.findElement(By.name("FindChassisWebTab$_ctl2$RUDropDownList")));
           ru_dropdown.selectByIndex(0);
    }
    
    @Test(dependsOnMethods={"select_template"})
    void click_on_search()
    {
           WebElement search=driver.findElement(By.id("SearchButton"));
           search.click();
    }
    
    @Test(dependsOnMethods={"click_on_search"})
    void click_template()
    {
           WebElement template=driver.findElement(By.xpath("//a[contains(text(),'Automation_sel')]"));
           template.click();
           driver.switchTo().defaultContent();
    }
    
    @Test(dependsOnMethods={"click_template"})
    void prepare_quotation()
    {
           driver.switchTo().frame("contentFrame");
           driver.switchTo().frame("confirmdialog");
           WebElement save=driver.findElement(By.xpath("//div[contains(text(),'Save')]"));
           save.click();
           //WebDriverWait wait=new WebDriverWait(driver,10);
         //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DealContextMenu_ProcessSaveButton")));
    }
}
