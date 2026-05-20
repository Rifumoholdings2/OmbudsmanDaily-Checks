package com.ombudsman.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ombudsman.actiondriver.ActionDriver;
import com.ombudsman.base.BaseClass;

public class LoginPage {
	// ActionDriver object used for reusable Selenium actions
		private ActionDriver actionDriver;

		/*
		 * ============================== Page Locators ==============================
		 */

		// Admin module tab
		private By loginLabel = By.xpath("//h4[text() = 'Log in']");
		private By username = By.name("usernameOrEmailAddress");
		private By password = By.name("Password");
		private By rememberMe = By.name("__RequestVerificationToken");
		private By forgotPassword = By.xpath("//a[@href='/Account/ForgotPassword']");
		private By registerButton =By.xpath("//a[@href='/Account/Register']");
		private By loginButton = By.id("LoginBut ton");
		
		public LoginPage(WebDriver driver) {
			this.actionDriver = BaseClass.getActionDriver();
		}
		
		/**
		 * Verify whether Login tab is displayed.
		 *
		 * Purpose: Used to validate successful login and page visibility.
		 *
		 * @return true if visible false otherwise
		 */
		// Method to check if error message is displayed
		public boolean isLoginLabelDisplayed() {
			return actionDriver.isDisplayed(this.loginLabel);
		}

		// Method to get the text from Error message
		public String getLoginLabelText() {
			return actionDriver.getText(this.loginLabel);
		}

		// Verify if error is correct or not
		public boolean verifyLoginLabelText(String text) {
			return actionDriver.compareText(this.loginLabel, text);
		}
		
		//Login Method
		public void logIn(String username, String password) {
			actionDriver.enterText(this.username, username);
			actionDriver.enterText(this.password, password);
			actionDriver.click(this.loginButton);
		}
		
		//Forgot Password button 
		public void clickForgotButton() {
			actionDriver.click(this.forgotPassword);
		}
		
		//Register button
		public void clickBackButton() {
			actionDriver.click(this.registerButton);
		}
}
