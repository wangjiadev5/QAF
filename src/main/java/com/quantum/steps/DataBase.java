package com.quantum.steps;

import com.perfectomobile.selenium.MobileDevice;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.util.QAFWebElementWait;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.AppiumUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataBase {
    public static  void openBrower(String path){
        new WebDriverTestBase().getDriver().get(path);
    }
    public static void clickByXpathAndInput(String locator,String content) throws InterruptedException {
        Thread.sleep(4000);
        WebElement webElement=getWebDiver().findElement(By.xpath(locator));
        webElement.click();
        webElement.clear();
        webElement.sendKeys(content);
    }
    public static void clickByXpath(String locator){
        System.out.println(locator);
        WebElement webElement=getWebDiver().findElement(By.xpath(locator));
        System.out.println("wel=========="+webElement);
        webElement.click();
    }
    public static List<WebElement> findElementsByxpath(String locator){
        List<WebElement> list= getWebDiver().findElements(By.xpath(locator));
        return list;
    }

    public static WebDriver switchIfream(){
        WebDriver ifreamwebDriver=new WebDriverTestBase().getDriver().switchTo().frame("sb_frame");
        System.out.println("ifreamwebDriver--------->"+ifreamwebDriver);
        return ifreamwebDriver;
    }

    public static WebDriver getWebDiver()
    {
        return new WebDriverTestBase().getDriver();
    }


    public static void clickById(String id) {
//        new QAFExtendedWebElement(id).click();

    }

    public static void androidSwipeScreen(AndroidDriver driver,String text) throws InterruptedException {
        String xpath="//android.widget.RelativeLayout[@content-desc=\""+text+"\"]";
        while (true)
        {
            System.out.println(xpath);
            if(driver.getPageSource().contains(text))
            {
                Thread.sleep(6000);
                driver.findElement(By.xpath(xpath)).click();
                break;
            }
           else
            {
                TouchAction touchAction=new TouchAction(driver);
                int hight=driver.manage().window().getSize().getHeight()/3;
                int width=driver.manage().window().getSize().getWidth();
                touchAction.press(PointOption.point(width-50,hight));
                touchAction.moveTo(PointOption.point(0,hight)).release().perform();
            }
        }
    }

    public AndroidDriver getAndroidDriver(){
        AndroidDriver driver=null;
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "127.0.0.1:62001");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("platformName", "Android");
//            capabilities.setCapability("udid", "R28M316YWYF");
            capabilities.setCapability("appPackage", "android.zhibo8");
            capabilities.setCapability("appActivity", "android.zhibo8.ui.contollers.main.MainActivity");
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.getBatteryInfo();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
