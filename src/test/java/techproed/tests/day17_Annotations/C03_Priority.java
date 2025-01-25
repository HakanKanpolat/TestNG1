package techproed.tests.day17_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Priority {

    WebDriver driver;

    @BeforeMethod
    public void chromeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test//(priority = 0) Default olarak sifir oldugu icin ikinci olarak bu method calisti
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }
    @Test(priority =2 )
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @Test(priority = -1)
    public void facebookTest() {
        driver.get("https://facebook.com");
    }
}
