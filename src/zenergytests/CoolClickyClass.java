
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class demonstrates how to emulate the "mouseover" event. This
 * functionality allows you to interact with AJAX dropdowns
 *
 * @author javier l. velasquez
 *
 */
public class CoolClickyClass {

    WebDriver driver;
    Actions builder;

    /**
     * @param args
     */
    /**
     * This constructor requires a driver, and a starting url to initialize the
     * state of the CoolClickyClass
     *
     * @param driver - a Webdriver Object
     * @param url - the starting url;
     */
    CoolClickyClass(WebDriver driver, String url) {
        this.driver = driver;
        builder = new Actions(driver);
        driver.get(url);
    }

    /**
     * This is our driver method that controls the executation of the
     * application;
     */
    public void go() {
        // Navigate to Clearance -> As Is Products
        navigateTo("Clearance", "As Is Products");
        driver.close(); // Close the WebDriver
    }

    /**
     * Allows us to navigate submenues from the main navigation
     *
     * @param mainMenuName - a string value representing a node on the main
     * navigation bar
     * @param subMenuName - a string value representing the sub menu.
     */
    public void navigateTo(String mainMenuName, String subMenuName) {
        WebElement mainElement = driver.findElement(By.linkText(mainMenuName));

        if (subMenuName != null) {
            // The magic happens here
            this.builder.moveToElement(mainElement).perform(); // <--- MAGIC
            // 6 is a default value adjust as needed
            WebElement subMenuElement = elementThatExists(driver, By.linkText(subMenuName), 6);
            subMenuElement.click();
        } else {
            mainElement.click();
        }
    }

    /**
     * Allows us to navigate the main navigation
     *
     * @param mainMenuName - a string value representing a node on the main
     * navigation bar
     */
    public void navigateTo(String mainMenuName) {
        this.navigateTo(mainMenuName, null);
    }

    /**
     * This is a static utility method that returns an element only after it
     * exists after a certain wait time
     *
     * @param driver - the driver we are interacting with
     * @param by - The element description
     * @param waitTime - how long we are willing to wait
     * @return - a WebElement representing the object we are looking for
     */
    public static WebElement elementThatExists(WebDriver driver, By by, Integer waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }
}