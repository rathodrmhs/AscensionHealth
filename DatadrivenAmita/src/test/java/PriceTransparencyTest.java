
import com.sel.amitaTestBase.TestBase;
import static com.sel.amitaTestBase.TestBase.driver;
import static com.sel.amitaTestBase.TestBase.intialization;
import com.sel.amitaUtil.AmitaUtil;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class PriceTransparencyTest extends TestBase {

    public PriceTransparencyTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        intialization();// from test base class
    }

    @Test
    public void PriceTransparencyTest() throws Exception {

        WebElement pricetransparencyLink = driver.findElement(By.linkText("Price Transparency"));
        pricetransparencyLink.click();

        WebElement priceestimatorButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/a"));
        priceestimatorButton.click();

        //Go to Second Tab
        ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement labsLink = driver.findElement(By.linkText("Labs"));
        labsLink.click();

        WebElement bloodsampleLink = driver.findElement(By.linkText("Blood"));
        bloodsampleLink.click();

        WebElement routinelabLink = driver.findElement(By.linkText("Routine lab testing"));
        routinelabLink.click();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/div[2]/button/div/p[1]")).click();

//        driver.findElement(By.id("searchbar")).click();
//        driver.findElement(By.id("searchbar")).sendKeys(AmitaUtil.getData4().getZip());
        WebElement searchBar = driver.findElement(By.id("searchbar"));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(AmitaUtil.getData4().getZip());
        searchBar.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div[2]/div/div[1]/div[1]/button/div/div/div[2]/p")).click();

        //Selenium 4 syntax
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']"))).click();
//        driver.findElement(By.id("insurance-provider-select")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"insurance-plan-select\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[3]/button/span[1]")).click();

        //Verify Results
        WebElement fullserviceCost = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div/div/h3"));
        String servicecostOutput = "Full service cost";
        if (fullserviceCost.getText() == servicecostOutput) {
            System.out.println("");
            System.out.println(" ✅ Price is Estimated! ✅ ");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println(" ❌ Price is not Estimated! ❌ ");
            System.out.println("");

        }
        driver.quit();
    }
}
