import configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ChairsPage;
import pages.HomePage;
import pages.SofasPage;
import utils.PropertyConfig;

import java.io.IOException;

public class AddItemsTest extends Configuration {

    HomePage homePage;
    ChairsPage chairsPage;
    SofasPage sofasPage;
    PropertyConfig propertyConfig;

    @BeforeClass
    public void beforeClass() throws IOException {

        homePage = new HomePage(driver);
        chairsPage = new ChairsPage(driver);
        sofasPage = new SofasPage(driver);
        propertyConfig = new PropertyConfig("src/main/resources/TestData.properties");
    }

    @AfterClass
    public void afterClass() {

        homePage.refreshPage();
    }

    @Test(description = "Add items to cart and check total")
    public void addItems() throws InterruptedException {

        Assert.assertEquals(driver.getTitle(), propertyConfig.getProperty("shopistTitle"), "Page title is not appropriate");
        Assert.assertTrue(homePage.isChairsLinkDisplayed(), "Chairs link is not displayed in home page");
        Assert.assertTrue(homePage.clickChairs(), "Unable to click chairs link");
        homePage.waitForChairsLink();
        Assert.assertTrue(homePage.isChairsLinkDisplayed(), "Chairs link is not displayed in chairs page");
        Assert.assertTrue(chairsPage.clickChair(), "Unable to click wicker chair link");
        String wickerChairPrice = chairsPage.getChairPrice();
        Assert.assertTrue(chairsPage.clickAddToCart(), "Unable to click add to cart");
        Assert.assertTrue(homePage.isSofasLinkDisplayed(), "Sofas link is not displayed in home page");
        Assert.assertTrue(homePage.clickSofas(), "Unable to click sofas link");
        homePage.waitForSofasLink();
        Assert.assertTrue(homePage.isSofasLinkDisplayed(), "Sofas link is not displayed in sofas page");
        Assert.assertTrue(sofasPage.clickSofa(), "Unable to click grey tufted couch link");
        String greyCouchPrice = sofasPage.getSofaPrice();
        Assert.assertTrue(sofasPage.clickAddToCart(), "Unable to click add to cart");
        Assert.assertTrue(homePage.isCartDisplayed(), "Add to cart link is not displayed in home page");
        Assert.assertTrue(homePage.clickCart(), "Unable to click cart link");
        String total = homePage.getOrderValue();
        System.out.println(wickerChairPrice+" "+greyCouchPrice+" "+total);
        String w = homePage.processPrice(wickerChairPrice);

    }
}
