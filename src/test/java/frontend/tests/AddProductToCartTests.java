package frontend.tests;

import frontend.enums.SortCategory;
import frontend.helpers.ProductHelper;
import frontend.helpers.RegisterHelper;
import frontend.models.User;
import frontend.pages.CheckOutPage;
import frontend.pages.DashboardPage;
import frontend.pages.HomePage;
import frontend.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(reports.ExtentTestNGListener.class)
public class AddProductToCartTests extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CheckOutPage checkOutPage;
    User user;

    @BeforeMethod
    private void setupData(){
        initializePageObjects();
        loginWithValidCredentials();
    }

    private void initializePageObjects(){
        homePage = new HomePage(elementUtilities);
        loginPage = new LoginPage(elementUtilities);
        dashboardPage = new DashboardPage(elementUtilities);
        checkOutPage = new CheckOutPage(elementUtilities);
    }

    @Test
    public void verifyThatTheUserCanAddAccessoriesToShoppingCart() throws InterruptedException {
        String productName = ProductHelper.CreateNewProduct().getProductName();
        dashboardPage.hoverOverAccessoriesMenu();
        Assert.assertTrue(dashboardPage.isAccessoriesDropDownDisplayed());
        dashboardPage.clickOnShoesCategory();
        Assert.assertEquals(elementUtilities.getPageURL(), dotenv.get("SHOES_URL"));
        dashboardPage.sortItemsBy(SortCategory.Price);
        Assert.assertTrue(areItemPricesSorted(dashboardPage.getItemPrices()));
        dashboardPage.clickOnProductByName(productName);
        Assert.assertEquals(dashboardPage.getProductName().toLowerCase(), productName.toLowerCase());
        dashboardPage.selectShoesColor();
        dashboardPage.selectShoesSize();
        Assert.assertTrue(dashboardPage.isColorSelected());
        Assert.assertTrue(dashboardPage.isSizeSelected());
        dashboardPage.clickOnAddToCartButton();
        Assert.assertTrue(checkOutPage.isSuccessMessageDisplayed());

    }

    public void loginWithValidCredentials(){
        homePage.closePrivacyPopUp();
        homePage.clickOnAccountButton();
        homePage.clickOnLoginButton();
        user = RegisterHelper.registerWithValidCredentials();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickOnSubmitButton();
    }

    public Boolean areItemPricesSorted(List<WebElement> list) {
        List<Double> prices = new ArrayList<>();
        for (WebElement element : list) {
            String priceText = element.getText().replace("$", "")
                    .replace(",", "").trim();
            prices.add(Double.parseDouble(priceText));
        }

        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        return prices.equals(sortedPrices);
    }
}
