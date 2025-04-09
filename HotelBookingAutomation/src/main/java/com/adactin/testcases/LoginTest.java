package com.adactin.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.adactin.base.BaseClass;
import com.adactin.pages.LoginPage;

public class LoginTest extends BaseClass {

    LoginPage login;

    @BeforeClass
    public void setup() {
        loadConfig();      // from BaseClass
        launchBrowser();   // from BaseClass
        login = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        login.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterClass
    public void teardown() {
        tearDown();        // from BaseClass
    }
}
