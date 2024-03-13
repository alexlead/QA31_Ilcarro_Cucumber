package com.ilcarro.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddCarPage extends BasePage {
    public AddCarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href=\"/let-car-work\"]")
    WebElement linkToFormPage;

    public AddCarPage openFormPage() {
//        String jsSyyle = "'3px solid red'";
//        js.executeScript("arguments[0].style.border=" + jsSyyle, linkToFormPage);
//        click(linkToFormPage);

        clickWithJsAction(linkToFormPage);
        return this;
    }

    @FindBy(id = "pickUpPlace")
    WebElement pickUpPlace;
    @FindBy(id = "make")
    WebElement make;
    @FindBy(id = "model")
    WebElement model;
    @FindBy(id = "year")
    WebElement year;
    @FindBy(id = "fuel")
    WebElement fuel;
    @FindBy(id = "seats")
    WebElement seats;
    @FindBy(id = "class")
    WebElement classCar;
    @FindBy(id = "serialNumber")
    WebElement serialNumber;
    @FindBy(id = "price")
    WebElement price;
    @FindBy(id = "about")
    WebElement aboutCar;
    @FindBy(id = "photos")
    WebElement photosCar;

    public AddCarPage fillCarFormPage(List<String> data) {

        type(pickUpPlace, data.get(0));
        selectCityByClick();
        type(make, data.get(1));
        type(model, data.get(2));
        type(year, data.get(3));

        Select select = new Select(fuel);
        select.selectByValue(data.get(4));

        type(seats, data.get(5));
        type(classCar, data.get(6));
        type(serialNumber, data.get(7));
        type(price, data.get(8));
        type(aboutCar, data.get(9));
        photosCar.sendKeys(data.get(10));

//        type(photosCar, data.get(10));

        return this;
    }

@FindBy(css = ".pac-item")
WebElement cityClick;
    public AddCarPage selectCityByClick() {
        clickWithJsAction(cityClick);
        return this;
    }

    @FindBy(css = "button[type='submit']")
    WebElement submitButton;
    public AddCarPage submitCarFormPage() {
        clickWithJsAction(submitButton);
        return this;
    }

    @FindBy(css="h2.message")
    WebElement confirmationMessage;
    public AddCarPage verifyCarAddConfirmationPage() {

        assert isElementDisplayed(confirmationMessage);
        return this;
    }
}
