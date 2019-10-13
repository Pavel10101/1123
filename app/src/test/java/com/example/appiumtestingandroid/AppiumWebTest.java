package com.example.appiumtestingandroid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumWebTest {

    private static AndroidDriver driver;

    @BeforeSuite
    public static void setUp() throws MalformedURLException {
        // Set the app
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.VERSION, "8.1.0");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for x86");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

    }

    @Test(priority = 0)
    public void loginOnMainPage() {
        driver.get("https://m.facebook.com");
        driver.findElement(By.id("m_login_email")).sendKeys("mylogin");
        driver.findElement(By.id("m_login_password")).sendKeys("mypassword");
        driver.findElement(By.name("login")).click();
        }

    @Test(priority = 1)
    public void createNewAccount() {
        driver.get("https://m.facebook.com");
        driver.findElement(By.id("signup-button")).click();
        }

    @AfterSuite
    public static void teardown(){
        // Close the app
        driver.quit();
    }

}