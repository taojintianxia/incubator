package jbehave.pages;

import jbehave.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Feb 19, 2014 11:16:25 AM
 * 
 */

public class BaiduPage extends BasePage {

	public void nevigateToHomePage() {
		helper.openURL("/");
	}

	public void searchSpecificTextOnPage() {
		WebElement searchField = helper.findElmenetBy(By.id("gs_htif0"));
		WebElement searchButton = helper.findElmenetBy(By.id("gbqfba"));
		helper.typeText("哈喽你好三中姐", searchField);
		helper.clickOn(searchButton);
	}

	public boolean isExpectedResultShowUp() {
		return true;
	}

	public void reandomlyNevigateResultLink() {
		WebElement firstLink = helper.findElmenetBy(By.cssSelector("content_left"));
		helper.clickOn(firstLink);
	}
}
