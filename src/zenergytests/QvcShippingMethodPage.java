
package zenergytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class QvcShippingMethodPage {
    WebDriver driver;
    
    QvcShippingMethodPage(WebDriver driver) {
        this.driver = driver;
    }
    public void SelectShippingMethod(String shipping) {
        Select select = new Select(driver.findElement(By.id("shipSelected11")));
        select.deselectAll();
        select.selectByValue(shipping);
    }
    public void ContinueCheckout() {
        driver.findElement(By.cssSelector("input.primaryButton")).click();
    }
}
