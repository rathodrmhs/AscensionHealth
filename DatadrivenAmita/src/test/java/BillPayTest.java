

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sel.amitaTestBase.TestBase;
import com.sel.amitaUtil.AmitaUtil;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author kohli
 */
public class BillPayTest extends TestBase{
    
   public BillPayTest() {
		super();
	}
    
    @BeforeMethod
	public void setUp() {
		intialization();// from test base class
        }
        
    
     @Test
      public void amita1() throws InterruptedException, Exception {

      
        driver.findElement(By.linkText("Bill Pay")).click();

//        System.out.println("Before switchint title is =" + driver.getTitle());
        driver.findElement(By.linkText("PAY A HOSPITAL BILL - VISITPAY PORTAL")).click();

        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();

        String parentWindowId = it.next();
//        System.out.println("parent window id"+parentWindowId);

        String childWindowId = it.next();
//        System.out.println("child window id"+childWindowId);

        driver.switchTo().window(childWindowId);
        System.out.println("chid window Title" + driver.getTitle());

        driver.findElement(By.xpath("//a[contains(text(),'Make a one-time payment')]")).click();

        driver.findElement(By.xpath("//input[@id='AuthenticationId0']")).click();
        driver.findElement(By.id("AuthenticationId0")).sendKeys(AmitaUtil.getData1().getUser());
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).sendKeys(AmitaUtil.getData1().getLastname());
        Select mon = new Select(driver.findElement(By.id("DateOfBirthMonth")));
        mon.selectByVisibleText("Jan");
        driver.findElement(By.id("DateOfBirthDay")).sendKeys(AmitaUtil.getData1().getDob());
        driver.findElement(By.id("DateOfBirthYear")).sendKeys(AmitaUtil.getData1().getDoby());
        driver.findElement(By.xpath("//label[@id='rbNotPatientLabel']")).click();
        Select month = new Select(driver.findElement(By.id("PatientDateOfBirthMonth")));
        month.selectByVisibleText("Jul");
        driver.findElement(By.id("PatientDateOfBirthDay")).sendKeys(AmitaUtil.getData1().getPdob());
        driver.findElement(By.id("PatientDateOfBirthYear")).sendKeys(AmitaUtil.getData1().getPdoby());

        driver.findElement(By.xpath("//label[@id='GuestPayAgreeTermsOfUseLabel']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("guestAuthenticationSubmitButton")).click();
        driver.quit();
}
}
