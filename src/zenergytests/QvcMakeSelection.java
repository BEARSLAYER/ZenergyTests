package zenergytests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

//This application will input sizes, colors, and quantities into the product description page. 
//If the page does not have one of these elements, the user simply has to send a 0 for that choice. 
public class QvcMakeSelection {

    WebDriver driver;

    public QvcMakeSelection(WebDriver driver) {
        this.driver = driver;
    }

    public void SelectItemOptions(String size, String color, String quantity) {
        //Initiates a boolean used for testing. 
        boolean present = true;
        //Tests that color was entered by user. 
        if (!(color.equalsIgnoreCase("0"))) {
            //Tries to find the color element. If does not exist, will exit code. 
            try {
                driver.findElement(By.id(color)).click();
            } catch (NoSuchElementException e) {
                //Sets boolean so code will stop. 
                present = false;
            }
        }
        //tests if user inputed a quantity. 
        if (!(quantity.equalsIgnoreCase("0"))) {
            //Testes to see if quantity option is available and selects one
            try {
                Select select = new Select(driver.findElement(By.id("selProductQuantity")));
                select.selectByVisibleText(quantity);
            } catch (NoSuchElementException e) {
                //Sets boolean so code will stop
                present = false;
            }
        }
        //Checks for user size input. 
        if (!(size.equalsIgnoreCase("0"))) {
            //tries to select a size. 
            try {
                driver.findElement(By.id(size)).click();

            } catch (NoSuchElementException e) {
                //if the element doesnt exist, will kill application. 
                present = false;
            }
        }
        //If the element did not exist, this will fall out of the application. 
        if (present = false) {
            System.err.println("Item color, quantity, or size input is not available");
            System.exit(-1);

        }
    }
}