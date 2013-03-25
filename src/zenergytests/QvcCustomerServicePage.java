
package zenergytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QvcCustomerServicePage {
    
    WebDriver driver;
    
    QvcCustomerServicePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void goToSendEmail() {
        driver.findElement(By.linkText("Click here to send us an email")).click();
    }
}
