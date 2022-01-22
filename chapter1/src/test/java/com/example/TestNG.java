package com.example;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        // set path of Chromedriver executable
        System.setProperty("webdriver.chrome.driver",
                "./src/test/resources/drivers/chromedriver.exe");

        // initialize new WebDriver session
        driver = new ChromeDriver();
    }

    @Test
    public void navigateToAUrl() {
        // navigate to the web site
        driver.get("https://www.ebay.com/");
        // Validate page title
        Assert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
    }
    
    @Test
    public void selectBooks() {
    	driver.get("https://www.ebay.com/");
    	//Select objSelect =new Select(driver.findElement(By.id("gh-cat")));
    	Select objSelect = new Select(driver.findElement(By.xpath("//*[@id='gh-cat']")));
    	objSelect.selectByVisibleText("Books");
    	//click on search button
    	driver.findElement(By.xpath("//*[@id='gh-btn']")).click();
    	 
    }
    @Test
    public void searchBooks() {
    	driver.get("https://www.ebay.com/");
    	//Select objSelect =new Select(driver.findElement(By.id("gh-cat")));
    	Select objSelect = new Select(driver.findElement(By.xpath("//*[@id='gh-cat']")));
    	objSelect.selectByVisibleText("Books");
    	//click on search button
    	driver.findElement(By.xpath("//*[@id='gh-btn']")).click();
    	 
    }
    
    
    
    
   /* @AfterMethod
    public void afterMethod() {

        // close and quit the browser
        driver.quit();
    }
    
 */
}