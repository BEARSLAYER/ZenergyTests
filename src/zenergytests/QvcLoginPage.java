
package zenergytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QvcLoginPage {
    WebDriver driver;
    
    public QvcLoginPage(WebDriver driver) {
        this.driver = driver;
        
    }
    public void LogIn(String login, String password) {
        driver.findElement(By.id("txtEmailAddress")).clear();
        driver.findElement(By.id("txtEmailAddress")).sendKeys(login);
        driver.findElement(By.id("txtPin")).clear();
        driver.findElement(By.id("txtPin")).sendKeys(password);
        driver.findElement(By.id("btnSignIn")).click();
    }
}
