package com.ilcarro.stepDefinitions;

import com.ilcarro.pages.AddCarPage;
import com.ilcarro.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.ilcarro.pages.BasePage.driver;
public class AddCarSteps {


    @And("Close Success message display")
    public void closeSuccessLoginMessage () {
        new LoginPage(driver).closeSuccessMessage();
    }

    @And("Open let the car work page")
    public void openAddCarFormPage() {
        new AddCarPage(driver).openFormPage();
    }

    @And("Fill form with correct data")
    public void fillCarForm() {

        List<String> data = new ArrayList<>();

        data.add("Tel Aviv, Isr");
        data.add("Mercedes");
        data.add("600");
        data.add("2024");
        data.add("Electric");
        data.add("5");
        data.add("Business");
        data.add("a"+ ThreadLocalRandom.current().nextInt(100, 9999) +"aa00");
        data.add("30");
        data.add("Super Car for Business trip");
        data.add("D:/AIT/1.jpeg");

        new AddCarPage(driver).fillCarFormPage( data );

    }
    @And("Submit the filled data form")
    public void submitCarForm() {
        new AddCarPage(driver).submitCarFormPage( );

    }
    @Then("Verify Car added Message")
    public void verifyCarAddedMessage() {

        new AddCarPage(driver).verifyCarAddConfirmationPage();
    }
}
