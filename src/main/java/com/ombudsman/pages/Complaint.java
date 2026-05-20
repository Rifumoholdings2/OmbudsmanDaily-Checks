package com.ombudsman.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.ombudsman.actiondriver.ActionDriver;
import com.ombudsman.base.BaseClass;

public class Complaint {
	// ActionDriver object used for reusable Selenium actions
		private ActionDriver actionDriver;

		/*
		 * ============================== Page Locators ==============================
		 */

		// Admin module tab
		private By ID = By.id("IdOrPassport");
		private By HomeTelephone = By.id("HomeTelephone");
		private By WorkTelephone = By.id("WorkTelephone");
		private By btnNext = By.id("btnNext");
		
		private By DwellingType = By.id("DwellingType");
		private By AddressLine2 = By.id("AddressLine2");
		private By COJRegionId = By.id("COJRegionId");
		private By COJSuburbId = By.id("COJSuburbId");
		private By PostalCode = By.id("PostalCode");
		
		private By HowToResolve = By.id("HowToResolve");
		private By ComplaintDetail = By.id("ComplaintDetail");
		private By ITYFIWTCValue = By.id("ITYFIWTCValue");
		private By ECOJRValue = By.id("ECOJRValue");
		private By COJDepartmentId = By.id("COJDepartmentId");
		private By PreferredContactMethod = By.id("PreferredContactMethod");
		private By HowDoYouKnowOmbudsman = By.id("HowDoYouKnowOmbudsman");

		public Complaint(WebDriver driver) {
			this.actionDriver = BaseClass.getActionDriver();
		}
		
		public void enterIDNumber(String id) {
			actionDriver.enterText(this.ID, id);
		}
		
		public void enterHomePhone(String id) {
			actionDriver.enterText(this.HomeTelephone, id);
		}
		
		public void enterWorkNumber(String id) {
			actionDriver.enterText(this.WorkTelephone, id);
		}
		
		public void clickButtonNext() {
			actionDriver.click(this.btnNext);
		}
		
		
}
