import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class utils {
    public static void scroll(WebDriver driver,String height){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+height+")");
    }

}
