package techproed.tests.practices.practice03;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_RegisterTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void registrationTest() throws InterruptedException {


        Faker faker = new Faker();

        // Adım 1: Uygulamanın ana sayfasına gidin

        driver.get("https://www.speedyli.com/");

        // Adım 2: Uygulamanın URL'sinin doğru olduğunu doğrulayın
        // Beklenen URL: "https://www.speedyli.com/"

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.speedyli.com/");

        // Adım 3: Kayıt (Register) butonunu bulun ve tıklayın

        WebElement registerButton = driver.findElement(By.xpath("//a[@href='/auth']"));
        registerButton.click();

        // Adım 4: Register formunu açmak için ilgili butona tıklayın

        WebElement registerMenu = driver.findElement(By.xpath("//button[.='Register']"));
        registerMenu.click();

        // Adım 5: Ad kutusunu bulun ve rastgele bir isim girin

        WebElement firstNameTextBox = driver.findElement(By.cssSelector("input[name='firstName']"));
        firstNameTextBox.sendKeys(faker.name().firstName());

        // Adım 6: Soyad kutusunu bulun ve rastgele bir soyisim girin

        WebElement lastNameTextBox = driver.findElement(By.cssSelector("input[name='lastName']"));
        lastNameTextBox.sendKeys(faker.name().lastName());

        // Adım 7: Telefon numarası kutusunu bulun ve bir numara girin

        WebElement phoneNumberTextBox = driver.findElement(By.cssSelector("input[name='phoneNumber']"));
        phoneNumberTextBox.click();
        phoneNumberTextBox.sendKeys(faker.phoneNumber().cellPhone());

        // Adım 8: Adres kutusunu bulun ve rastgele bir adres girin

        WebElement addressTextBox = driver.findElement(By.cssSelector("input[name='address']"));
        addressTextBox.sendKeys(faker.address().fullAddress());

        // Adım 9: Posta kodu (Zip Code) kutusunu bulun ve rastgele bir posta kodu girin

        WebElement zipCodeTextBox = driver.findElement(By.cssSelector("input[name='zipCode']"));
        zipCodeTextBox.sendKeys(faker.address().zipCode());

        // Adım 10: Email kutusunu bulun ve bir email adresi girin

        WebElement emailTextBox = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        emailTextBox.sendKeys("hakan.kanpolat0@gmail.com");

        // Adım 11: Şifre kutusunu bulun ve bir şifre girin

        WebElement passwordTextBox = driver.findElement(By.xpath("(//input[@name='password'])[2]"));
        passwordTextBox.sendKeys("Hkn04375465?");

        // Adım 12: Şifre onaylama kutusunu bulun ve aynı şifreyi tekrar girin

        WebElement confirmPasswordTextBox = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        confirmPasswordTextBox.sendKeys("Hkn04375465?");

        // Adım 13: Kayıt formunu göndermek için Submit butonuna tıklayın
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        WebElement submit = driver.findElement(By.xpath("//button[.=' Register']"));
        submit.click();


        // Adım 14: Kayıt işleminin başarılı olduğunu doğrulayin


        WebElement succesMessage = driver.findElement(By.xpath("//div[contains(text(),'registered successfully')]"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(succesMessage));

        Assert.assertTrue(succesMessage.isDisplayed());

        driver.quit();
    }
}