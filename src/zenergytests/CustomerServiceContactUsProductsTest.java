
package zenergytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomerServiceContactUsProductsTest {
    WebDriver driver = new FirefoxDriver();
    private String baseUrl = "http://www.qvc.com/";
    QvcUtilities utilities = new QvcUtilities(driver);
    SeleniumVerify verify = new SeleniumVerify(driver);
    
    public CustomerServiceContactUsProductsTest() {
        //Step 1: Begin at homepage
        driver.get(baseUrl);
        
        //Step 2: Go to sign in page
        utilities.goToSignIn();
        verify.VerifyTitle("QVC.com Sign In");
        
        //Step 3: Sign in
        QvcLoginPage login = new QvcLoginPage(driver);
        login.LogIn("jbcook1984@gmail.com", "1984");
        verify.VerifyTitle("My Account");
        
        //Setep 4: click "visit customer service" link
        utilities.goToCustomerService();
        verify.VerifyTitle("Customer Service — QVC.com");
        
        //Step 5: click "click here to send us an email" link
        QvcCustomerServicePage customerService = new QvcCustomerServicePage(driver);
        customerService.goToSendEmail();
        
        //Steps 6-8
        utilities.sendCustomerServiceEmail("rbProducts", "Test", "Test", "thebestqvctests2@gmail.com", "1111", "1111", "Electronics", "Test");
        
        //Step 9
        utilities.LogOut();
    
        //Step 10
        utilities.goToHomepage();
       
        driver.close();
    }
}
