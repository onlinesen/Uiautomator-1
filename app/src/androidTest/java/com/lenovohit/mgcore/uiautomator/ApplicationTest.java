package com.lenovohit.mgcore.uiautomator;

import android.app.Application;
import android.app.UiAutomation;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.ApplicationTestCase;

import java.io.IOException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends UiAutomatorTestCase {

    public void testDemo() throws IOException, UiObjectNotFoundException {
        Runtime.getRuntime().exec("am start com.lenovohit.dashboard/com.lenovohit.dashboard.ui.DB_LoginActivity");
        sleep(3000);

        UiDevice mDevice = getUiDevice();
        ClickHandler mClickHandler = new ClickHandler();

//        UiObject loginBtn = new UiObject(new UiSelector().resourceId("com.lenovohit.dashboard:id/btnLogin"));
//        loginBtn.click();
//        sleep(2000);

        mClickHandler.clickById("com.lenovohit.dashboard:id/btnLogin");
    }
}