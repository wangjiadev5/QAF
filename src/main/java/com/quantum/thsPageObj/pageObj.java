package com.quantum.thsPageObj;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;


public class pageObj extends WebDriverBaseTestPage<WebDriverTestPage> implements thsPageLoc {

    @FindBy(locator = THS_LOGIN_BUT_LOC )
    public QAFExtendedWebElement Login_but;

    @FindBy(locator = THS_LOGIN_INOUT_MOBILE_LOC )
    public QAFExtendedWebElement Mobile_Input;


    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
