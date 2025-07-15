package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By simpleAlertBtn = By.id("alertButton");
    By timerAlertBtn = By.id("timerAlertButton");
    By confirmAlertBtn = By.id("confirmButton");
    By promptAlertBtn = By.id("promtButton");

    // Actions
    public void clickSimpleAlert() {
        driver.findElement(simpleAlertBtn).click();
    }

    public void clickTimerAlert() {
        driver.findElement(timerAlertBtn).click();
    }

    public void clickConfirmAlert() {
        driver.findElement(confirmAlertBtn).click();
    }

    public void clickPromptAlert() {
        driver.findElement(promptAlertBtn).click();
    }
}
