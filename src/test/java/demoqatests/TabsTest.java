package demoqatests;

import demoqapages.TabsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TabsTest {

    @Test
    public void testTabSwitchingAndContent() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/tabs");
        driver.manage().window().maximize();

        TabsPage tabsPage = new TabsPage(driver);

        // 1. What tab
        tabsPage.clickWhatTab();
        Thread.sleep(1500);
        String whatContent = tabsPage.getTabContent();
        System.out.println(" What tab content:\n" + whatContent);
        assertTrue(whatContent.contains("Lorem Ipsum"), "What tab content mismatch");

        // 2. Origin tab
        tabsPage.clickOriginTab();
        Thread.sleep(1500);
        String originContent = tabsPage.getTabContent();
        System.out.println(" Origin tab content:\n" + originContent);
        assertTrue(originContent.contains("Contrary to popular belief"), "Origin tab content mismatch");

        // 3. Use tab
        tabsPage.clickUseTab();
        Thread.sleep(1500);
        String useContent = tabsPage.getTabContent();
        System.out.println(" Use tab content:\n" + useContent);
        assertTrue(useContent.contains("It is a long established fact"), "Use tab content mismatch");

        driver.quit();
    }
}
