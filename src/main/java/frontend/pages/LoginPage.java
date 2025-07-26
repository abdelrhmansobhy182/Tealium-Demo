package frontend.pages;

import frontend.utilities.ElementUtilities;
import org.openqa.selenium.By;

public class LoginPage {

    private final ElementUtilities elementUtilities;
    private final By emailField = By.id("email");
    private final By passwordField = By.id("pass");
    private final By submitButton = By.id("send2");
    private final By helloMessage = By.className("hello");
    private final By invalidLoginMessage = By.xpath("//span[text()='Invalid login or password.']");

    public LoginPage(ElementUtilities elementUtilities) {
        this.elementUtilities = elementUtilities;
    }

    // We can use one method to Login
    public void login(String email, String password){
        elementUtilities.typeText(emailField,email);
        elementUtilities.typeText(passwordField,password);
        elementUtilities.clickElement(submitButton);
    }

    public void enterEmail(String email){
        elementUtilities.typeText(emailField,email);
    }
    public void enterPassword(String password){
        elementUtilities.typeText(passwordField,password);
    }
    public void clickOnSubmitButton(){
        elementUtilities.clickElement(submitButton);
    }
    public Boolean isInvalidLoginMessageDisplayed(){
        return elementUtilities.isDisplayed(invalidLoginMessage);
    }
    public String getHelloMessageText(){
        return elementUtilities.getText(helloMessage);
    }



}
