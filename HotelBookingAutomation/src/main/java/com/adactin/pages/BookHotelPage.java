package com.adactin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage {

    WebDriver driver;

    public BookHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "cc_num")
    WebElement ccNumber;

    @FindBy(id = "cc_type")
    WebElement ccType;

    @FindBy(id = "cc_exp_month")
    WebElement ccExpMonth;

    @FindBy(id = "cc_exp_year")
    WebElement ccExpYear;

    @FindBy(id = "cc_cvv")
    WebElement ccCVV;

    @FindBy(id = "book_now")
    WebElement bookNowButton;

    public void bookHotel(String fname, String lname, String addr, String ccNum,
                          String ccTypeVal, String month, String year, String cvv) {
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        address.sendKeys(addr);
        ccNumber.sendKeys(ccNum);
        ccType.sendKeys(ccTypeVal);
        ccExpMonth.sendKeys(month);
        ccExpYear.sendKeys(year);
        ccCVV.sendKeys(cvv);
        bookNowButton.click();
    }
}
