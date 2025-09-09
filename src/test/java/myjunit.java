import io.opentelemetry.api.internal.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.applet.AudioClip;
import java.security.Key;
import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class myjunit {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    @DisplayName("check if title is displaying properly")
    public void getTitle() {
        driver.get("https://demoqa.com/");
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "DEMOQA";
        System.out.println(ActualTitle);
        Assertions.assertTrue(ActualTitle.contains(ExpectedTitle));

    }

    @Test

    public void submitForm() {
        driver.get("https://demoqa.com/text-box");

        List<WebElement> textbox = driver.findElements(By.className("form-control"));
        textbox.get(0).sendKeys("Shaznin");
        textbox.get(1).sendKeys("shaznin@mail.com");
        textbox.get(2).sendKeys("Dhaka");
        textbox.get(3).sendKeys("Bangladesh");

        utils.scroll(driver, "500");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        List<WebElement> resultElm = driver.findElements(By.tagName("p"));
        String Actualres1 = resultElm.get(0).getText();
        String Actualres2 = resultElm.get(1).getText();
        String Actualres3 = resultElm.get(2).getText();
        String Actualres4 = resultElm.get(3).getText();

        System.out.println(Actualres1);
        System.out.println(Actualres2);
        System.out.println(Actualres3);


        String Expres1 = "Shaznin";
        String Expres2 = "shaznin@mail.com";
        String Expres3 = "Dhaka";
        String Expres4 = "Bangladesh";

        Assertions.assertTrue(Actualres1.contains(Expres1));
        Assertions.assertTrue(Actualres2.contains(Expres2));
        Assertions.assertTrue(Actualres3.contains(Expres3));
        Assertions.assertTrue(Actualres4.contains(Expres4));


    }

    @Test
    public void clickButtons() {
        driver.get("https://demoqa.com/buttons");
        List<WebElement> buttons = driver.findElements(By.className("btn-primary"));
        Actions action = new Actions(driver);
        action.doubleClick(buttons.get(0)).perform();
        action.contextClick(buttons.get(1)).perform();
        action.click(buttons.get(2)).perform();


        List<WebElement> resultElm = driver.findElements(By.tagName("p"));
        String Actualres1 = resultElm.get(0).getText();
        String Actualres2 = resultElm.get(1).getText();
        String Actualres3 = resultElm.get(2).getText();
        System.out.println(Actualres1);
        System.out.println(Actualres2);
    }

    @Test
    public void AlertHandle() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    @Test
    public void datehandle() {
        driver.get("https://demoqa.com/date-picker");
        driver.findElement(By.id("datePickerMonthYearInput")).click();
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("10/5/2025");

    }

    @Test
    public void dropdownSelect() {
        driver.get("https://demoqa.com/select-menu");
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        select.selectByVisibleText("Blue");
    }

    @Test
    public void dynamicDropdown() {
        driver.get("https://demoqa.com/select-menu");
        List<WebElement> dropdown = driver.findElements(By.id(" css-1hwfws3"));
        dropdown.get(1).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER);

    }

    @Test
    public void mouseHover() {
        driver.get("https://www.aiub.edu/");
        List<WebElement> menuELm = driver.findElements(By.xpath("//a[contains(text(),\"About\")]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuELm.get(1)).perform();

    }

    @Test

    public void handleTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);
        ArrayList<String> arraylist = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(arraylist.get(1));
        String text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text);
        driver.switchTo().window(arraylist.get(0));
        driver.close();
    }

    @Test
    public void windowHandle() {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("windowhandle")).click();
        String mainwindow = driver.getWindowHandle();
        Set<String> AllWindow = driver.getWindowHandles();

        Iterator<String> iterator = AllWindow.iterator();
        while (iterator.hasNext()) {
            String childwindow = iterator.next();
            if (!mainwindow.equalsIgnoreCase(childwindow)) {
                driver.switchTo().window(childwindow);
                String text = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println(text);
            }
        }
        driver.close();
        driver.switchTo().window(mainwindow);


    }

    //    public void uploadImage(){
//     driver.get("https://demoqa.com/upload-download");
//     driver.findElement(By.id("uploadFile")).sendKeys("");
//    }
    @Test
    public void scrapDataFromTable() {
        driver.get("https://demoqa.com/webtables");
        WebElement table = driver.findElement(By.className("rt-tbody"));
        List<WebElement> allRows = table.findElements(By.cssSelector("[role=rowgroup]"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.cssSelector("[role=gridcell]"));
            for (WebElement cell : cells) {
                System.out.println(cell.getText());
            }
        }
    }
}



//   @AfterAll
//    public void close(){
//       driver.quit();
//  }

