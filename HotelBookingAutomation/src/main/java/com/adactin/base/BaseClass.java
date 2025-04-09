package com.adactin.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;

    // Load config.properties
    public void loadConfig() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("config/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Config file not found: " + e.getMessage());
        }
    }

    // Initialize browser
    public void launchBrowser() {
        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser name in config");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
    }

    // Close browser
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
