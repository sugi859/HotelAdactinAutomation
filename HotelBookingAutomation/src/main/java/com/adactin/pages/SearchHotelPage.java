package com.adactin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {

    WebDriver driver;

    public SearchHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "location")
    WebElement locationDropdown;

    @FindBy(id = "room_type")
    WebElement roomTypeDropdown;

    @FindBy(id = "Submit")
    WebElement searchButton;

    public void selectLocation(String location) {
        locationDropdown.sendKeys(location);
    }

    public void selectRoomType(String roomType) {
        roomTypeDropdown.sendKeys(roomType);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void searchHotel(String location, String roomType) {
        selectLocation(location);
        selectRoomType(roomType);
        clickSearch();
    }
}
