package frontend.tests;

import frontend.factories.UserFactory;
import frontend.helpers.RegisterHelper;
import frontend.models.User;
import frontend.pages.HomePage;
import frontend.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    User user;

    @BeforeMethod
    private void setupData(){
        initializePageObjects();
        navigateToLoginPage();
        user = RegisterHelper.registerWithValidCredentials();
    }

    @Test
    public void verifyThatTheUserCanLoginWithValidCredentials() throws InterruptedException {
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickOnSubmitButton();
        Assert.assertEquals(dotenv.get("ACCOUNT_URL"),elementUtilities.getPageURL());
        //TODO Assert The user name displayed in Success Message After implement API
    }

    @Test
    public void verifyThatTheUserCanNotLoginWithNonExistEmail(){
        loginPage.enterEmail(UserFactory.generateRandomEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.isInvalidLoginMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanNotLoginWithInValidPassword(){
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword("000000");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.isInvalidLoginMessageDisplayed());
    }

    private void initializePageObjects(){
        homePage = new HomePage(elementUtilities);
        loginPage = new LoginPage(elementUtilities);
    }

    public void navigateToLoginPage(){
        homePage.closePrivacyPopUp();
        homePage.clickOnAccountButton();
        homePage.clickOnLoginButton();
    }

}
