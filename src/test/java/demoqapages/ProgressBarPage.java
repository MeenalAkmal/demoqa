package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProgressBarPage {
    WebDriver driver;

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
    }

    private By startStopButton = By.id("startStopButton");
    private By progressBarText = By.cssSelector("div.progress-bar");

    public void clickStartButton() {
        driver.findElement(startStopButton).click();
    }

    public String getProgressBarText() {
        WebElement progress = driver.findElement(progressBarText);
        return progress.getText().trim(); // e.g. "66%"
    }

    public String getStartButtonText() {
        return driver.findElement(startStopButton).getText().trim();
    }
}
