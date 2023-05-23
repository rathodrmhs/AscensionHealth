/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sel.amitaTestBase.TestBase;
import static com.sel.amitaTestBase.TestBase.intialization;
import com.sel.amitaUtil.AmitaUtil;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author kohli
 */
public class SpecialtyCareTest extends TestBase{
    
     public SpecialtyCareTest() {
		super();
	}
    
    @BeforeMethod
	public void setUp() {
		intialization();// from test base class
        }
        
          @Test ()
    public void testSpecialtyCare() throws Exception {
        
        driver.findElement(By.xpath("//div[@class='field-heading']")).click();
//        driver.findElement(By.xpath("//header/div[@id='header']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
//        Thread.sleep(3000);
        driver.findElement(By.name("get-care-now-filter-location")).click();
//        Thread.sleep(3000);
        driver.findElement(By.name("get-care-now-filter-location")).clear();
//        Thread.sleep(3000);

        driver.findElement(By.name("get-care-now-filter-location")).sendKeys(AmitaUtil.getData2().getSearch());
        Thread.sleep(3000);
        driver.findElement(By.linkText("Post-acute care")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='content']/div/div[3]/div/div/div/div/div/div/div/p[5]/a")).click();
        Thread.sleep(6000);
        driver.close();
    }
}
