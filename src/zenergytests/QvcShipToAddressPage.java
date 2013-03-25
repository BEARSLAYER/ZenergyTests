
package zenergytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class QvcShipToAddressPage {
    WebDriver driver;
    
    public QvcShipToAddressPage(WebDriver driver) {
        this.driver = driver;
    }
    public void EnterAlternateAddress(String firstName, String lastName, String address, String city, String state, String zip) {
        driver.findElement(By.id("tabNav-sameAsBillTo")).click();
        driver.findElement(By.id("txtFirstName")).sendKeys(firstName);
        driver.findElement(By.id("txtLastName")).sendKeys(lastName);
        driver.findElement(By.id("txtAddress1")).sendKeys(address);
        driver.findElement(By.id("txtCity")).sendKeys(city);
        new Select(driver.findElement(By.id("selStateProvince"))).selectByVisibleText(state);
        driver.findElement(By.id("txtZipPostalCode")).sendKeys(zip);
        driver.findElement(By.id("btnSubmitChanges")).click();
    }
}
