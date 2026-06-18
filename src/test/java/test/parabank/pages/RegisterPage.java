package test.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.parabank.utils.BaseTest;
import test.parabank.utils.DriverManager;
import test.parabank.utils.LocatorConverter;
import test.parabank.utils.ScreenShotUtil;

import java.util.Objects;

public class RegisterPage extends BaseTest {

    private final By registerLink=By.xpath("//a[text()='Register']");
    private final By registerPageHeading=By.xpath("//h1[text()='Signing up is easy!']");
    private final By customerFirstNameInput=By.xpath("//input[@id='customer.firstName']");
    private final By customerLastNameInput=By.xpath("//input[@id='customer.lastName']");
    private final By customerAddressStreetInput=By.xpath("//input[@id='customer.address.street']");
    private final By customerAddressCityInput=By.xpath("//input[@id='customer.address.city']");
    private final By customerAddressStateInput=By.xpath("//input[@id='customer.address.state']");
    private final By customerAddressZipCodeInput=By.xpath("//input[@id='customer.address.zipCode']");
    private final By customerPhoneInput=By.xpath("//input[@id='customer.phoneNumber']");
    private final By customerSsnInput=By.xpath("//input[@id='customer.ssn']");
    private final By customerUsernameInput=By.xpath("//input[@id='customer.username']");
    private final By customerPasswordInput=By.xpath("//input[@id='customer.password']");
    private final By customerRepeatPasswordInput=By.xpath("//input[@id='repeatedPassword']");
    private final By registerButton=By.xpath("//input[@value='Register']");
    private final By registrationSuccessMessage=By.xpath("//p[text()='Your account was created successfully. You are now logged in.']");
    private final By firstNameRequiredErrorMessage=By.xpath("//span[text()='First name is required.']");
    private final By logoutLink=By.xpath("//a[@href='logout.htm']");



    public void verifyHomePage(){
        assert Objects.equals(DriverManager.getDriver().getTitle() ,"ParaBank | Welcome | Online Banking");
    }
    public void verifyRegistrationSuccessful(){
        assert isDisplayed(registrationSuccessMessage) : "Registration was not successful";
    }

    public void clickOnRegisterLink(){
        click(registerLink);
    }

    public void enterCustomerFirstName(String firstName){
        enter(customerFirstNameInput, firstName);
    }

    public void enterCustomerLastName(String lastName) {
        enter(customerLastNameInput, lastName);
    }
  public void enterCustomerAddressStreet(String street){
        enter(customerAddressStreetInput, street);
    }

    public void enterCustomerAddressCity(String city){
        enter(customerAddressCityInput, city);
    }
    public void enterCustomerAddressState(String state){
        enter(customerAddressStateInput, state);
    }
    public void enterCustomerAddressZipCode(String zipCode){
        enter(customerAddressZipCodeInput, zipCode);
    }
    public void enterCustomerPhone(String phone){
        enter(customerPhoneInput, phone);
    }
    public void enterCustomerSsn(String ssn){
        enter(customerSsnInput, ssn);
    }
    public void enterCustomerUsername(String username){
        enter(customerUsernameInput, username);
    }
    public void enterCustomerPassword(String password){
        enter(customerPasswordInput, password);
    }
    public void enterCustomerRepeatPassword(String repeatPassword){
        enter(customerRepeatPasswordInput, repeatPassword);
    }
    public void clickOnRegisterButton(){
        click(registerButton);
        ScreenShotUtil.takeFullScreenShot("After clicking Register button");
    }
    public void clickOnLogoutLink(){
        click(logoutLink);
    }

    public boolean isRegisterPageHeadingDisplayed(){
        return isDisplayed(registerPageHeading);
    }


    public void checkFirstNameRequiredErrorMessage(){
        WebElement message= LocatorConverter.convertByToWebElement(firstNameRequiredErrorMessage);
        ScreenShotUtil.takeElementScreenshot(message, "FirstNameRequiredErrorMessage");
        assert isDisplayed(firstNameRequiredErrorMessage) : "First name required error message is not displayed";
    }
}