package com.gittigidiyor.tests;

import com.gittigidiyor.pages.Log4j;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.get("https://www.gittigidiyor.com/");
    }



    @After
    public void tearDown(){
        Log4j.info("Pencereyi Kapat");
        driver.quit();
    }

}
