
package zenergytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QvcProductDetailPage {
    
    WebDriver driver;
    
    public QvcProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }
    public void AddToCart() {
        driver.findElement(By.cssSelector("input.primaryButton.btnAddToCart")).click();
    }
}
