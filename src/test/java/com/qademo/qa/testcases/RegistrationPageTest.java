package com.qademo.qa.testcases;

import com.qademo.qa.base.TestBase;
import com.qademo.qa.pages.ProfilePage;
import com.qademo.qa.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPageTest extends TestBase {
    RegistrationPage registrationPage;
    ProfilePage profilePage;
    public RegistrationPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        registrationPage=new RegistrationPage();
    }
    @Test(priority = 1)
    public void registrationpageTitle(){
        registrationPage.openRegistrationPage();
        String title= registrationPage.validatePageTitle();
        Assert.assertEquals(title,"DEMOQA");
    }
    @Test(priority = 2)
    public void completeRegistration(){
        registrationPage.openRegistrationPage();
        profilePage=registrationPage.doRegistration("Din","Obaydul","Obaydul123","Obd12@#");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
