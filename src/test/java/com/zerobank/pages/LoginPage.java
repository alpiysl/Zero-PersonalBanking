package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="user_login")
    public WebElement userName;

    @FindBy(id="user_password")
    public WebElement password;

    @FindBy(css = ".btn.btn-primary")
    public WebElement submit;

    @FindBy(css = ".signin.btn.btn-info")
    public WebElement sigIn;

    @FindBy(id = "account_summary_tab")
    public WebElement accountSummary;

    @FindBy(css = "div[class='alert alert-error']")
    public WebElement errorMessage;

    @FindBy(className = "dropdown-toggle")
    public WebElement userNameButton;

    @FindBy(id = "logout_link")
    public WebElement logout;



    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();

    }
    public void signIn(){
        sigIn.click();

    }

    public void alertAccept(){
        Alert alert = Driver.get().switchTo().alert();
        alertAccept();
    }


}
