import java.awt.*;
import java.awt.event.KeyEvent;

public class robot {

    public static void main(String[] args) throws AWTException {
        Robot r = new Robot();
        int count = 0;
        for (int i = 0; i <= 1000; i++) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            r.keyPress(KeyEvent.VK_PAGE_DOWN);
            r.keyRelease(KeyEvent.VK_PAGE_DOWN);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r.keyPress(KeyEvent.VK_PAGE_UP);
            r.keyRelease(KeyEvent.VK_PAGE_UP);
            count++;
            System.out.println(count);
        }
    }



}
