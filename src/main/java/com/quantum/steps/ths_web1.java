package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.thsPageObj.pageObj;
import com.quantum.thsPageObj.thsElementList;
import cucumber.api.java.en.Given;

@QAFTestStepProvider
public class ths_web1 {
    pageObj pageObj=new pageObj();
    @Given("^open ths website$")
    public void openThsWebsite() throws InterruptedException {
        DataBase.openBrower("http://www.10jqka.com.cn/");
        DataBase.getWebDiver().manage().window().fullscreen();
        pageObj.Login_but.waitForPresent(6000);
        pageObj.Login_but.click();
    }
}
