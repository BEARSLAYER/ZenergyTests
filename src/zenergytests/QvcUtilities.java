
package zenergytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class QvcUtilities {
    WebDriver driver;
    
    public QvcUtilities(WebDriver driver) {
        this.driver = driver;
    }
    
    public void doSearch(String search) {
        driver.findElement(By.id("txtMastheadSearch")).sendKeys(search);
        driver.findElement(By.id("btnMastheadSearch")).click();
    }
    
    public void clickFirstItem(){
        driver.findElement(By.xpath("//div[@class='divProduct']")).click();
    }
    
    public void goToHomepage() {
        driver.findElement(By.xpath("//div[@id='divMastheadLogo']/a/img")).click();
    }
    
    public void goToSignIn() {
        driver.findElement(By.linkText("Register (Sign In)")).click();
    }
    
    public void LogOut() {
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
    }
    
    public void goToCustomerService() {
        driver.findElement(By.xpath("//a[@href='http://www.qvc.com/Customer+Service.content.html']")).click();
    }
    public void goToClearance() {
        driver.findElement(By.xpath("//a[@href='http://www.qvc.com/Clearance.content.html']")).click();
    }
    public void sendCustomerServiceEmail(String rb, String fn, String ln, String email, String memberNum, String productNum, String category, String message) {
        driver.findElement(By.id(rb)).click();
        driver.findElement(By.id("txtFirstName")).sendKeys(fn);
        driver.findElement(By.id("txtLastName")).sendKeys(ln);
        driver.findElement(By.id("txtEmailAddress")).sendKeys(email);
        driver.findElement(By.id("txtMemberNumber")).sendKeys(memberNum);
        driver.findElement(By.id("txtItemNumber")).sendKeys(productNum);
        new Select(driver.findElement(By.id("selProductCategory"))).selectByVisibleText(category);
        driver.findElement(By.id("taYourMessage")).sendKeys(message);
    }
}