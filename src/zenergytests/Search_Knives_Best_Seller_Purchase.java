package zenergytests;

//all import statements
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Eric Test Objective: Verify the validity of search results by
 * searching for and buying a best sellers knife. Pre Condition: User starts at
 * the home page. There are no items in the shopping cart. Data Consideration:
 * The search text is “knives” User will purchase a quantity of 2…color and size
 * can be selected freely
 */
public class Search_Knives_Best_Seller_Purchase {

    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private String baseUrl = "http://www.qvc.com/";
    QvcUtilities utilities = new QvcUtilities(driver);
    SeleniumVerify verify = new SeleniumVerify(driver);
    QvcMakeSelection select = new QvcMakeSelection(driver);

    public Search_Knives_Best_Seller_Purchase() {
        //Start on homepage, sign in, standard start for tests
        driver.get(baseUrl);
        utilities.popUp();
        utilities.goToSignIn();
        verify.VerifyTitle("QVC.com Sign In");
        QvcLoginPage login = new QvcLoginPage(driver);
        login.LogIn("Ejandre2@uncg.edu", "0531");
        verify.VerifyTitle("My Account");
        
        //search for "knives"
        utilities.doSearch("knives");
        //verify "knives" were searched for
        verify.isTextPresent("knives");
        //select first knife from list of "best sellers", checkbox will go to best seller list
        utilities.selectCheckBox_BS();
        utilities.clickFirstItem();
        //The user will select a quantity of 2 for the item, and make any other necessary product options of their own choice.
        select.SelectItemOptions("0", "012", "1");
        //The user will click the checkout button underneath the product options
        utilities.AddToCart();
        //Verify “Shopping Cart” text on page, ad visually verify your product and option to make sure the right item is in the cart
        verify.VerifyTitle("Shopping Cart");
        //The user will click the remove link under their product choice to remove it from the shopping cart
        utilities.removeFromCart();
        //Verify text “There are no items in your Shopping Cart”
        verify.isTextPresent("There are no items in your Shopping Cart");
        //Click the “Back to Homepage” link located above the empty shopping cart text
        utilities.goToHomepage();
        
        driver.close();
    }
}
