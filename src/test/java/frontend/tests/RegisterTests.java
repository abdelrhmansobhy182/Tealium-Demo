package frontend.tests;

import frontend.Factories.UserFactory;
import frontend.pages.HomePage;
import frontend.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest{

    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod
    private void setupData(){
        initializePageObjects();
        navigateToRegisterPage();
    }

    @Test
    public void verifyThatTheUserCanRegisterWithValidCredentials() {
        String password = UserFactory.generateRandomPassword();
        registerPage.enterFirstName(UserFactory.generateRandomName());
        registerPage.enterMiddleName(UserFactory.generateRandomName());
        registerPage.enterLastName(UserFactory.generateRandomName());
        registerPage.enterEmail(UserFactory.generateRandomEmail());
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.markRememberMeCheckbox();
        registerPage.markNewsletterCheckbox();
        registerPage.clickOnSubmitButton();
        Assert.assertTrue(registerPage.isRegistrationSuccessMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanRegisterWithoutTheMiddleName() {
        String password = UserFactory.generateRandomPassword();
        registerPage.enterFirstName(UserFactory.generateRandomName());
        registerPage.enterLastName(UserFactory.generateRandomName());
        registerPage.enterEmail(UserFactory.generateRandomEmail());
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.markRememberMeCheckbox();
        registerPage.markNewsletterCheckbox();
        registerPage.clickOnSubmitButton();
        Assert.assertTrue(registerPage.isRegistrationSuccessMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanRegisterWithoutMarkRememberMeCheckBox() {
        String password = UserFactory.generateRandomPassword();
        registerPage.enterFirstName(UserFactory.generateRandomName());
        registerPage.enterMiddleName(UserFactory.generateRandomName());
        registerPage.enterLastName(UserFactory.generateRandomName());
        registerPage.enterEmail(UserFactory.generateRandomEmail());
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.markNewsletterCheckbox();
        registerPage.clickOnSubmitButton();
        Assert.assertTrue(registerPage.isRegistrationSuccessMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanRegisterWithoutMarkNewsletterCheckbox() {
        String password = UserFactory.generateRandomPassword();
        registerPage.enterFirstName(UserFactory.generateRandomName());
        registerPage.enterMiddleName(UserFactory.generateRandomName());
        registerPage.enterLastName(UserFactory.generateRandomName());
        registerPage.enterEmail(UserFactory.generateRandomEmail());
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.markRememberMeCheckbox();
        registerPage.clickOnSubmitButton();
        Assert.assertTrue(registerPage.isRegistrationSuccessMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanNotRegisterWithoutTheFirstName() {
        String password = UserFactory.generateRandomPassword();
        registerPage.enterLastName(UserFactory.generateRandomName());
        registerPage.enterEmail(UserFactory.generateRandomEmail());
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickOnSubmitButton();
        Assert.assertTrue(registerPage.isFirstNameErrorMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanNotRegisterWithoutTheLastName() {
        String password = UserFactory.generateRandomPassword();
        registerPage.enterFirstName(UserFactory.generateRandomName());
        registerPage.enterEmail(UserFactory.generateRandomEmail());
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickOnSubmitButton();
        Assert.assertTrue(registerPage.isLastNameErrorMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanNotRegisterWithoutTheEmail() {
        String password = UserFactory.generateRandomPassword();
        registerPage.enterFirstName(UserFactory.generateRandomName());
        registerPage.enterLastName(UserFactory.generateRandomName());
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickOnSubmitButton();
        Assert.assertTrue(registerPage.isEmailErrorMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanNotRegisterWithoutPassword() {
        String password = UserFactory.generateRandomPassword();
        registerPage.enterFirstName(UserFactory.generateRandomName());
        registerPage.enterLastName(UserFactory.generateRandomName());
        registerPage.enterEmail(UserFactory.generateRandomEmail());
        registerPage.enterConfirmPassword(password);
        registerPage.clickOnSubmitButton();
        Assert.assertTrue(registerPage.isPasswordErrorMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanNotRegisterWithoutConfirmPassword() {
        String password = UserFactory.generateRandomPassword();
        registerPage.enterFirstName(UserFactory.generateRandomName());
        registerPage.enterLastName(UserFactory.generateRandomName());
        registerPage.enterEmail(UserFactory.generateRandomEmail());
        registerPage.enterPassword(password);
        registerPage.clickOnSubmitButton();
        Assert.assertTrue(registerPage.isConfirmPasswordErrorMessageDisplayed());
    }

    @Test
    public void verifyThatTheUserCanNotRegisterWhenPasswordAndConfirmPasswordDoNotMatch() {
        String password = UserFactory.generateRandomPassword();
        registerPage.enterFirstName(UserFactory.generateRandomName());
        registerPage.enterLastName(UserFactory.generateRandomName());
        registerPage.enterEmail(UserFactory.generateRandomEmail());
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(UserFactory.generateRandomPassword());
        registerPage.clickOnSubmitButton();
        Assert.assertTrue(registerPage.isConfirmPasswordMismatchErrorMessageDisplayed());
    }




    private void initializePageObjects(){
        homePage = new HomePage(elementUtilities);
        registerPage = new RegisterPage(elementUtilities);
    }

    public void navigateToRegisterPage(){
        homePage.closePrivacyPopUp();
        homePage.clickOnAccountButton();
        homePage.clickOnRegisterButton();
    }
}
