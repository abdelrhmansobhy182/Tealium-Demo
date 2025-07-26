package frontend.pages.product;

import frontend.enums.SortCategory;
import frontend.utilities.ElementUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DashboardPage {

    protected ElementUtilities elementUtilities;
    private final By accessoriesMenu = By.cssSelector("li.level0.nav-3.parent");
    private final By accessoriesDropdown = By.cssSelector("li.level0.nav-3.parent.menu-active");
    private final By shoesCategory = By.cssSelector("li.nav-3-3 > a");
    private final By sortByDropDown = By.xpath("(//select[@title='Sort By'])[1]");

    public DashboardPage(ElementUtilities elementUtilities) {
        this.elementUtilities = elementUtilities;
    }

    public void clickOnShoesCategory(){
        elementUtilities.clickElement(shoesCategory);
    }
    public void clickOnProductByName(String productName) {
        By by = By.xpath(String.format("//h2[@class='product-name']/a[contains(text(), '%s')]", productName));
        elementUtilities.scrollToElement(by);
        elementUtilities.clickElement(by);
    }
    public void hoverOverAccessoriesMenu(){
        elementUtilities.hoverOverElement(accessoriesMenu);
    }
    public void sortItemsBy(SortCategory sortBy){
        elementUtilities.selectByVisibleText(sortByDropDown, String.valueOf(sortBy));
    }
    public Boolean areItemPricesSorted(List<WebElement> list) {
        List<Double> prices = new ArrayList<>();
        for (WebElement element : list) {
            String priceText = element.getText().replace("$", "")
                    .replace(",", "").trim();
            prices.add(Double.parseDouble(priceText));
        }

        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        return prices.equals(sortedPrices);
    }
    public Boolean isAccessoriesDropDownDisplayed(){
        return elementUtilities.isDisplayed(accessoriesDropdown);
    }
}
