package com.ombudsman.test.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ombudsman.base.BaseClass;
import com.ombudsman.pages.HomePage;
import com.ombudsman.pages.LandingPage;
import com.ombudsman.pages.LoginPage;
import com.ombudsman.pages.RegisterPage;
import com.ombudsman.pages.LandingPage;
import com.ombudsman.utils.ExtentManager;

public class LandingPageTest extends BaseClass{
	private LandingPage landingPage;
	private RegisterPage register;
	private LoginPage login;
	private HomePage homePage;
	
	@BeforeMethod
	public void setupPages() {
		landingPage  = new LandingPage(getDriver());
		register = new RegisterPage(getDriver());
		login = new LoginPage(getDriver());
		homePage = new HomePage(getDriver());
	}
	
	@Test(priority = 2)
	public void loginTest() {
		System.out.println("opening ombudsman login page");
		ExtentManager.logStep("Navigated to Ombudsman landing page and click login button");
		Assert.assertTrue(landingPage.isLoginButtonDisplayed(), " Register tab should be visible after successfull clicking register button");
		ExtentManager.logStep("Validation successfully!");
		
		String labelText = "Login";
		
		Assert.assertTrue(landingPage.verifyLoginText(labelText),  " Test Failed invalid error message");
		ExtentManager.logStepWithScreenshot(getDriver(), "Register form is displayed ", " Expected Message! "+labelText);
		landingPage.clickLoginButton();
		
		ExtentManager.logStep("Redirecting to login page");
		Assert.assertTrue(login.isLoginLabelDisplayed(), " Login tab should be visible after successfull clicking login button");
		ExtentManager.logStep("Validation successfully!");
		String loginText = "Log in";
		Assert.assertTrue(login.verifyLoginLabelText(loginText),  " Test Failed invalid error message");
		ExtentManager.logStepWithScreenshot(getDriver(), "Register form is displayed ", " Expected Message! "+loginText);
		login.logIn("simikahledlomo@gmail.com", "P@ssw0rd1");
		staticWait(5);	
		
		
		ExtentManager.logStep("User redirect to home page");
		Assert.assertTrue(homePage.isUsersNameDisplayed(), " welcome message should be visible after successfull clicking login button");
		ExtentManager.logStep("Validation successfully!");
		String welcomText = "Hi, Simikahle";
		Assert.assertTrue(homePage.verifyWelcomeText(welcomText),  " Test Failed invalid error message");
		ExtentManager.logStepWithScreenshot(getDriver(), "Register form is displayed ", " Expected Message! "+welcomText);
		
		homePage.clickProfileLog();
		staticWait(3);
	}
}
