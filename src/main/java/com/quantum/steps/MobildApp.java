package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.UiDriver;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import cucumber.api.java.en.Given;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.lang.model.element.Element;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

@QAFTestStepProvider
public class MobildApp {
    DataBase dataBase=new DataBase();
    @Given("^Start zhibo(\\d+) app$")
    public void startZhiboApp(int arg0) {
            AndroidDriver driver=dataBase.getAndroidDriver();

    }

    @Given("^open app$")
    public void openApp() {
        AndroidDriver driver=null;
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "xiaomi");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "6e1bd4dc7d04");
            capabilities.setCapability("appPackage", "com.threegene.yeemiao");
            capabilities.setCapability("appActivity", "com.threegene.module.splash.ui.SplashActivity");
            capabilities.setCapability("automationName", "uiautomator2");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            String id="com.threegene.yeemiao:id/tt";
            driver.findElementById(id).click();
            driver.findElementById(ElementList.xdm_password_login).click();
            driver.findElementById(ElementList.xdm_username).sendKeys("18328510940");
            driver.findElementById(ElementList.xdm_password).sendKeys("856413291w..");
            driver.hideKeyboard();
            System.out.println("------------------>"+driver.getContext());
            driver.findElementById(ElementList.xdm_login_but).click();
            Thread.sleep(6000);
            for (int i = 0; i < 3; i++) {
                driver.findElementById(ElementList.xdm_allow_premission).click();
            }
            try {
                Thread.sleep(5000);
                if(driver.getPageSource().contains("根据最新政策要求"))
                {
                    driver.findElement(By.id(ElementList.xdm_alert_allow)).click();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElementById(ElementList.xdm_alert_cancel).click();
            driver.findElementByXPath(ElementList.xdm_yufangjiezhong).click();
            driver.findElementById(ElementList.xdm_yuyuejiezhong).click();
            QAFWebElement webElement= (QAFWebElement) driver.findElementByXPath(ElementList.xdm_yuyueriqi);
            webElement.waitForEnabled(1000*60*60*24);
            webElement.click();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Given("^Click app$")
    public void clickApp() {
        AndroidDriver driver=null;
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "xiaomi");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "6e1bd4dc7d04");
            capabilities.setCapability("appPackage", "com.miui.home");
            capabilities.setCapability("appActivity", "com.miui.home.launcher.Launcher");
            capabilities.setCapability("automationName", "uiautomator2");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            Thread.sleep(9000);
            DataBase.androidSwipeScreen(driver,"小豆苗");
            Thread.sleep(6000);
            driver.findElementByXPath(ElementList.xdm_yufangjiezhong).click();
            driver.findElementById(ElementList.xdm_yuyuejiezhong).click();
            driver.findElement(By.xpath(ElementList.xdm_yuyueriqi)).click();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
