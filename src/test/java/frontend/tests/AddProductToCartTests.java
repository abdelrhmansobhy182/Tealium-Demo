package frontend.tests;

import frontend.enums.SortCategory;
import frontend.helpers.ProductHelper;
import frontend.helpers.RegisterHelper;
import frontend.models.User;
import frontend.pages.CheckOutPage;
import frontend.pages.product.AccessoriesPage;
import frontend.pages.product.DashboardPage;
import frontend.pages.HomePage;
import frontend.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToCartTests extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AccessoriesPage accessoriesPage;
    CheckOutPage checkOutPage;
    User user;

    @BeforeMethod
    private void setupData(){
        initializePageObjects();
        loginWithValidCredentials();
    }

    @Test
    public void verifyThatTheUserCanAddAccessoriesToShoppingCart() throws InterruptedException {
        String productName = ProductHelper.CreateNewProduct().getProductName();
        dashboardPage.hoverOverAccessoriesMenu();
        Assert.assertTrue(dashboardPage.isAccessoriesDropDownDisplayed());
        dashboardPage.clickOnShoesCategory();
        Assert.assertEquals(elementUtilities.getPageURL(), dotenv.get("SHOES_URL"));
        dashboardPage.sortItemsBy(SortCategory.Price);
        Assert.assertTrue(dashboardPage.areItemPricesSorted(accessoriesPage.getItemPrices()));
        dashboardPage.clickOnProductByName(productName);
        Assert.assertEquals(accessoriesPage.getProductName().toLowerCase(), productName.toLowerCase());
        accessoriesPage.selectShoesColor();
        accessoriesPage.selectShoesSize();
        Assert.assertTrue(accessoriesPage.isColorSelected());
        Assert.assertTrue(accessoriesPage.isSizeSelected());
        accessoriesPage.clickOnAddToCartButton();
        Assert.assertTrue(checkOutPage.isSuccessMessageDisplayed());

    }

    private void initializePageObjects(){
        homePage = new HomePage(elementUtilities);
        loginPage = new LoginPage(elementUtilities);
        dashboardPage = new DashboardPage(elementUtilities);
        accessoriesPage = new AccessoriesPage(elementUtilities);
        checkOutPage = new CheckOutPage(elementUtilities);
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


}
