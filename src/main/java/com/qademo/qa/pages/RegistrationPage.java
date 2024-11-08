package com.qademo.qa.pages;

import com.qademo.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends TestBase {
    // Page Factory - Object Repository (OR)
    @FindBy(xpath = "//h5[contains(text(),'Book Store Application')]")
    WebElement bookStore;

    @FindBy(xpath = "//button[@id='login']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[@id='newUser']")
    WebElement addUserBtn;

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='userName']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//span[@role='checkbox']/div[1]")
    WebElement captchaCheckbox;
    @FindBy(xpath = "//button[@id='register']")
    WebElement registerBtn;

    // Initializing the page objects
    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    // Actions:
    public String validatePageTitle() {
        return driver.getTitle();
    }

    public void openRegistrationPage() {

        bookStore.click();
        loginBtn.click();
        addUserBtn.click();
    }

    public ProfilePage doRegistration(String firstName, String lastName, String userName, String password) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        captchaCheckbox.click();
        registerBtn.click();
        // Code to submit the form (if any button to complete registration)
        // submitButton.click();  // Uncomment if there is a submit button
        return new ProfilePage();
    }
}
