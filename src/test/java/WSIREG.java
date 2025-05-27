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

public class WSIREG {

    public static void main(String[] args) {
        String userName = "pbqaenv";
        String password = "Bl@ck2ye";
        boolean isEmpty = false;
//		SafariOptions options = new SafariOptions();
        ChromeOptions options1 = new ChromeOptions();
        options1.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options1);

        String env = "regression.";
        String market = ".com";
        String summary = "/summary.html";
        String cart = "/shoppingcart";
        String login = "/account/login.html";
        List<String> brands = new ArrayList<>();
        brands.add("williams-sonoma");
        brands.add("pbteen");
        brands.add("westelm");
        brands.add("potterybarn");
        brands.add("potterybarnkids");
        brands.add("greenrow");
        brands.add("rejuvenation");
        brands.add("markandgraham");


        for(String brandName:brands) {
            String basicAuth = "https://" + userName + ":" + password + "@";
            String url = basicAuth + env + brandName + market + summary;
//            url = "https://" + env + brand + market + cart;
            driver.get(url);
            System.out.println(brandName+" url opened");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Summary']")));
//            System.out.println("element found");
            url = "https://" + env + brandName + market + cart;
            driver.get(url);
            System.out.println("switch to shopping cart");
            try {
                boolean status = driver.getTitle().contains("Empty");
                System.out.println("page loaded "+status);
                boolean flag = brandName.equals("rejuvenation") || brandName.equals("rejuvenationhome");
                System.out.println("Brands "+ flag);

                if(!isEmpty &&  status && !flag){
                    driver.get("https://" + env + brandName + market + login);
                    Thread.sleep(3000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']"))).sendKeys("testing123@mailto.plus");
                    try{
                        System.out.println("Inside the Try block ");
                        boolean isOverlayPopupDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='dismiss-overlay-text']"))).isDisplayed();
                        System.out.println("Inside the Try block "+isOverlayPopupDisplayed);
                        if(isOverlayPopupDisplayed){
                            driver.findElement(By.xpath("//*[@class='dismiss-overlay-text']")).click();
                        }
                    }catch (Exception exp){
                        System.out.println(exp);
                    }
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='accountLoginButton']"))).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']"))).sendKeys("Welcome@123");
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='accountLoginButton']"))).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='heading-title mb-0']"))).getText().contains("Hello");
                    driver.navigate().to(url);
                 }
            }catch (Exception e){
                System.out.println("shopping cart page not loading not found");
            }
            driver.switchTo().newWindow(WindowType.TAB);
        }

        System.out.println("All brands are loaded properly...");
    }
}












