package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNotLoggedInMessage() {
        return driver.findElement(By.id("notLoggin")).getText();
    }

    public void clickLoginButton() {
        driver.findElement(By.id("login")).click();
    }
}

