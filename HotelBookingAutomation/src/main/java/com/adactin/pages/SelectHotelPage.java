package com.adactin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {

    WebDriver driver;

    public SelectHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "radiobutton_0")
    WebElement selectRadioButton;

    @FindBy(id = "continue")
    WebElement continueButton;

    public void selectHotel() {
        selectRadioButton.click();
        continueButton.click();
    }
}
