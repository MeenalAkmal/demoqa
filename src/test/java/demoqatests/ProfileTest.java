
package demoqatests;

import demoqapages.LoginPage;
import demoqapages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {

   

    @Test
    public void testLoginViaLoginPage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       //driver.get("https://demoqa.com/profile");

        driver.get("https://demoqa.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("meenal");
        loginPage.enterPassword("Abcd123!");
        loginPage.clickLogin();

        Thread.sleep(3000);  // Wait for redirect

        String currentUrl = driver.getCurrentUrl();
        String displayedUsername = driver.findElement(By.id("userName-value")).getText();

        assertEquals("https://demoqa.com/profile", currentUrl, "URL mismatch after login");
        assertEquals("meenal", displayedUsername, "Displayed username mismatch");

        System.out.println(" Login successful. Username: " + displayedUsername);
        driver.quit();
    }
}



