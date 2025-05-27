import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WSI_UAT3 {

    public static void main(String[] args) {

        String userName = "pbqaenv";
        String password = "Bl@ck2ye";
//		SafariOptions options = new SafariOptions();
        ChromeOptions options1 = new ChromeOptions();
        options1.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options1);

        String env = "www.qa121.";
        String brand = "williams-sonoma";
        String market = ".ca";
        String summary = "/summary.html";
        String cart = "/shoppingcart.html";
        String basicAuth = "https://"+userName+":"+password+"@";
        String url = basicAuth+env+brand+market+summary;

        driver.get(url);
        System.out.println("new url opened");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Summary']")));
        System.out.println("element found");
        url = "https://"+env+brand+market+cart;
        driver.get(url);
        System.out.println("switch to shopping cart");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Shoppingcart']")));
        driver.switchTo().newWindow(WindowType.TAB);
        brand = "pbteen";
        driver.get(basicAuth+env+brand+market+summary);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Summary']")));
    }
}
