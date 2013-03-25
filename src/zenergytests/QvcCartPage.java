
package zenergytests;
    
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QvcCartPage {
    
    WebDriver driver;
    
    public QvcCartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void Checkout() {
        driver.findElement(By.cssSelector("input.primaryButton.buttonAlignVertical")).click();
    }
    public void RemoveItem() {
        driver.findElement(By.xpath("//input[@value='Remove']")).click();
    }
    public void GoToOptions() {
        driver.findElement(By.linkText("Options")).click();
    }    
}
