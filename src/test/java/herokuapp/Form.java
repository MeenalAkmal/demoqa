package herokuapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Form extends BaseTest {

    @Test
    public void testValidLogin() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");

        // Enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        // Enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        // Click Login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Small wait to let page load
        Thread.sleep(2000);

        //  Check if redirected to secure area
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/secure"), "User should be redirected to secure area after login");

        // Check success message is displayed
        WebElement flash = driver.findElement(By.id("flash"));
        assertTrue(flash.getText().contains("You logged into a secure area!"), "Success message should be visible");
    }
}
