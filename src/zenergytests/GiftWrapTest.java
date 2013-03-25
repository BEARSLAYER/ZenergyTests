
package zenergytests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftWrapTest {
    
    WebDriver driver = new FirefoxDriver();
    private String baseUrl = "http://www.qvc.com";
    SeleniumVerify verify = new SeleniumVerify(driver);
    QvcUtilities utilities = new QvcUtilities(driver);
    
    public GiftWrapTest() { 
        driver.get(baseUrl + "/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);        
        
        //search for item F11035
        utilities.doSearch("F11035");
        
        //add item to cart 
        QvcProductDetailPage productF11035 = new QvcProductDetailPage(driver);
        verify.VerifyTitle("Southern Living: The Way To Fry Cookbook by Norman King — QVC.com");
        productF11035.AddToCart();
        QvcCartPage cartPage = new QvcCartPage(driver);
        verify.VerifyTitle("Shopping Cart");
        
        //add gift wrap
        cartPage.GoToOptions();
        QvcOptionsPage optionsPage = new QvcOptionsPage(driver);
        verify.VerifyTitle("Giftwrap Options");
        optionsPage.AddGiftWrap("You", "Me", "Enjoy!");
        verify.VerifyTitle("Shopping Cart");
        
        //navigate to checkout
        cartPage.Checkout();
        
        //redirect unpredictable; if "Your Address" page loads, redirect to Sign In page
        do {
            driver.getTitle();
        } while (driver.getTitle().isEmpty());
        if (driver.getTitle().equals("Your Address")) {
            driver.findElement(By.xpath("//form[@id='frmAlertBox']/fieldset/a")).click();
        }
        
        verify.VerifyTitle("QVC.com Sign In");
        
        //log in
        QvcLoginPage loginPage = new QvcLoginPage(driver);
        loginPage.LogIn("jbcook1984@gmail.com", "1984");
        
        //enter alternate addrss and shipping method
        QvcShipToAddressPage shipToAddressPage = new QvcShipToAddressPage(driver);
        verify.VerifyTitle("Ship-To Address");
        shipToAddressPage.EnterAlternateAddress("Big", "Bird", "6015 Tamannary Dr", "Greensboro", "North Carolina", "27455");
        QvcShippingMethodPage shippingPage = new QvcShippingMethodPage(driver);
        shippingPage.ContinueCheckout();
                
        //cancel purchase and clean up
        QvcPaymentMethodPage paymentPage = new QvcPaymentMethodPage(driver);
        paymentPage.CancelPurchase();
        utilities.LogOut();
        
        driver.close();
    }
    
}