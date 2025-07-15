
package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDetailsPage {
    WebDriver driver;

    public BookDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageHeading() {
        try {
            return driver.findElement(By.cssSelector(".main-header")).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getBookTitle() {
        try {
            return driver.findElement(By.id("title-wrapper")).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
