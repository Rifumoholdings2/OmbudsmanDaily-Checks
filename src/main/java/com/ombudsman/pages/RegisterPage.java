package com.ombudsman.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ombudsman.actiondriver.ActionDriver;
import com.ombudsman.base.BaseClass;

public class RegisterPage {
	// ActionDriver object used for reusable Selenium actions
	private ActionDriver actionDriver;

	/*
	 * ============================== Page Locators ==============================
	 */

	// Admin module tab
	private By registerLabel = By.xpath("//h4[text() = 'Register']");
	private By name = By.name("Name");
	private By surname = By.name("Surname");
	private By emailaddress = By.name("EmailAddress");
	private By phoneNumber = By.name("UserName");
	private By password = By.name("Password");
	private By backButton = By.xpath("//a[text() = ' Back']");
	private By registerButton = By.id("RegisterButton");
	private By errorMessage = By.xpath("//div [@class = 'alert alert-danger']");

	/**
	 * Constructor for HomePage
	 * 
	 * Initializes ActionDriver instance using BaseClass. Allows page methods to
	 * access reusable browser actions.
	 *
	 * @param driver WebDriver instance
	 */
	public RegisterPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	/**
	 * Verify whether Admin tab is displayed.
	 *
	 * Purpose: Used to validate successful login and page visibility.
	 *
	 * @return true if visible false otherwise
	 */
	// Method to check if error message is displayed
	public boolean isRegisterLabelDisplayed() {
		return actionDriver.isDisplayed(registerLabel);
	}

	// Method to get the text from Error message
	public String getRegisterLabelText() {
		return actionDriver.getText(registerLabel);
	}

	// Verify if error is correct or not
	public boolean verifyRegisterLabelText(String expectedError) {
		return actionDriver.compareText(registerLabel, expectedError);
	}

	public void fillInRegisterForm(String name, String surname, String emailaddress, String phone, String password) {
		actionDriver.enterText(this.name, name);
		actionDriver.enterText(this.surname, surname);
		actionDriver.enterText(this.emailaddress, emailaddress);
		actionDriver.enterText(this.phoneNumber, phone);
		actionDriver.enterText(this.password, password);
	}

	public void clickRegisterButton() {
		actionDriver.click(this.registerButton);
	}

	public void clickBackButton() {
		actionDriver.click(this.backButton);
	}
	
	// Method to check if error message is displayed
		public boolean isErrorMessageDisplayed() {
			return actionDriver.isDisplayed(errorMessage);
		}

		// Method to get the text from Error message
		public String getErrorMessageText() {
			return actionDriver.getText(errorMessage);
		}

		// Verify if error is correct or not
		public boolean verifyErrorMessage(String expectedError) {
			return actionDriver.compareText(errorMessage, expectedError);
		}
}
