package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyConfig;
import utils.WebDriverMethods;

import java.io.IOException;

public class HomePage extends WebDriverMethods {

        PropertyConfig propertyConfig = new PropertyConfig("src/main/resources/TestData.properties");

        public HomePage(WebDriver driver) throws IOException {
            super(driver);
        }

        public boolean isChairsLinkDisplayed() {
            WebElement element = findByXpath(propertyConfig.getProperty("chairsXpath"));
            return isDisplayed(element);
        }

        public boolean clickChairs() {
            WebElement element = findByXpath(propertyConfig.getProperty("chairsXpath"));
            return click(element);
        }

        public void waitForChairsLink() {
            waitForElementByXpath(propertyConfig.getProperty("chairsXpath"));
        }

        public boolean isSofasLinkDisplayed() {
            WebElement element = findByXpath(propertyConfig.getProperty("sofasXpath"));
            return isDisplayed(element);
        }

        public boolean clickSofas() {
            WebElement element = findByXpath(propertyConfig.getProperty("sofasXpath"));
            return click(element);
        }

        public void waitForSofasLink() {
            waitForElementByXpath(propertyConfig.getProperty("sofasXpath"));
        }

        public boolean isCartDisplayed() {
            WebElement element = findByXpath(propertyConfig.getProperty("cartXpath"));
            return isDisplayed(element);
        }

        public boolean clickCart() {
            WebElement element = findByXpath(propertyConfig.getProperty("cartXpath"));
            return click(element);
        }

        public String getOrderValue() {
            WebElement element = findByXpath(propertyConfig.getProperty("orderValueXpath"));
            String price = element.getText();
            return price;
        }

        public String processPrice(String price) {
            String p = price.replace("$","");
            System.out.println(Double.parseDouble(p));
            return p;
        }

        public void refreshPage() {
            refresh();
        }
}
