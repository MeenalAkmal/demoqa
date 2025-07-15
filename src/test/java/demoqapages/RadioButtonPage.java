package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage {
    private WebDriver driver;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By yesRadio = By.cssSelector("label[for='yesRadio']");
    private By impressiveRadio = By.cssSelector("label[for='impressiveRadio']");
    private By resultText = By.className("text-success");

    // Actions
    public void selectYes() {
        driver.findElement(yesRadio).click();
    }

    public void selectImpressive() {
        driver.findElement(impressiveRadio).click();
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }
}
