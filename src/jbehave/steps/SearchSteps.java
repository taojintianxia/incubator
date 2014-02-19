package jbehave.steps;

import jbehave.base.BasePage;
import jbehave.base.PageContainer;

import org.jbehave.core.annotations.Given;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Feb 19, 2014 10:16:53 AM
 * 
 */

public class SearchSteps extends BasePage {
	@Given("I access Baidu site")
	public void iSearchFor(String searchItem) throws Exception {
		PageContainer.getInstance().getBaiduPage().nevigateToHomePage();
	}
}
