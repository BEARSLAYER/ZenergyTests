
package zenergytests;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

public class SeleniumVerify {
    
    WebDriver driver;
    
    private StringBuffer verificationErrors = new StringBuffer();
    
    public SeleniumVerify(WebDriver driver) {
        this.driver = driver;
    }
    
    public void VerifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        
        try {
            assertEquals(expectedTitle, actualTitle);
        } catch (Error e) {
            verificationErrors.append(e.toString());
            System.out.println("Title is \"" + actualTitle + "\" where the expected title was \"" + expectedTitle + "\"");
        }
    }
    public boolean isTextPresent(String text){
    try{
        boolean t = driver.getPageSource().contains(text);
        return t;
    }
    catch(Exception e){
        return false;
    }
  }
}