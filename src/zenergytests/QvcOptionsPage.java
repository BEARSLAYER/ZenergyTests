
package zenergytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QvcOptionsPage {
    
    WebDriver driver;
    
    public QvcOptionsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void AddGiftWrap(String sender, String reciever, String message) {
        driver.findElement(By.id("rbGiftWrapGiftWrap")).click();
        driver.findElement(By.id("txtGiftWrapOptionsTo")).sendKeys(reciever);
        driver.findElement(By.id("txtGiftWrapOptionsMessage")).sendKeys(message);
        driver.findElement(By.id("txtGiftWrapOptionsFrom")).sendKeys(sender);
        driver.findElement(By.cssSelector("#divFormButtons > input.primaryButton")).click();
    }
}