package frontend.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class ElementUtilities {

    private final WebDriver driver;
    private final WaitUtilities waitUtilities;

    public ElementUtilities(WebDriver driver) {
        this.driver = driver;
        this.waitUtilities = new WaitUtilities(driver);
    }

    public WebElement getElement(By by){
        return driver.findElement(by);
    }

    public List<WebElement> getElements(By by){
        return driver.findElements(by);
    }

    public void clickElement(By by) {
        WebElement element = waitUtilities.waitUntilClickable(by);
        element.click();
    }

    public void typeText(By by, String text) {
        WebElement element = waitUtilities.waitUntilVisible(by);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By by) {
        return waitUtilities.waitUntilVisible(by).getText();
    }

    public void selectByVisibleText(By dropdownElement, String visibleText) {
        Select select = new Select(waitUtilities.waitUntilVisible(dropdownElement));
        select.selectByVisibleText(visibleText);
    }

    public boolean isDisplayed(By by) {
        try {
            return waitUtilities.waitUntilVisible(by).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isEnabled(By by) {
        return waitUtilities.waitUntilVisible(by).isEnabled();
    }

    public boolean isSelected(By by) {
        WebElement element = waitUtilities.waitUntilVisible(by);
        return element.getAttribute("class").contains("selected");
    }

    public void checkBox(By by) {
        WebElement checkbox = driver.findElement(by);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void scrollToElement(By by) {
        WebElement element = waitUtilities.waitUntilVisible(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getPageURL() throws InterruptedException {
        Thread.sleep(500);
        return driver.getCurrentUrl();
    }

    public void hoverOverElement(By by) {
        WebElement element = waitUtilities.waitUntilVisible(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
