package techproed.tests.day17_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BeforeGroupAfterGroup {

    WebDriver driver;

    @BeforeGroups("chrome")
    public void chromeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @BeforeGroups("edge")
    public void edgeSetUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test(groups = "edge")
    public void test01() {
        driver.get("https://amazon.com");
    }

    @Test(groups = "chrome")
    public void test02() {
        driver.get("https://facebook.com");
    }

    @Test(groups = "chrome")
    public void test03() {
        driver.get("https://google.com");
    }

    @AfterGroups("chrome")
    public void tearDown() {
        driver.quit();
    }
}
