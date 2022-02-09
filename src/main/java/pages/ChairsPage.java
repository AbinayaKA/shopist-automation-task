package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyConfig;
import utils.WebDriverMethods;

import java.io.IOException;

public class ChairsPage extends WebDriverMethods {

        PropertyConfig propertyConfig = new PropertyConfig("src/main/resources/TestData.properties");

        public ChairsPage(WebDriver driver) throws IOException {
            super(driver);
        }

        public boolean clickChair() {
            WebElement element = findByXpath(propertyConfig.getProperty("wickerChairXpath"));
            return click(element);
        }

        public String getChairPrice() {
            WebElement element = findByClassName(propertyConfig.getProperty("priceClassName"));
            String price = element.getText();
            return price;
        }

        public boolean clickAddToCart() {
            WebElement element = findByXpath(propertyConfig.getProperty("addToCartXpath"));
            return click(element);
        }

}
