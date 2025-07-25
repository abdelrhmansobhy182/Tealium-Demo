package frontend.pages;

import frontend.utilities.ElementUtilities;
import org.openqa.selenium.By;

public class HomePage {

    private final ElementUtilities elementUtilities;
    private final By accountButton = By.cssSelector("a.skip-account");
    private final By registerButton = By.xpath("//a[@title='Register']");
    private final By loginButton = By.xpath("//a[@title='Log In']");
    private final By privacyOptInButton = By.id("privacy_pref_optin");
    private final By submitPopUpButton = By.id("consent_prompt_submit");

    public HomePage(ElementUtilities elementUtilities) {
        this.elementUtilities = elementUtilities;
    }

    public void clickOnAccountButton(){
        elementUtilities.clickElement(accountButton);
    }
    public void clickOnRegisterButton(){
        elementUtilities.clickElement(registerButton);
    }
    public void clickOnLoginButton(){
        elementUtilities.clickElement(loginButton);
    }
    public void closePrivacyPopUp(){
        elementUtilities.clickElement(privacyOptInButton);
        elementUtilities.clickElement(submitPopUpButton);
    }
}
