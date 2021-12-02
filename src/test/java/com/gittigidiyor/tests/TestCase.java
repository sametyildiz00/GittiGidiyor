package com.gittigidiyor.tests;

import com.gittigidiyor.pages.Log4j;
import org.asynchttpclient.util.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.gittigidiyor.pages.Constants.*;

public class TestCase extends BaseTest {

    @Test
    public void selectLogin() throws InterruptedException {

        Actions actions = new Actions(driver);


        Log4j.info("Login Page Geç");
        TimeUnit.SECONDS.sleep(2);
        actions.moveToElement(driver.findElement(By.xpath(LOG_IN_XPATH))).click().build().perform();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath(LOG_IN_PAGE)).click();
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Login Ol");
        WebElement userName = driver.findElement(By.id(LOG_IN_ID));
        userName.sendKeys(USER_NAME);
        WebElement password = driver.findElement(By.id(LOG_IN_PASS));
        password.sendKeys(PASSWORD);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id(LOG_IN_CLICK)).click();
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Ürün Arat");
        driver.findElement(By.xpath(CLOSE_COOKIE)).click();
        TimeUnit.SECONDS.sleep(2);
        WebElement search = driver.findElement(By.xpath(SEARCH_XPATH));
        TimeUnit.SECONDS.sleep(2);
        search.sendKeys("telefon");
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();
        //TimeUnit.SECONDS.sleep(2);


        Log4j.info("ScrollDown");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2900)");
        //TimeUnit.SECONDS.sleep(3);


        Log4j.info("Favoriye Atma");
        List<WebElement> getFavProduct = driver.findElements(By.xpath(PRODUCTS_XPATH));
        Random rand = new Random();

        int numberOfSelect = 4;
        for (int i = 0; i < numberOfSelect; i++) {
            int randomIndex = rand.nextInt(getFavProduct.size());
            actions.moveToElement(getFavProduct.get(randomIndex));
            actions.click().build().perform();
            js.executeScript("window.scrollBy(0, 100)");
        }


        Log4j.info("Anasayfa dön Çanta arat");
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().to(URL_MAIN_PAGE);
        TimeUnit.SECONDS.sleep(2);
        WebElement search1 = driver.findElement(By.xpath(SEARCH_XPATH));
        search1.sendKeys("çanta");
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Sepete ekle");
        List<WebElement> getAllProduct = driver.findElements(By.xpath(PRODUCT_SELECT));
        getAllProduct.get(6).click();
        TimeUnit.SECONDS.sleep(2);
        js.executeScript("window.scrollBy(0,500)");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath(ADD_BASKET)).click();
        TimeUnit.SECONDS.sleep(2);
        actions.moveToElement(driver.findElement(By.xpath(GO_TO_BASKET))).click().build().perform();
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Sepette ürün artır");
        actions.moveToElement(driver.findElement(By.xpath(DROP_DOWN))).click().build().perform();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath(INCREASE_PRODUCT)).sendKeys("2", Keys.ENTER);
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Alışverişi tamamla");
        driver.findElement(By.xpath(COMPLETE_SHOP)).click();
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Adrese tıkla hataları gör");
        driver.findElement(By.xpath(CLICK_ADDRESS)).click();
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Sepete düzenleye tıkla");
        driver.findElement(By.xpath(EDIT_BASKET)).click();
        TimeUnit.SECONDS.sleep(2);


        //Favoriden ürün ekleme++
        Log4j.info("Favoriden ürün ekleme");
        driver.navigate().to(URL_FAV_PRODUCTS);
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath(SELECT_PRODUCT)).click();
        TimeUnit.SECONDS.sleep(1);
        js.executeScript("window.scrollBy(0,500)");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath(ADD_BASKET)).click();
        TimeUnit.SECONDS.sleep(4);
        actions.moveToElement(driver.findElement(By.id("header-search-find-link")));
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Favorilere geri dön");
        actions.moveToElement(driver.findElement(By.xpath(PROFILE_DROP_DOWN))).click().build().perform();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath(FAV_DROP_DOWN)).click();
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Favorilerden ürün sil");
        driver.findElement(By.xpath(FAV_SELECT_PRODUCT)).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath(DELETE_FAV_PRODUCT)).click();
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Yan sayfada Anasayfa aç");
        TimeUnit.SECONDS.sleep(2);
        String openNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.xpath(MAIN_PAGE_LOGO)).sendKeys(openNewTab);
        TimeUnit.SECONDS.sleep(2);
        String currentWindow = driver.getWindowHandle();
        Set<String> windowsHandles = driver.getWindowHandles();
        for (String pencere : windowsHandles) {
            if (!currentWindow.equals(pencere)) {
                driver.switchTo().window(pencere);

            }
        }
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("LogOut Ol");
        actions.moveToElement(driver.findElement(By.xpath(DROP_DOWN_ACC))).click().build().perform();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath(LOG_OUT)).click();
        TimeUnit.SECONDS.sleep(2);


        Log4j.info("Sekmeyi kapat");
        driver.close();
        TimeUnit.SECONDS.sleep(2);
    }
}
