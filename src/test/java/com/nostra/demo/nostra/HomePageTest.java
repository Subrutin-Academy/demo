package com.nostra.demo.nostra;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nostra.demo.SpringBaseTestNG;
import com.nostra.demo.page.nostra.AboutUs;
import com.nostra.demo.page.nostra.HomePage;

public class HomePageTest extends SpringBaseTestNG{

	@Autowired
	private HomePage homePage;
	
	@Test
	public void clickAboutUsTest() {
		homePage.goTo();
		Assert.assertTrue(homePage.isAt());
		AboutUs aboutUs =  homePage.clickAboutUsMenu();
		Assert.assertTrue(aboutUs.isAt());
		Assert.assertEquals(aboutUs.aboutUsText.getText(), "About Us");
	}
}
