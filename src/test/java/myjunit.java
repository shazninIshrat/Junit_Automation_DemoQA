import io.opentelemetry.api.internal.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class myjunit {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    @DisplayName("check if title is displaying properly")
    public void getTitle(){
        driver.get("https://demoqa.com/");
        String ActualTitle=driver.getTitle();
        String ExpectedTitle="DEMOQA";
        System.out.println(ActualTitle);
        Assertions.assertTrue(ActualTitle.contains(ExpectedTitle));

    }
    @Test

    public void submitForm(){
        driver.get("https://demoqa.com/text-box");

        List<WebElement> textbox=driver.findElements(By.className("form-control"));
        textbox.get(0).sendKeys("Shaznin");
        textbox.get(1).sendKeys("shaznin@mail.com");
        textbox.get(2).sendKeys("Dhaka");
        textbox.get(3).sendKeys("Bangladesh");

        utils.scroll(driver,"500");

        WebElement submitBtn=driver.findElement(By.id("submit"));
        submitBtn.click();

        List <WebElement> resultElm=driver.findElements(By.tagName("p"));
        String Actualres1=resultElm.get(0).getText();
        String Actualres2=resultElm.get(1).getText();
        String Actualres3=resultElm.get(2).getText();
        String Actualres4=resultElm.get(3).getText();

        System.out.println(Actualres1);
        System.out.println(Actualres2);
        System.out.println(Actualres3);


         String Expres1="Shaznin";
         String Expres2="shaznin@mail.com";
         String Expres3="Dhaka";
         String Expres4="Bangladesh";

        Assertions.assertTrue(Actualres1.contains(Expres1));
        Assertions.assertTrue(Actualres2.contains(Expres2));
        Assertions.assertTrue(Actualres3.contains(Expres3));
        Assertions.assertTrue(Actualres4.contains(Expres4));



    }
//    @AfterAll
//    public void close(){
//        driver.quit();
//    }
}
