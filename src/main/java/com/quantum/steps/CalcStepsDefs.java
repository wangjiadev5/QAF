/**
 * 
 */
package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.StringUtil;
import com.quantum.utils.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import java.util.Set;


/**
 * @author chirag.jayswal
 *
 */
@QAFTestStepProvider
public class CalcStepsDefs {

	@When("clear Calculator")
	public void clearCalculator() {

		new QAFExtendedWebElement("btn.clear").click();
	}


	@When("add \"(.+)\" to \"(.+)\"")
	public void addInto(long l1, long l2) {

		DriverUtils.getAppiumDriver().findElementByAccessibilityId(String.valueOf(l1)).click();
		new QAFExtendedWebElement("btn.plus").click();
		DriverUtils.getAppiumDriver().findElementByAccessibilityId(String.valueOf(l2)).click();
		new QAFExtendedWebElement("btn.equal").click();;


	}



	@Then("result should be \"(.+)\"")
	public void resultShouldBe(long l1) {
		new QAFExtendedWebElement("input.box").verifyText("in:" + String.valueOf(l1));
	}

	@Then("I switch to frame \"(.*?)\"")
	public static void switchToFrame(String nameOrIndex) {
		if (StringUtil.isNumeric(nameOrIndex)) {
			int index = Integer.parseInt(nameOrIndex);
			new WebDriverTestBase().getDriver().switchTo().frame(index);
		} else {
			new WebDriverTestBase().getDriver().switchTo().frame(nameOrIndex);
		}
	}

	@Then("I switch to \"(.*?)\" frame by element")
	public static void switchToFrameByElement(String loc) {
		new WebDriverTestBase().getDriver().switchTo().frame(new QAFExtendedWebElement(loc));
	}

	@When("I am using an AppiumDriver")
	public void testForAppiumDriver() {
		if (ConfigurationUtils.getBaseBundle().getPropertyValue("driver.name").contains("Remote"))
			ConsoleUtils.logWarningBlocks("Driver is an instance of QAFExtendedWebDriver");
		else if (AppiumUtils.getAppiumDriver() instanceof IOSDriver)
			ConsoleUtils.logWarningBlocks("Driver is an instance of IOSDriver");
		else if (AppiumUtils.getAppiumDriver() instanceof AndroidDriver)
			ConsoleUtils.logWarningBlocks("Driver is an instance of AndroidDriver");
	}

    @Given("^I am openning daletou '<url>'$")
    public void iAmOpenningDaletouUrl(String arg0) {
		System.out.println(arg0);
		DataBase.openBrower(arg0);
		WebDriver webDriver=DataBase.getWebDiver();
		webDriver.manage().window().maximize();
		Set<String> set=DataBase.getWebDiver().getWindowHandles();
    }
}
