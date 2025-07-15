package demoqatests;

import demoqabasetest.basetest;
import demoqapages.LinksPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinksTest extends basetest {

    @Test
    public void testAllLinks() throws InterruptedException {
        driver.get("https://demoqa.com/links");
        LinksPage linksPage = new LinksPage(driver);

        //  New Tab Links
        linksPage.clickHomeLink();
        Thread.sleep(2000);  
        
        System.out.println(" Clicked Home link");

        linksPage.clickDynamicHomeLink();
        Thread.sleep(2000);
        System.out.println(" Clicked Dynamic Home link");

        //  API Links with response validation
        testApiLink(linksPage, () -> linksPage.clickCreated(), "201");
        testApiLink(linksPage, () -> linksPage.clickNoContent(), "204");
        testApiLink(linksPage, () -> linksPage.clickMoved(), "301");
        testApiLink(linksPage, () -> linksPage.clickBadRequest(), "400");
        testApiLink(linksPage, () -> linksPage.clickUnauthorized(), "401");
        testApiLink(linksPage, () -> linksPage.clickForbidden(), "403");
        testApiLink(linksPage, () -> linksPage.clickNotFound(), "404");
    }

    // Helper method to avoid repetition
    private void testApiLink(LinksPage linksPage, Runnable clickAction, String expectedCode) throws InterruptedException {
        clickAction.run();
        Thread.sleep(2000); // Let the response load
        String response = linksPage.getLinkResponseText();
        System.out.println(" Response received: " + response);
        assertTrue(response.contains(expectedCode), " Expected response code: " + expectedCode + " not found!");
    }
}
