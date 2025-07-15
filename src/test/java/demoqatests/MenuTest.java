package demoqatests;

import demoqabasetest.basetest;
import demoqapages.MenuPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest extends basetest {

    @Test
    public void testMenuHover() throws InterruptedException {
        driver.get("https://demoqa.com/menu");
        MenuPage menuPage = new MenuPage(driver);
        Actions actions = new Actions(driver);

        // Hover Main Item 2
        actions.moveToElement(menuPage.getMainItem2()).perform();
        Thread.sleep(1000);
        System.out.println(" Hovered on Main Item 2");

        // Hover Sub Sub List
        actions.moveToElement(menuPage.getSubSubList()).perform();
        Thread.sleep(1000);
        System.out.println(" Hovered on SUB SUB LIST");

        // Verify Sub Sub Item 2 is displayed
        boolean isVisible = menuPage.getSubSubItem2().isDisplayed();
        System.out.println("Sub Sub Item 2 is visible: " + isVisible);
        assertTrue(isVisible, "Sub Sub Item 2 should be visible");

        System.out.println(" Menu hover test passed!");
    }
}
