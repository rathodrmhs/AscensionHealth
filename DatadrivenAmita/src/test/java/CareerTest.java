
import com.sel.amitaTestBase.TestBase;
import static com.sel.amitaTestBase.TestBase.intialization;
import com.sel.amitaUtil.AmitaUtil;
import java.time.Duration;
import org.openqa.selenium.By;
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
public class CareerTest extends TestBase {

    public CareerTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        intialization();// from test base class
    }

    @Test
    public void testCareesrTestCase() throws Exception {

        driver.findElement(By.linkText("Careers")).click();
        driver.findElement(By.id("keyword-search")).click();
        driver.findElement(By.id("keyword-search")).clear();
        driver.findElement(By.id("keyword-search")).sendKeys(AmitaUtil.getData5().getKeyword());
        driver.findElement(By.id("location-search")).click();
        driver.findElement(By.id("location-search")).clear();
        driver.findElement(By.id("location-search")).sendKeys(AmitaUtil.getData5().getZipcode());
        driver.findElement(By.xpath("//div[@id='all-content']/div[3]/light-search/lw-search/div/div/div/div/form/div[3]/button/span")).click();
        driver.findElement(By.xpath("//a[@id='link-apply-0']/span/span")).click();
        Thread.sleep(2000);
        WebElement iframe = driver.findElement(By.name("icims_content_iframe"));
        driver.switchTo().frame(iframe);

        //Selenium 4 syntax
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]")));
        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(AmitaUtil.getData5().getEmail());
        driver.findElement(By.id("enterEmailSubmitButton")).click();
        Thread.sleep(2000);
        driver.close();
    }
}
