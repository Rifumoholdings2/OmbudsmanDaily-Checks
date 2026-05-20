package com.ombudsman.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ombudsman.actiondriver.ActionDriver;
import com.ombudsman.base.BaseClass;

/**
 * HomePage class represents the OrangeHRM Home/Dashboard page.
 * 
 * Purpose: - Store page locators - Perform actions on Home page components -
 * Follow Page Object Model (POM) design principles - Keep UI logic separate
 * from test classes
 * 
 * Features covered: - Verify Admin tab visibility - Verify OrangeHRM logo -
 * Navigate to PIM module - Search employee - Logout functionality
 */
public class LandingPage {

	// ActionDriver object used for reusable Selenium actions
	private ActionDriver actionDriver;

	/*
	 * ============================== Page Locators ==============================
	 */

	// Admin module tab
	private By registerButton = By.xpath("//a[text() = 'Register now']");
	private By loginButton = By.xpath("//a[@href='/Account/Login']");

	/** 
	 * Constructor for HomePage
	 * 
	 * Initializes ActionDriver instance using BaseClass. Allows page methods to
	 * access reusable browser actions.
	 *
	 * @param driver WebDriver instance
	 */
	public LandingPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	/**
	 * Verify whether Admin tab is displayed.
	 *
	 * Purpose: Used to validate successful login and page visibility.
	 *
	 * @return true if visible false otherwise
	 */
	public void register() {
		actionDriver.click(registerButton);
	}

	public void scrollToRegisterButton() {
		actionDriver.scrollToElement(registerButton);
	}

	// Method to check if error message is displayed
	public boolean isLoginButtonDisplayed() {
		return actionDriver.isDisplayed(this.loginButton);
	}

	// Method to get the text from Error message
	public String getLoginText() {
		return actionDriver.getText(this.loginButton);
	}

	// Verify if error is correct or not
	public boolean verifyLoginText(String text) {
		return actionDriver.compareText(this.loginButton, text);
	}

	public void clickLoginButton() {
		actionDriver.click(this.loginButton);
	}
}