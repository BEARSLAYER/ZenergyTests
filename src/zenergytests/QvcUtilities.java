package zenergytests;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QvcUtilities {

    WebDriver driver;
    Actions builder;

    public QvcUtilities(WebDriver driver) {
        this.driver = driver;
        builder = new Actions(driver);
    }
    
    public void AddToCart() {        
        driver.findElement(By.cssSelector("input.primaryButton.btnAddToCart")).click();
    }
    
    public void popUp() {
        try {
            driver.findElement(By.id("TB_closeWindowButton")).click();
        } catch (NoSuchElementException e) {
        }
    }
    public void Checkout() {
        driver.findElement(By.cssSelector("input.primaryButton.buttonAlignVertical")).click();
    }
    public void RemoveItem() {
        driver.findElement(By.xpath("//input[@value='Remove']")).click();
    }
    public void GoToOptions() {
        driver.findElement(By.linkText("Options")).click();
    }    
    public void doSearch(String search) {
        driver.findElement(By.id("txtMastheadSearch")).sendKeys(search);
        driver.findElement(By.id("btnMastheadSearch")).click();
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert");
        }
    }

    public void selectCheckBox_BS() {
        driver.findElement(By.xpath("//input[@id='cbTop_Finds1']")).click();
    }

    public void clickFirstItem() {
        try {
            driver.findElement(By.xpath("//form[@id='frmProductList']/div[4]/div[3]/div/span/div/div/a/img")).click();
        } catch (NoSuchElementException e) {
        }
        try {
            driver.findElement(By.xpath("//form[@id='frmProductList']/div[4]/div[5]/div/span/div/div/a/img")).click();
        } catch (NoSuchElementException e) {
        }
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

    public void Acknowledgement() {
        driver.findElement(By.xpath("//input[@value='Yes']")).click();
    }

    public void removeFromCart() {
        driver.findElement(By.cssSelector("input.secondaryButton")).click();
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