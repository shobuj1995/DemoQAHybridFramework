package com.qademo.qa.base;

import com.qademo.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    static Properties prop;
    public TestBase(){
        try {
            prop=new Properties();
            FileInputStream inputStream=new FileInputStream(
                    System.getProperty("user.dir")+"/src/main/java/com/qademo/qa/config/config.properties"
            );
            prop.load(inputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void initialization(){
        String browseName=prop.getProperty("browser");
        if(browseName.equals("chrome")){
            driver=new ChromeDriver();
        } else if (browseName.equals("firefox")) {
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
