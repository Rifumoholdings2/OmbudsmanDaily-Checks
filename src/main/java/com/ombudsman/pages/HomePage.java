package com.ombudsman.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ombudsman.actiondriver.ActionDriver;
import com.ombudsman.base.BaseClass;

public class HomePage {
	// ActionDriver object used for reusable Selenium actions
	private ActionDriver actionDriver;

	/*
	 * ============================== Page Locators ==============================
	 */

	// Admin module tab
	private By welcomeText = By.id("lblusername");
	private By homeTab = By.xpath("//a[text()='Home Page']");
	private By myComplaints = By.xpath("//a[text()='My Complaints']");

	private By viewButtonFirstCase = By.xpath("(//tbody/tr)[1]//a[contains(@class,'edit-complaint')]");
	private By tableHeader = By.id("headingOne");
	private By uploadButton = By.xpath("//a[@href='/Complaints/Upsert?ComplaintId=1454&ShowTab=docs']");
	private By uploadTittle = By.xpath("//h3[text() = 'Almost there, please upload documents']");

	private By profileLog = By.xpath("//a[@href='javascript:void(0);']");
	private By logOut = By.xpath("//a[@href='/Account/Logout']");

	private By lodgeNewComplaint = By.xpath("//a[@href='/Complaints/Upsert']");

	public HomePage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	/**
	 * Verify whether Login tab is displayed.
	 *
	 * Purpose: Used to validate successful login and page visibility.
	 *
	 * @return true if visible false otherwise
	 */
	// Method to verify login
	public boolean isUsersNameDisplayed() {
		return actionDriver.isDisplayed(this.welcomeText);
	}

	// Method to get the text from greeting
	public String getWelcomeText() {
		return actionDriver.getText(this.welcomeText);
	}

	// Verify if error is correct or not
	public boolean verifyWelcomeText(String text) {
		return actionDriver.compareText(this.welcomeText, text);
	}

	// Method to click my complaint on left menu tab
	public void clickMyComplaint() {
		actionDriver.click(this.myComplaints);
	}

	// Method to click home page on left menu tab
	public void clickHomePage() {
		actionDriver.click(this.homeTab);
	}

	// Method to view first complaint on the table
	public void clickFirstCase() {
		actionDriver.click(this.viewButtonFirstCase);
	}

	// Method to verify Complaint Details
	public boolean isComplaintDetails() {
		return actionDriver.isDisplayed(this.tableHeader);
	}

	// Method to get the text Complaint Details
	public String getComplaintDetailsText() {
		return actionDriver.getText(this.tableHeader);
	}

	// Verify if error is correct or not
	public boolean verifyComplaintDetailsText(String text) {
		return actionDriver.compareText(this.tableHeader, text);
	}

	public void scrollToUploadButton() {
		actionDriver.scrollToElement(uploadButton);
	}

	// Method to verify upload page
	public boolean isUploadPageDisplayed() {
		return actionDriver.isDisplayed(this.uploadTittle);
	}

	// Method to get the text upload page
	public String getUploadPageText() {
		return actionDriver.getText(this.uploadTittle);
	}

	// Verify if error is correct or not
	public boolean verifyUploadHeadingText(String text) {
		return actionDriver.compareText(this.uploadTittle, text);
	}

	// Method to view first complaint on the table
	public void clickNewCase() {
		actionDriver.click(this.lodgeNewComplaint);
	}

	// Method to view first complaint on the table
	public void clickProfileLog() {
		actionDriver.click(this.profileLog);
	}

	// Method to view first complaint on the table
	public void clickLogOut() {
		actionDriver.click(this.logOut);
	}
}
