package com.quantum.steps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

//import com.sun.javafx.stage.WindowHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@QAFTestStepProvider
public class GoogleStepDefs {
	@Given("^I am on Google Search Page$")
	public void I_am_on_Google_Search_Page() {
		new WebDriverTestBase().getDriver().get("http://www.google.com/");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String searchKey) {
		QAFExtendedWebElement searchBoxElement = new QAFExtendedWebElement("search.text.box");
		QAFExtendedWebElement searchBtnElement = new QAFExtendedWebElement("search.button");

		searchBoxElement.clear();
		searchBoxElement.sendKeys(searchKey);
		// Web and mobile elements are sometimes different so we have done two things we
		// used multiple/alternate locator strategy for finding the element.
		// We also used Javascript click because the element was getting hidden in
		// Desktop Web due to suggestions and was not clickable. This java script click
		// will work for both desktop and mobile in this case.
		JavascriptExecutor js =  DeviceUtils.getQAFDriver();
		js.executeScript("arguments[0].click();", searchBtnElement);
	}

	@Then("^it should have \"([^\"]*)\" in search results$")
	public void it_should_have_in_search_results(String result)  {
		QAFExtendedWebElement searchResultElement = new QAFExtendedWebElement("partialLink=" + result);
		searchResultElement.verifyPresent(result);
	}

	@Then("^it should have following search results:$")
	public void it_should_have_all_in_search_results(List<String> results) {
		QAFExtendedWebElement searchResultElement;
		for (String result : results) {
			searchResultElement = new QAFExtendedWebElement("partialLink=" + result);
			searchResultElement.verifyPresent(result);
		}
	}


	@Given("^I am openning wanbo url$")
	public void iAmOpenningWanboUrl() throws InterruptedException {
//		DataBase.openBrower();
		WebDriver webDriver=DataBase.getWebDiver();
		webDriver.manage().window().maximize();
		Set<String> set=DataBase.getWebDiver().getWindowHandles();
		System.out.println("windhandle----"+set.size());
		DataBase.clickByXpathAndInput(ElementList.USERNAME,"wjdxx");
		DataBase.clickByXpathAndInput(ElementList.PASSWORD,"Tt123456");
		DataBase.clickByXpath(ElementList.LOGING);
		Thread.sleep(6000);
		DataBase.switchIfream();
//		DataBase.clickByXpath(ElementList.TIYUSAISHI);
//		Thread.sleep(6000);
		DataBase.clickByXpath(ElementList.LIANCHUANGUOGUAN);
		System.out.println("点击成功");
		Thread.sleep(16000);
		DataBase.clickByXpath("(//div[@class='dsp-iblk t-va-m lht-0p3 pd-l-10 pd-r-10 filters ft-c-6'])[1]");
		Thread.sleep(16000);
//		((//table[@class='width-100p']/thead)[2]/tr/th/span)[2]
		List<WebElement> list=DataBase.findElementsByxpath("//table[@class='width-100p']/tbody/tr/td[@class='t-a-c col-1x2']/span");
		int count=0;
		for (int i = 0; i < list.size(); i++) {
			String value=list.get(i).getText();
			if (!"".equals(value)&&Float.parseFloat(value)<1.62&&Float.parseFloat(value)>1.52) {
				list.get(i).click();
				System.out.println("你选择的是："+list.get(i).getAttribute("title")+list.get(i).getText());

				count++;
				if (count==2)
				{
					break;
				}
			}
		}
//        File f=new File("D:\\peilv.txt");
//        FileWriter fileWriter=new FileWriter(f,true);
//		for (int i = 0; i < list.size(); i++) {
//			String value=list.get(i).getText();
//            fileWriter.write(list.get(i).getAttribute("title")+value+"\r\n");
//			fileWriter.flush();
//			}
//	}
		DataBase.clickByXpathAndInput("//div[@class='float-left ft-c-3']/div/input","10");
		Thread.sleep(6000);
		DataBase.clickByXpath("(//div[@class='pd-t-10'])[1]/div/div");
		System.out.println("购买成功");
		Thread.sleep(6000);
	}

	@Given("^I am openning daletou \"([^\"]*)\"$")
	public void iAmOpenningDaletou(String arg0){
		DataBase.openBrower(arg0);
		WebDriver webDriver=DataBase.getWebDiver();
		webDriver.manage().window().maximize();
	}

	@And("^get caipiao table$")
	public void getCaipiaoTable() {
		try {
			DataBase.clickByXpath(ElementList.SINA_TABLE_120);
			Thread.sleep(3000);
			List<WebElement> list=DataBase.findElementsByxpath(ElementList.SINA_TABLE);
			int count=0;
			for (int i = 0; i < list.size(); i++) {
				String value=list.get(i).getText();
				System.out.println(value);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


//	@Given("^I am openning wanbo \"([^\"]*)\"$")
//	public void iAmOpenningWanbo(String arg0) {
//		System.out.println(arg0);
//		DataBase.openBrower(arg0);
//		DataBase.clickByXpath(ElementList.LIANCHUANGUOGUAN);
//		DataBase.clickByXpath(ElementList.LANQIU);
//		WebDriver webDriver=DataBase.getWebDiver();
//		List list=webDriver.findElements(By.xpath("(//div[@id='sp2'])[5]"));
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//	}
}