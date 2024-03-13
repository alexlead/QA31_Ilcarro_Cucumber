package com.ilcarro.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class BasePage {
    public static WebDriver driver;
    JavascriptExecutor js;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js=(JavascriptExecutor) driver;
    }

    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openUrl() {
        driver.get("https://ilcarro.web.app");
    }

    public void click (WebElement element) {
        element.click();
    }

    public void type (WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
    public boolean isElementDisplayed (WebElement element) {
        return element.isDisplayed();
    }

    public void clickWithJS(WebElement element, int x,int y) {
        js.executeScript("window.scrollBy("+ x + "," + y + ")");
        click(element);
    }

    public void quit() {
        driver.quit();
    }

    public void clickWithJsAction(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }
}
