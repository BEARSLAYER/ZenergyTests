
package zenergytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QvcPaymentMethodPage {
    
    WebDriver driver;
    
    public QvcPaymentMethodPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void CancelPurchase() {
        driver.findElement(By.id("btnReturnToOrder")).click();
        driver.findElement(By.cssSelector("input.primaryButton")).click();
    }
}
