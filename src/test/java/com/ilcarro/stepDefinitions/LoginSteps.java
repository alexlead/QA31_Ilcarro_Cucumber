package com.ilcarro.stepDefinitions;

import com.ilcarro.pages.HomePage;
import com.ilcarro.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.ilcarro.pages.BasePage.driver;

public class LoginSteps {

    @And("User clicks on login link")
    public void click_on_login_link () {
        new HomePage(driver).clickOnLoginLink();
    }

    @And("User enter valid data")
    public void enter_valid_data() {
        new LoginPage(driver).enterData("testnue@gm.com","testNue@1");
    }
    @And("User clicks on Yalla button")
    public void click_yalla_button() {
        new LoginPage(driver).clickOnYallaButton();
    }
    @Then("User verifies Success message display")
    public void verify_success_message() {
        new LoginPage(driver).isSuccessMessageDisplayed();
    }


    @And("User enter valid email and invalid password")
    public void enter_invalid_password(DataTable dataTable) {
        new LoginPage(driver).enterIncorrectPassword(dataTable);

    }
    @Then("User verifies Error message display")
       public void verify_Error_message() {
        new LoginPage(driver).isErrorDisplayed();

    }
}
