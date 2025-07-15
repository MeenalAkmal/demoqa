
package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadAndDownloadPage {
    private WebDriver driver;

    public UploadAndDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By downloadButton = By.id("downloadButton");
    private By uploadInput = By.id("uploadFile");
    private By uploadedFilePath = By.id("uploadedFilePath");

    // Actions
    public void clickDownloadButton() {
        driver.findElement(downloadButton).click();
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadInput).sendKeys(filePath);
    }

    public String getUploadedFilePath() {
        return driver.findElement(uploadedFilePath).getText();
    }
}

