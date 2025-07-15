package demoqatests;

import demoqapages.SelectMenuPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectMenuTest {

    @Test
    public void testSelectMenuOptions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();

        SelectMenuPage menuPage = new SelectMenuPage(driver);

        // Custom Select - Select Value
        menuPage.selectValueOption("Group 2, option 2");
        System.out.println(" Selected 'Group 2, option 2' from Select Value");

        // Custom Select - Select Title
        menuPage.selectTitleOption("Dr.");
        System.out.println(" Selected title 'Dr.' from Select One");

        // HTML Dropdown
        menuPage.selectOldStyleOption("Black");
        System.out.println(" Selected 'Black' from Old Style Menu");

        // Multi-select Dropdown
        menuPage.selectMultipleColors("Green", "Blue", "Black");
        System.out.println(" Selected multiple colors: Green, Blue, Black");

        Thread.sleep(2000);
        driver.quit();
    }
}
