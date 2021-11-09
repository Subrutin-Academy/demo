//package com.nostra.demo.page.nostra;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.nostra.demo.page.AbstractBasePage;
//
//@Component
//public class HomePage extends AbstractBasePage {
//	
//	@FindBy(xpath = "//*[@id=\"nav-collapse\"]/ul[1]/li[1]/a")
//	private WebElement aboutUsMenu;
//	
//	@Autowired
//	private AboutUs aboutUs;
//	
//	public void goTo() {
//		this.driver.get("https://www.nostratech.com/");
//	}
//	
//	public AboutUs clickAboutUsMenu() {
//		this.aboutUsMenu.click();
//		return aboutUs;
//	}
//
//	@Override
//	public boolean isAt() {
//		
//		return this.wait.until((d)->this.aboutUsMenu.isDisplayed());
//	}
//
//}
