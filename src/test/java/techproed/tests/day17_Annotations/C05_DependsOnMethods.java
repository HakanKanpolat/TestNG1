package techproed.tests.day17_Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_DependsOnMethods {

    WebDriver driver;

    @BeforeClass
    public void chromeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void googleUrlTest() {
        //google sayfasina gidelim
        driver.get("https://google.com");

        //google sayfasinda oldugumuzu test edelim
        Assert.assertTrue(driver.getTitle().contains("Selenium"));

        //search boxta selenium yazarak aratalim
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("selenium", Keys.ENTER);
    }

    /*
    Eger bir testin bagimli oldugu baska bir test fail olursa TestNG bu bagli olan testi artik calistirmaz
     */
    @Test(dependsOnMethods = "googleUrlTest")
    public void googleTitleTest() {
        //basligin selenium icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("selenium"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
