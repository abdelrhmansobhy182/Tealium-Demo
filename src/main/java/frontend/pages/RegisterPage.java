package frontend.pages;

import frontend.utilities.ElementUtilities;
import org.openqa.selenium.By;

public class RegisterPage {

    private final ElementUtilities elementUtilities;
    private final By firstnameField = By.id("firstname");
    private final By middleNameField = By.id("middlename");
    private final By lastNameField = By.id("lastname");
    private final By emailAddressField = By.id("email_address");
    private final By passwordField = By.id("password");
    private final By confirmationPasswordField = By.id("confirmation");
    private final By newsLetterCheckBox = By.id("is_subscribed");
    private final By rememberMeCheckBox = By.name("persistent_remember_me");
    private final By submitButton = By.cssSelector("button[title='Register']");
    private final By registrationSuccessMessage = By.cssSelector("li.success-msg span");

    //Error messages
    private final By firstnameErrorMessage = By.id("advice-required-entry-firstname");
    private final By lastnameErrorMessage = By.id("advice-required-entry-lastname");
    private final By emailAddressErrorMessage = By.id("advice-required-entry-email_address");
    private final By passwordErrorMessage = By.id("advice-required-entry-password");
    private final By confirmationPasswordErrorMessage = By.id("advice-required-entry-confirmation");
    private final By confirmPasswordMismatchError = By.id("advice-validate-cpassword-confirmation");

    public RegisterPage(ElementUtilities elementUtilities) {
        this.elementUtilities = elementUtilities;
    }

    public void clickOnSubmitButton(){
        elementUtilities.scrollToElement(submitButton);
        elementUtilities.clickElement(submitButton);
    }
    public void enterFirstName(String firstName){
        elementUtilities.typeText(firstnameField,firstName);
    }
    public void enterMiddleName(String middleName){
        elementUtilities.typeText(middleNameField,middleName);
    }
    public void enterLastName(String lastName){
        elementUtilities.typeText(lastNameField,lastName);
    }
    public void enterEmail(String email){
        elementUtilities.typeText(emailAddressField,email);
    }
    public void enterPassword(String password){
        elementUtilities.typeText(passwordField,password);
    }
    public void enterConfirmPassword(String confirmPassword){
        elementUtilities.typeText(confirmationPasswordField,confirmPassword);
    }
    public void markNewsletterCheckbox(){
        elementUtilities.scrollToElement(newsLetterCheckBox);
        elementUtilities.checkBox(newsLetterCheckBox);
    }
    public void markRememberMeCheckbox(){
        elementUtilities.scrollToElement(rememberMeCheckBox);
        elementUtilities.checkBox(rememberMeCheckBox);
    }

    // Messages Assertion
    public Boolean isRegistrationSuccessMessageDisplayed(){
        return elementUtilities.isDisplayed(registrationSuccessMessage);
    }
    public Boolean isFirstNameErrorMessageDisplayed(){
        return elementUtilities.isDisplayed(firstnameErrorMessage);
    }
    public Boolean isLastNameErrorMessageDisplayed(){
        return elementUtilities.isDisplayed(lastnameErrorMessage);
    }
    public Boolean isEmailErrorMessageDisplayed(){
        return elementUtilities.isDisplayed(emailAddressErrorMessage);
    }
    public Boolean isPasswordErrorMessageDisplayed(){
        return elementUtilities.isDisplayed(passwordErrorMessage);
    }
    public Boolean isConfirmPasswordErrorMessageDisplayed(){
        return elementUtilities.isDisplayed(confirmationPasswordErrorMessage);
    }
    public Boolean isConfirmPasswordMismatchErrorMessageDisplayed(){
        return elementUtilities.isDisplayed(confirmPasswordMismatchError);
    }





}
