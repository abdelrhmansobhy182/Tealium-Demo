package frontend.pages.product;

import frontend.utilities.ElementUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccessoriesPage extends DashboardPage{
    public AccessoriesPage(ElementUtilities elementUtilities) {
        super(elementUtilities);
    }

    private final By itemPrices = By.className("regular-price");
    private final By productName = By.cssSelector("div.product-name > span.h1");
    private final By shoesSize = By.cssSelector("#configurable_swatch_shoe_size li:first-of-type");
    private final By shoesColor= By.cssSelector("#configurable_swatch_color li:first-of-type");
    private final By addToCartButton = By.className("add-to-cart-buttons");

    public void clickOnAddToCartButton(){
        elementUtilities.clickElement(addToCartButton);
    }
    public void selectShoesSize(){
        elementUtilities.clickElement(shoesSize);
    }
    public void selectShoesColor(){
        elementUtilities.clickElement(shoesColor);
    }
    public String getProductName(){
        return elementUtilities.getText(productName);
    }
    public Boolean isSizeSelected(){
        return elementUtilities.isSelected(shoesSize);
    }
    public Boolean isColorSelected(){
        return elementUtilities.isSelected(shoesColor);
    }
    public List<WebElement> getItemPrices(){
        return elementUtilities.getElements(itemPrices);
    }
}
