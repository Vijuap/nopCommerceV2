package com.nopCommerceV2.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerceV2.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		driver.get(baseURL);
		logger.info("URL OPened");
		driver.manage().window().maximize(); 
		
		LoginPage lp = new LoginPage(driver);
		
        lp.setUserName(username);
		logger.info("User provided"); //logger msg
		
		lp.setPassword(password);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		Thread.sleep(2000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
			
		} else {
			captureScreen(driver,"loginTest1");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}

	}
	
	
}
