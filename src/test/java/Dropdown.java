import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class Dropdown {

    public static void main(String[] args) throws InterruptedException {

         WebDriver driver  = new ChromeDriver();

        driver.get("https://www.irctc.co.in/nget/train-search");

        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.alertIsPresent());

//        driver.switchTo().alert().accept();

        By ele = By.xpath("//*[@id='origin']/span/input");
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
        search.sendKeys("Chennai");

        List<WebElement>  items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='pr_id_1_list']/li")));

        for (WebElement item: items) {
            System.out.println(item.getText());
            if(item.getText().contains("CHENNAI EGMORE")){item.click();break;}
        }

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='pr_id_1_list']/li")));
    }
}
