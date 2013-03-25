/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zenergytests;

//all import statements

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author Eric
 * Test Objective: Use the clearance items list to buy an as is item.
Pre Condition: User starts at the home page. There are no items in the shopping cart.
Data Consideration: User will purchase a quantity of 1…color and size can be selected freely
 */
public class Purchase_Clearance_AsIs_Item_checkout {
    
    WebDriver driver = new FirefoxDriver();
    private String baseUrl = "http://www.qvc.com/";
    QvcUtilities utilities = new QvcUtilities(driver);
    SeleniumVerify verify = new SeleniumVerify(driver);
    
    public Purchase_Clearance_AsIs_Item_checkout(){
       //Start on homepage
        driver.get(baseUrl);
       //sign in
        utilities.goToSignIn();
        verify.VerifyTitle("QVC.com Sign In");
        QvcLoginPage login = new QvcLoginPage(driver);
        login.LogIn("Ejandre2@uncg.edu", "0531");
        verify.VerifyTitle("My Account");
       //select "as is" from "clearance" from dropdown menu on navigation bar
        utilities.goToClearance();
        //verify.VerifyTitle("As Is - Clearance - QVC.com");
        
       //select first item on clearance page
        utilities.clickFirstItem();
        
    }
}
