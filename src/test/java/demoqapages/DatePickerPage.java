package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DatePickerPage {
    WebDriver driver;

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
    }

    By dateInput = By.id("datePickerMonthYearInput");
    By dateTimeInput = By.id("dateAndTimePickerInput");

    public void setDate(String date) {
        driver.findElement(dateInput).sendKeys(Keys.CONTROL + "a", Keys.DELETE); // Clear properly
        driver.findElement(dateInput).sendKeys(date);
    }

    public String getDate() {
        return driver.findElement(dateInput).getAttribute("value");
    }

    public void setDateTime(String dateTime) {
        driver.findElement(dateTimeInput).sendKeys(Keys.CONTROL + "a", Keys.DELETE); // Clear properly
        driver.findElement(dateTimeInput).sendKeys(dateTime);
    }

    public String getDateTime() {
        return driver.findElement(dateTimeInput).getAttribute("value");
    }
}
