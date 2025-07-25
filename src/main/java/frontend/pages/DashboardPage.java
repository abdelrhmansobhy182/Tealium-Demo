package frontend.pages;

import frontend.enums.SortCategory;
import frontend.utilities.ElementUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage {

    private final ElementUtilities elementUtilities;
    private final By accessoriesMenu = By.cssSelector("li.level0.nav-3.parent");
    private final By accessoriesDropdown = By.cssSelector("li.level0.nav-3.parent.menu-active");
    private final By shoesCategory = By.cssSelector("li.nav-3-3 > a");
    private final By sortByDropDown = By.xpath("(//select[@title='Sort By'])[1]");
    private final By itemPrices = By.className("regular-price");
    private final By productName = By.cssSelector("div.product-name > span.h1");
    private final By shoesSize = By.cssSelector("#configurable_swatch_shoe_size li:first-of-type");
    private final By shoesColor= By.cssSelector("#configurable_swatch_color li:first-of-type");
    private final By addToCartButton = By.className("add-to-cart-buttons");


    public DashboardPage(ElementUtilities elementUtilities) {
        this.elementUtilities = elementUtilities;
    }

    public void clickOnShoesCategory(){
        elementUtilities.clickElement(shoesCategory);
    }

    public void clickOnProductByName(String productName) {
        By by = By.xpath(String.format("//a[text()='%s']", productName));
        elementUtilities.scrollToElement(by);
        elementUtilities.clickElement(by);
    }

    public void clickOnAddToCartButton(){
        elementUtilities.clickElement(addToCartButton);
    }

    public void selectShoesSize(){
        elementUtilities.clickElement(shoesSize);
    }
    public void selectShoesColor(){
        elementUtilities.clickElement(shoesColor);
    }

    public void hoverOverAccessoriesMenu(){
        elementUtilities.hoverOverElement(accessoriesMenu);
    }

    public Boolean isAccessoriesDropDownDisplayed(){
        return elementUtilities.isDisplayed(accessoriesDropdown);
    }

    public void sortItemsBy(SortCategory sortBy){
        elementUtilities.selectByVisibleText(sortByDropDown, String.valueOf(sortBy));
    }

    public  List<WebElement> getItemPrices(){
        return elementUtilities.getElements(itemPrices);
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

}
