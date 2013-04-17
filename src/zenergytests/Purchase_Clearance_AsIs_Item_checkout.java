package zenergytests;

//all import statements
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Eric Test Objective: Use the clearance items list to buy an as is
 * item. Pre Condition: User starts at the home page. There are no items in the
 * shopping cart. Data Consideration: User will purchase a quantity of 1…color
 * and size can be selected freely
 */
public class Purchase_Clearance_AsIs_Item_checkout {

    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private String baseUrl = "http://www.qvc.com/";
    QvcLoginPage login = new QvcLoginPage(driver);
    QvcUtilities utilities = new QvcUtilities(driver);
    SeleniumVerify verify = new SeleniumVerify(driver);
    QvcMakeSelection select = new QvcMakeSelection(driver);

    public Purchase_Clearance_AsIs_Item_checkout() {
        //Start on homepage, sign in, standard start for tests
        driver.get(baseUrl);
        utilities.popUp();
        utilities.goToSignIn();
        verify.VerifyTitle("QVC.com Sign In");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtEmailAddress")));
        login.LogIn("Ejandre2@uncg.edu", "0531");
        verify.VerifyTitle("My Account");
        
        //select "as is" from "clearance" from dropdown menu on navigation bar
        utilities.navigateTo("Clearance", "As Is Products");
        //verify.VerifyTitle("As Is - Clearance - QVC.com");
        verify.VerifyTitle("As Is - Clearance - QVC.com");
        //select first item on clearance page
        utilities.clickFirstItem();
        //Select the size, color, and type of item respectively and choose a quantity of 1
        select.SelectItemOptions("301", "012", "1");
        
        //The user will click the checkout button underneath the product options
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("primaryButton")));
        utilities.AddToCart();
        //Verification of the “Acknowledgment” word on the page
        //verify.VerifyTitle("Acknowledgement");
        //User will select “yes” to confirm that they are aware they are purchasing an as it product
        utilities.Acknowledgement();
        //The user will click the remove link under their product choice to remove it from the shopping cart
        utilities.removeFromCart();
        //Verify text “There are no items in your Shopping Cart”
        verify.isTextPresent("There are no items in your Shopping Cart");
        //Click the “Back to Homepage” link located above the empty shopping cart text
        utilities.goToHomepage();

        driver.close();
    }
}

