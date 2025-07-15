package demoqatests;

import demoqapages.BrowserWindowsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class BrowserWindowsTest {

    @Test
    public void testBrowserWindows() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // ✅ Allow popups
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        BrowserWindowsPage page = new BrowserWindowsPage(driver);
        String originalWindow = driver.getWindowHandle();

        //  1. NEW TAB
        page.clickNewTab();
        Thread.sleep(2000);

        Set<String> tabHandles = driver.getWindowHandles();
        for (String handle : tabHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                String content = driver.findElement(By.tagName("body")).getText();
                System.out.println(" Switched to new TAB. Content:\n" + content);
                driver.close();
            }
        }
        driver.switchTo().window(originalWindow);

        //  2. NEW WINDOW
        page.clickNewWindow();
        Thread.sleep(2000);

        Set<String> winHandles = driver.getWindowHandles();
        for (String handle : winHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                String content = driver.findElement(By.tagName("body")).getText();
                System.out.println(" Switched to new WINDOW. Content:\n" + content);
                driver.close();
            }
        }
        driver.switchTo().window(originalWindow);

        //  3. NEW MESSAGE WINDOW
        page.clickNewMessageWindow();
        Thread.sleep(2000);

        Set<String> msgHandles = driver.getWindowHandles();
        for (String handle : msgHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                String content = driver.findElement(By.tagName("body")).getText();
                System.out.println(" Switched to MESSAGE window. Content:\n" + content);
                driver.close();
            }
        }

        driver.switchTo().window(originalWindow);
        driver.quit();
    }
}
