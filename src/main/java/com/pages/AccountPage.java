package com.pages;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.bytebuddy.description.ByteCodeElement.Token.TokenList;

public class AccountPage {
	
	private WebDriver driver;
	
	public AccountPage(WebDriver driver){
		this.driver= driver;
	}
	
	private By accountSection= By.cssSelector(".myaccount-link-list a");
	
	public int getAccountSectionSize(){
		return driver.findElements(accountSection).size();
	}
	
	public List<String> getAccountSectionList(){
		List<String> accountList=driver.findElements(accountSection)
										.stream()
										.map(ele->ele.getText())
										.collect(Collectors.toList());
		return accountList;
	}
	
	public String getAccountPageTitle(){
		return driver.getTitle();
	}

}
