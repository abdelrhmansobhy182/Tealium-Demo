package frontend.pages;

import frontend.utilities.ElementUtilities;
import org.openqa.selenium.By;

public class CheckOutPage {


    private final ElementUtilities elementUtilities;
    private final By successMessage = By.className("success-msg");

    public CheckOutPage(ElementUtilities elementUtilities) {
        this.elementUtilities = elementUtilities;
    }

    public Boolean isSuccessMessageDisplayed(){
        return elementUtilities.isDisplayed(successMessage);
    }
}
