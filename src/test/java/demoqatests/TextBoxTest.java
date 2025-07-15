package demoqatests;

import demoqabasetest.basetest;
import demoqapages.TextBoxPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextBoxTest extends basetest {

    @Test
    public void testTextBoxForm() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");

        TextBoxPage textBoxPage = new TextBoxPage(driver);

        // Fill form
        textBoxPage.enterFullName("Meenal Akmal");
        textBoxPage.enterEmail("teamworkmeenal@gmail.com");
        textBoxPage.enterCurrentAddress("Lahore, Pakistan");
        textBoxPage.enterPermanentAddress("Lahore");

        // Submit
        textBoxPage.clickSubmit();
        Thread.sleep(2000); 

        // Get output
        String output = textBoxPage.getOutputText();

        assertTrue(output.contains("Meenal Akmal"), "Name not found in output!");
        assertTrue(output.contains("teamworkmeenal@gmail.com"), "Email not found in output!");
        assertTrue(output.contains("Lahore, Pakistan"), "Current address not found in output!");
        assertTrue(output.contains("Permananet Address :Lahore"), "Permanent address not found in output!");

        System.out.println("Form submitted successfully!");
        System.out.println("Output was:\n" + output);


        Thread.sleep(2000); // for visibility
    }
}
