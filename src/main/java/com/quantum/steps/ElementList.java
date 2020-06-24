package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ElementList {
    public static final String LIANCHUANGUOGUAN="//span[@class='parlay filters']";
    public static final String TIYUSAISHI="//li[@class='cur']/a";
    public static final String LANQIU="(//div[@class='mg-r-6 lht-1p3'])[2]";
    public static final String USERNAME="//input[@id='uid']";
    public static final String PASSWORD="//input[@id='jpwd']";
    public static final String LOGING="//a[@id=\"gologin\"]";
    public static final String SINA_TABLE="(//table[@id=\"chartsTable\"]/tbody)[1]/tr";
    public static final String SINA_TABLE_120="(//div[@class=\"msize\"]/span)[3]";



    //小豆苗界面元素
    public static final String xdm_password_login="com.threegene.yeemiao:id/a7q";
    public static final String xdm_username="com.threegene.yeemiao:id/r7";
    public static final String xdm_password="com.threegene.yeemiao:id/r3";
    public static final String xdm_login_but="com.threegene.yeemiao:id/a4k";
    public static final String xdm_allow_premission="android:id/button1";
    public static final String xdm_alert_allow="com.threegene.yeemiao:id/ut";
    public static final String xdm_alert_cancel="com.threegene.yeemiao:id/fd";
    public static final String xdm_yuyuejiezhong="com.threegene.yeemiao:id/ak";
    public static final String xdm_yufangjiezhong="//android.widget.CheckedTextView[@text=\"预防接种\"]";
    public static final String xdm_yuyueriqi="//*[@text=\"20\"]";


    //同花顺界面元素
    public static final String ths_hangqing="//android.widget.RelativeLayout[@content-desc=\"行情\"]";
    public static final String ths_diefu_id="com.hexin.plat.android:id/price_fall_tab";
    public static final String ths_diefu_first_item="//androidx.recyclerview.widget.RecyclerView[@id='com.hexin.plat.android:id/stock_list_recycle_view']/android.widget.LinearLayout";




    @FindBy(locator = "search.text.box")
    private QAFWebElement element;



}
