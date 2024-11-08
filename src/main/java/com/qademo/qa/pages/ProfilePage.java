package com.qademo.qa.pages;

import com.qademo.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends TestBase {
    //Use PageFactory

    //Initializing the page Objects
    public ProfilePage(){
        PageFactory.initElements(driver,this);
    }
}
