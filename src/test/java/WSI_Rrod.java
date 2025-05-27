import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WSI_Rrod {

    public static void main(String[] args) {

        String userName = "pbqaenv";
        String password = "Bl@ck2ye";
//		SafariOptions options = new SafariOptions();
        ChromeOptions options1 = new ChromeOptions();
        options1.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options1);

        String env = "www.uat3.";
        String market = ".ca";
        String summary = "/summary.html";
        String cart = "/shoppingcart";
        List<String> brands = new ArrayList<>();
        brands.add("williams-sonoma");
        brands.add("pbteen");
        brands.add("westelm");
        brands.add("potterybarn");
        brands.add("potterybarnkids");
        brands.add("greenrow");
        brands.add("rejuvenationhome");
        brands.add("markandgraham");

        for(String brandName:brands) {
            String brand = brandName;
            String basicAuth = "https://" + userName + ":" + password + "@";
            String url = basicAuth + env + brand + market + summary;
//            url = "https://" + env + brand + market + cart;
            driver.get(url);
            System.out.println(brandName+" url opened");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Summary']")));
//            System.out.println("element found");
            url = "https://" + env + brand + market + cart;
            driver.get(url);
            System.out.println("switch to shopping cart");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Shoppingcart']")));
            driver.switchTo().newWindow(WindowType.TAB);
        }

        System.out.println("done");
    }
}
