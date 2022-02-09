package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.PropertyConfig;

import java.io.IOException;
import java.time.Duration;

public class Configuration {

    public WebDriver driver;
    PropertyConfig propertyConfig;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Test suite is started");
    }

    @BeforeClass @Parameters("Browser")
    public void setUp(@Optional("Chrome") String browser) {

        try {
            propertyConfig = new PropertyConfig("src/main/resources/TestData.properties");

            //  Initialize driver for Chrome browser
            if(browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", propertyConfig.getProperty("chromeDriver"));
                driver = new ChromeDriver();
            }

            driver.get(propertyConfig.getProperty("shopistURL")); //   Get base URL
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
            driver.manage().window().maximize();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Test case is started");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test case is completed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test suite is completed");
    }
}