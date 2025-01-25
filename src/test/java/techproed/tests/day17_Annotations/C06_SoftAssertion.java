package techproed.tests.day17_Annotations;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C06_SoftAssertion {

    @Test
    public void test01() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(3, 2, "Datalar esit olmali");
        System.out.println("1 nolu akıs devam ediyor");
        softAssert.assertNotEquals(2, 2, "Datalar esit olmamali");
        System.out.println("2 nolu akıs devam ediyor");
        softAssert.assertTrue(12 < 3, "12 nin 3 ten kücük oldugu test edildi");
        System.out.println("3 nolu akıs devam ediyor");
        softAssert.assertFalse(12 < 13, "12 nin 13 ten buyuk oldugu test edildi");
        System.out.println("4 nolu akıs devam ediyor");
        softAssert.assertAll();
        System.out.println("BU MESAJ CONSOLE DA GORULMEYECEK CUNKU AKIS DURACAK");
        /*
        SoftAssert un hata bulsa bile calismaya devam etme özelligi assertAll() a kadardir
        Eger assertAll() da failed rapor edilirse calisma durur ve clasin kalan kismi calistirilmaz
        Yani assertAll() hard Assert teki her bir assert gibidir hatayi yakalarsa calismayi durdurur.
         */
    }
}

