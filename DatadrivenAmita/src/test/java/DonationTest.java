
import com.sel.amitaTestBase.TestBase;
import com.sel.amitaUtil.AmitaUtil;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kohli
 */
public class DonationTest extends TestBase {

    public DonationTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        intialization();// from test base class
    }

    @Test(priority = 4)
    public void OpenBrowser() throws Exception {

        //Getting the web handle for homepage
        String currentTabHandle = driver.getWindowHandle();

        //Click on Donate
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[1]/div/div/div/div/div/div[1]/div/div/div/div[1]/div/div/div/div/ul/li[2]/div/a")).click();

        //Click on Illinois
        driver.findElement(By.xpath("//*[@id=\"facets-section__state\"]/li[4]/a/div/div/h3")).click();

        //Click on Foundation
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[1]/div/h3/a")).click();

        //Geting handles of all tabs - since a new tab was opened, and then swithcing to tne new tab
//        Thread.sleep(3000);
        Set<String> allTabHandles = driver.getWindowHandles();

        for (String tabHandle : allTabHandles) {
            if (!tabHandle.equals(currentTabHandle)) {
                driver.switchTo().window(tabHandle);
                break;
            }
        }
        //Wait until element make a gift is visible and then clicking on it
        //Selenium 4 syntax
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"comp-l8ep9eh1\"]/a/div/span[1]"))).click();

        /*
        Switching to the "form" iframe in the donation page
         */
//        Thread.sleep(5000);
        //  WebElement iframe = driver.findElement(By.xpath("//iFrame[@class=\"wuksD5\"]"));
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"comp-l8lu391c\"]/wix-iframe/div/iframe"));
        driver.switchTo().frame(iframe);

        //Scrolling down a little
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        // Waiting till the "other" donation box is visible and then clicking on it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bboxdonation_gift_rdlstGivingLevels\"]/div[6]/div/label/span")));
        driver.findElement(By.xpath("//*[@id=\"bboxdonation_gift_rdlstGivingLevels\"]/div[6]/div/label/span")).click();
//        Thread.sleep(5000);

        //inputing $1 for dollar amount to be donated
        driver.findElement(By.xpath("//*[@id=\"bboxdonation_gift_txtOtherAmountButtons\"]")).sendKeys(AmitaUtil.getData3().getDonation());
        Thread.sleep(2000);
        driver.quit();

    }
}
