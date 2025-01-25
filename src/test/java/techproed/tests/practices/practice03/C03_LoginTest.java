package techproed.tests.practices.practice03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        // Adım 1: Uygulamanın ana sayfasına gidin
        driver.get("https://www.speedyli.com/");

        // Adım 2: Uygulamanın URL'sinin doğru olduğunu doğrulayın
        // Beklenen URL: "https://www.speedyli.com/"
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.speedyli.com/");

        // Adım 3: Kayıt (Register) butonunu bulun ve tıklayın
        WebElement registerButton = driver.findElement(By.xpath("//a[@href='/auth']"));
        registerButton.click();

        // Adım 4: Giriş ekranında email kutusunu bulun ve email adresini girin
        WebElement loginEmailTextBox = driver.findElement(By.xpath("(//input[@name='email'])[1]"));
        loginEmailTextBox.sendKeys("johnson@cars.com");

        // Adım 5: Giriş ekranında şifre kutusunu bulun ve şifreyi girin
        WebElement loginPasswordTextBox = driver.findElement(By.xpath("(//input[@name='password'])[1]"));
        loginPasswordTextBox.sendKeys("Deneme1?");

        // Adım 6: Giriş (Login) butonuna tıklayın
        driver.findElement(By.xpath("//button[.=' Login']")).click();

        // Adım 7: Kullanıcı adının doğru olduğunu doğrulayın
        String expectedName="Suzanne Dare";
        String actualName = driver.findElement(By.xpath("//a[.='Suzanne Dare']")).getText();
        Assert.assertEquals(actualName,expectedName);

        driver.quit();
        // Test Datalari
        //johnson@cars.com
        //Deneme1?
        // Beklenen kullanıcı adı: "Suzanne Dare"
    }
}
