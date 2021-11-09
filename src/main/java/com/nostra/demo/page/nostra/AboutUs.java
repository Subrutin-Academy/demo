//package com.nostra.demo.page.nostra;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.springframework.stereotype.Component;
//
//import com.nostra.demo.page.AbstractBasePage;
//
//@Component
//public class AboutUs extends AbstractBasePage{
//	
//	@FindBy(xpath = "//*[@id=\"page-content\"]/div/h2")
//	public WebElement aboutUsText;
//
//	@Override
//	public boolean isAt() {
//		return this.wait.until((d)->this.aboutUsText.isDisplayed());
//	}
//
//}
