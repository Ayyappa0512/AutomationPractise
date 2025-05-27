import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BasicAuth {

    public static void main(String[] args) throws InterruptedException, AWTException {

//        String userName = "pbqaenv";
//        String password = "Bl@ck2ye";
////		SafariOptions options = new SafariOptions();
//        ChromeOptions options1 = new ChromeOptions();
//        options1.setAcceptInsecureCerts(true);
//		WebDriver driver = new SafariDriver();
////        WebDriver driver = new ChromeDriver(options1);
//
//        driver.get("https://"+userName+":"+password+"@"+"www.qa120.williams-sonoma.com/");

        WebDriver driver = new SafariDriver();
        driver.get("https://www.qa120.pbteen.com");
        Thread.sleep(5000);

        Robot robot = new Robot();

        String username = "pbqaenv";
        for (char c : username.toCharArray()) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
            System.out.println("Key entered "+c);
        }
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        String password = "Bl@ck2ye";
        for (char c : password.toCharArray()) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}
