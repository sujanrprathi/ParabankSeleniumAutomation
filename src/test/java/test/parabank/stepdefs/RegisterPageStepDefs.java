package test.parabank.stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.parabank.pages.RegisterPage;

public class RegisterPageStepDefs {

    RegisterPage registerPage = new RegisterPage();
    Faker faker=new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String street = faker.address().streetAddress();
    String city = faker.address().city();
    String state = faker.address().state();
    String zipCode = faker.address().zipCode().substring(0, 5);
    String phone = faker.phoneNumber().cellPhone();
    String ssn = faker.idNumber().ssnValid();
    String username = faker.name().username();
    String password = faker.internet().password(8, 16);

    @Given("User is on homepage")
    public void user_is_on_homepage() {
        registerPage.verifyHomePage();
    }

    @When("User clicks on Register link")
    public void user_clicks_on_register_link() {
        registerPage.clickOnRegisterLink();
    }

    @Then("User should navigate to register page successfully")
    public void user_should_navigate_to_register_page_successfully() {
        assert registerPage.isRegisterPageHeadingDisplayed() : "Register page heading is not displayed";
    }


    @When("User is on Register page")
    public void userIsOnRegisterPage() {
        assert registerPage.isRegisterPageHeadingDisplayed() : "User is not on Register page";
    }

    @When("User enters valid personal information")
    public void userEntersValidPersonalInformation() {

        registerPage.enterCustomerFirstName(firstName);
        registerPage.enterCustomerLastName(lastName);
        registerPage.enterCustomerAddressStreet(street);
        registerPage.enterCustomerAddressCity(city);
        registerPage.enterCustomerAddressState(state);
        registerPage.enterCustomerAddressZipCode(zipCode);
        registerPage.enterCustomerPhone(phone);
        registerPage.enterCustomerSsn(ssn);
    }

    @When("User enters valid Userid and passwords")
    public void userEntersValidUseridAndPasswords() {
        registerPage.enterCustomerUsername(username);
        registerPage.enterCustomerPassword(password);
        registerPage.enterCustomerRepeatPassword(password);
    }

    @When("clicks on Register button")
    public void clicksOnRegisterButton() {
        registerPage.clickOnRegisterButton();
    }

    @Then("Welcome new user page should be displayed")
    public void welcomeNewUserPageShouldBeDisplayed() {
        registerPage.verifyRegistrationSuccessful();
    }

    @And("User leaves First Name field empty")
    public void userLeavesFirstNameFieldsEmpty() {
        registerPage.enterCustomerLastName(lastName);
        registerPage.enterCustomerAddressStreet(street);
        registerPage.enterCustomerAddressCity(city);
        registerPage.enterCustomerAddressState(state);
        registerPage.enterCustomerAddressZipCode(zipCode);
        registerPage.enterCustomerPhone(phone);
        registerPage.enterCustomerSsn(ssn);
        registerPage.enterCustomerUsername(username);
        registerPage.enterCustomerPassword(password);
        registerPage.enterCustomerRepeatPassword(password);
    }

    @Then("Error message should be displayed for missing required fields")
    public void errorMessageShouldBeDisplayedForMissingRequiredFields() {
        registerPage.checkFirstNameRequiredErrorMessage();
    }

    @Given("User logs out of current user account")
    public void userLogsOutOfCurrentUserAccount() {
        registerPage.clickOnLogoutLink();
    }
}
