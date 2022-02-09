package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverMethods {

    public WebDriver driver;

    public WebDriverMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public WebElement findByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement findByLinkText(String linkText) {
        return driver.findElement(By.linkText(linkText));
    }

    public WebElement findByClassName(String className) {
        return driver.findElement(By.className(className));
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean click(WebElement element) {
        try {
            element.click();
            return true;
        } catch (Exception e) {
            System.out.println("Exception in clicking element" + e);
            return false;
        }
    }

    public boolean waitForElementByXpath(String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            System.out.println("Exception in locating element" + e);
            return false;
        }
    }
}
