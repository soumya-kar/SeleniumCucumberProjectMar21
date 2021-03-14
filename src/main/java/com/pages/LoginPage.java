package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By emailField= By.id("email");
	private By passwordField= By.id("passwd");
	private By loginButton= By.cssSelector("#SubmitLogin");
	private By forgotPasswordLink = By.linkText("Forgot your password?");
	
	public LoginPage(WebDriver driver){
		this.driver= driver;
	}
	
	public void enterUserName(String userId){
		driver.findElement(emailField).sendKeys(userId);	
	}
	
	public void enterPassword(String password){
		driver.findElement(passwordField).sendKeys(password);	
	}
	
	public void clickLoginButton(){
		driver.findElement(loginButton).click();
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExists(){
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public AccountPage doLogin(String username, String password){
		enterUserName(username);
		enterPassword(password);
		clickLoginButton();
		return new AccountPage(driver);
	}

}
