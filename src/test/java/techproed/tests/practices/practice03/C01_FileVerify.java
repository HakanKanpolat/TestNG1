package techproed.tests.practices.practice03;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileVerify {

    @Test
    public void test01() {

        //Verify that we have pom.xml file in our project => please try in 4 min s
        // Projectimizde pom.xml dosyasi nin varligini test edin

        String path ="pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(path)));


    }
}
