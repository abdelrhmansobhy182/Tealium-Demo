package frontend.tests;

import frontend.factories.UserFactory;
import frontend.helpers.RegisterHelper;
import frontend.models.User;
import frontend.pages.HomePage;
import frontend.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.ExtentTestManager;

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
        ExtentTestManager.log("Entering valid email: " + user.getEmail());
        loginPage.enterEmail(user.getEmail());
        ExtentTestManager.log("Entering valid password: ");
        loginPage.enterPassword(user.getPassword());
        ExtentTestManager.log("Click on submit button");
        loginPage.clickOnSubmitButton();
        ExtentTestManager.log("Verifying that the user is navigated to the account page");
        Assert.assertEquals(dotenv.get("ACCOUNT_URL"),elementUtilities.getPageURL());
        Assert.assertTrue(loginPage.getHelloMessageText().contains(user.getFullName()));
    }

    @Test
    public void verifyThatTheUserCanNotLoginWithNonExistEmail(){
        ExtentTestManager.log("Entering non exist email: " + user.getEmail());
        loginPage.enterEmail(UserFactory.generateRandomEmail());
        ExtentTestManager.log("Entering password");
        loginPage.enterPassword(user.getPassword());
        ExtentTestManager.log("Click on submit button");
        loginPage.clickOnSubmitButton();
        ExtentTestManager.log("Verifying that the error message is displayed");
        Assert.assertTrue(loginPage.isInvalidLoginMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanNotLoginWithInValidPassword(){
        ExtentTestManager.log("Entering valid email: " + user.getEmail());
        loginPage.enterEmail(user.getEmail());
        ExtentTestManager.log("Entering invalid password");
        loginPage.enterPassword("000000");
        ExtentTestManager.log("Click on submit button");
        loginPage.clickOnSubmitButton();
        ExtentTestManager.log("Verifying that the error message is displayed");
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
