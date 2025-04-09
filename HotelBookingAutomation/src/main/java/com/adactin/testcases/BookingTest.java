package com.adactin.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.adactin.base.BaseClass;
import com.adactin.pages.*;
import com.adactin.utility.ExcelUtils;
import com.adactin.reports.ExtentReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;

public class BookingTest extends BaseClass {

    LoginPage login;
    SearchHotelPage searchHotel;
    SelectHotelPage selectHotel;
    BookHotelPage bookHotel;
    ConfirmationPage confirmation;

    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setUp() {
        // Initialize Extent Report
        extent = ExtentReportManager.getReportInstance();
        test = extent.createTest("Hotel Booking Test");

        // Browser & Pages setup
        loadConfig();
        launchBrowser();
        login = new LoginPage(driver);
        searchHotel = new SearchHotelPage(driver);
        selectHotel = new SelectHotelPage(driver);
        bookHotel = new BookHotelPage(driver);
        confirmation = new ConfirmationPage(driver);
    }

    @Test
    public void hotelBookingTest() throws IOException {
        try {
            // Load Excel data
            ExcelUtils.setExcelFile("testdata/TestData.xlsx", "Sheet1");

            // Read data
            String username = ExcelUtils.getCellData(1, 0);
            String password = ExcelUtils.getCellData(1, 1);
            String location = ExcelUtils.getCellData(1, 2);
            String roomType = ExcelUtils.getCellData(1, 3);
            String fname = ExcelUtils.getCellData(1, 4);
            String lname = ExcelUtils.getCellData(1, 5);
            String address = ExcelUtils.getCellData(1, 6);
            String ccNum = ExcelUtils.getCellData(1, 7);
            String ccType = ExcelUtils.getCellData(1, 8);
            String month = ExcelUtils.getCellData(1, 9);
            String year = ExcelUtils.getCellData(1, 10);
            String cvv = ExcelUtils.getCellData(1, 11);

            // Perform actions
            login.loginToApp(username, password);
            test.log(Status.PASS, "Login successful");

            searchHotel.searchHotel(location, roomType);
            test.log(Status.PASS, "Hotel search successful");

            selectHotel.selectHotel();
            test.log(Status.PASS, "Hotel selected successfully");

            bookHotel.bookHotel(fname, lname, address, ccNum, ccType, month, year, cvv);
            test.log(Status.PASS, "Hotel booking completed");

            String orderNo = confirmation.getOrderNumber();
            test.log(Status.PASS, "Booking confirmed. Order Number: " + orderNo);

        } catch (Exception e) {
            test.log(Status.FAIL, "Test failed due to: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDownTest() {
        tearDown();         // Close browser
        extent.flush();     // Write ExtentReport to file
    }
}