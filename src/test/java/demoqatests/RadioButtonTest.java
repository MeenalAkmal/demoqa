
package demoqatests;

import demoqabasetest.basetest;
import demoqapages.RadioButtonPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioButtonTest extends basetest {

	@Test
	public void testBothRadioButtons() throws InterruptedException {
	    driver.get("https://demoqa.com/radio-button");

	    RadioButtonPage radioPage = new RadioButtonPage(driver);

	    // Test Yes radio
	    radioPage.selectYes();
	    Thread.sleep(1000);
	    String result1 = radioPage.getResultText();
	    System.out.println(" Selected Radio: " + result1);
	    assertEquals("Yes", result1, " Expected 'Yes'");

	    // Test Impressive radio
	    radioPage.selectImpressive();
	    Thread.sleep(1000);
	    String result2 = radioPage.getResultText();
	    System.out.println(" Selected Radio: " + result2);
	    assertEquals("Impressive", result2, " Expected 'Impressive'");
    }
}
