package com.lenovohit.mgcore.uiautomator;

import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

/**
 * 自动化测试封装类
 * Created by yuzhijun on 2016/6/24.
 */
public class ClickHandler extends UiAutomatorTestCase{

    private static final int CLICK_ID = 2000;
    private static final int CLICK_TEXT = 2001;

    public boolean clickById(String id){
        return clickByInfo(CLICK_ID,id);
    }

    public boolean clickByText(String text){
        return clickByInfo(CLICK_TEXT,text);
    }

    private boolean clickByInfo(int CLICK,String str){
        UiSelector mUiSelector = null;

        switch (CLICK){
            case CLICK_ID:mUiSelector = new UiSelector().resourceId(str);break;
            case CLICK_TEXT:mUiSelector = new UiSelector().text(str);break;
            default:return false;
        }

        UiObject mUiObject = new UiObject(mUiSelector);
        int i = 0;
        while (!mUiObject.exists() && i <5){
            solveProblems();
            sleep(500);
            if (i == 4){
                takeScreen(getUiDevice(),str +"-not-find");
                UiAutomationLog(str + "not find");
                return false;
            }
            i++;
        }
        try{
            mUiObject.click();
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }

    //解决失败的一些弹出框关闭等等
    public void solveProblems(){

    }

    public void takeScreen(UiDevice uiDevice,String des){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        String dateStr = calendar.get(Calendar.HOUR_OF_DAY) +"_"+calendar.get(Calendar.MINUTE)+"_"+ calendar.get(Calendar.SECOND);
        File files = new File("/mnt/sdcard/" + dateStr +"_"+ des + ".jpg");
        uiDevice.takeScreenshot(files);
    }

    public String m_logpathString = "/mnt/sdcard/PerformanceLog.txt";

    public void UiAutomationLog(String str){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        String dateStr = calendar.get(Calendar.HOUR_OF_DAY) +"_"+calendar.get(Calendar.MINUTE)+"_"+ calendar.get(Calendar.SECOND);

        FileWriter fwlog = null;
        try{
            fwlog = new FileWriter(m_logpathString,true);
            fwlog.write(dateStr +str +"\r\n");
            System.out.println(dateStr+str);
            fwlog.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                fwlog.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
