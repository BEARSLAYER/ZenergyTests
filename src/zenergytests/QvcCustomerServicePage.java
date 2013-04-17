package zenergytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class QvcCustomerServicePage {

    WebDriver driver;

    QvcCustomerServicePage(WebDriver driver) {
        this.driver = driver;
    }

    public void AddGiftWrap(String sender, String reciever, String message) {
        driver.findElement(By.id("rbGiftWrapGiftWrap")).click();
        driver.findElement(By.id("txtGiftWrapOptionsTo")).sendKeys(reciever);
        driver.findElement(By.id("txtGiftWrapOptionsMessage")).sendKeys(message);
        driver.findElement(By.id("txtGiftWrapOptionsFrom")).sendKeys(sender);
        driver.findElement(By.cssSelector("#divFormButtons > input.primaryButton")).click();
    }

    public void goToSendEmail() {
        driver.findElement(By.linkText("Click here to send us an email")).click();
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
    public void SelectShippingMethod(String shipping) {
        Select select = new Select(driver.findElement(By.id("shipSelected11")));
        select.deselectAll();
        select.selectByValue(shipping);
    }
    public void ContinueCheckout() {
        driver.findElement(By.cssSelector("input.primaryButton")).click();
    }
    public void CancelPurchase() {
        driver.findElement(By.id("btnReturnToOrder")).click();
        driver.findElement(By.cssSelector("input.primaryButton")).click();
    }
}
