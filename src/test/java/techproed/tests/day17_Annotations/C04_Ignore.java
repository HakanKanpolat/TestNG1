package techproed.tests.day17_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_Ignore {

    WebDriver driver;

    @BeforeMethod
    public void chromeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(enabled = false)
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }

    @Test @Ignore
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @Test
    public void facebookTest() {
        driver.get("https://facebook.com");
    }
}
