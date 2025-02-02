package techproed.tests.day19_pom_excel;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.CarRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PositiveLoginTest {


    //Name: US100201_Customer_Login
    //Description:Login with Customer information
    //Acceptance Criteria: As Customer, I should be able to log in to the application
    //email: johnson@cars.com
    //password: Deneme1?
    //https://www.speedyli.com/


    @Test
    public void test01() {

        //Ad: US100201_Customer_Login
        //Açıklama:Müşteri bilgileri ile giriş yapın
        //Kabul Kriterleri: Müşteri olarak uygulamaya giriş yapabilmem gerekiyor
        //e-posta: johnson@cars.com
        //şifre: Deneme1?
        //https://www.speedyli.com/

        Driver.getDriver().get(ConfigReader.getProperty("carRentalUrl"));

        CarRentalPage carRentalPage = new CarRentalPage();
        carRentalPage.loginRegisterButton.click();

        carRentalPage.emailTextBox.sendKeys(ConfigReader.getProperty("carRentalEmail"));
        carRentalPage.passwordTextBox.sendKeys(ConfigReader.getProperty("carRentalPassword"));
        carRentalPage.loginButton.click();

//        Assert.assertTrue(carRentalPage.loginVerify.getText().contains("Suzanne"));
//        Assert.assertEquals(carRentalPage.loginVerify.getText(),"Suzanne Dare");
//
        carRentalPage.loginVerify.click();

        Assert.assertTrue(carRentalPage.profile.isDisplayed());
        Assert.assertTrue(carRentalPage.logout.isDisplayed());

        Driver.closeDriver();




    }
}
