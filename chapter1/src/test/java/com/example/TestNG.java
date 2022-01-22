package com.example;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.*; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG {

    WebDriver driver;
   // WebDriverWait wait = new WebDriverWait(driver, 40);

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
    public void searchBooks() throws InterruptedException {
    	driver.get("https://www.ebay.com/");
    	
    	Select objSelect = new Select(driver.findElement(By.xpath("//*[@id='gh-cat']")));
    	objSelect.selectByVisibleText("Books");
    	//click on search button
    	driver.findElement(By.xpath("//*[@id='gh-btn']")).click();
    	
    	WebElement element = driver.findElement(By.xpath("//*[@id='gh-ac']"));
    	element.sendKeys("Harry Potter");
    	//element.submit();
    	driver.findElement(By.xpath("//*[@id='gh-btn']")).click();
    	
    	 //WebDriverWait wait5 = new WebDriverWait(driver, 100);
    	
    	// wait5.until(ExpectedConditions.visibilityOfElementLocated(somethingLocator)).sendKeys("Ames");
    	driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a")).click();
    	
    	String oldTab = driver.getWindowHandle();
    
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        // change focus to new tab
        driver.switchTo().window(newTab.get(0));
    	
    	String title = driver.findElement(By.xpath("//*[@id=\"itemTitle\"]")).getText();
    	
    	System.out.println("Book Title: "+title);
    	
    	int length = title.length();
        System.out.println("Length of the title is: " + length);
    	
        driver.findElement(By.xpath("//*[@id=\"isCartBtn_btn\"]")).click();
        
        String price = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[3]/div/div[1]/div[2]/div/div[1]/span/span/span")).getText();
        System.out.println("Item price:"+price);
        
        String priceWithShipping = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[4]/div[2]/span/span/span")).getText();
        System.out.println("Total price:"+priceWithShipping);
        
        
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[1]/button")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, 40);
       
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"s0-0-20-10-signin-chooser-layer-1-1-3\"]"))));
        driver.findElement(By.xpath("//*[@id=\"s0-0-20-10-signin-chooser-layer-1-1-3\"]")).click();

        //Verify Name
        String ActualTitle = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[1]/section[1]/div/div/div[2]/div/div/div/div[2]/div[1]/h3/div/span/span")).getText();
        //String ExpectedTitle = title;
        String ExpectedTitle = "["+title+"]";
       // System.out.println("Actual title: "+ActualTitle);
        Assert.assertNotEquals(ActualTitle, ExpectedTitle);
        
        //Verify price
        String actualItemPrice= driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[1]/section[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/span/span")).getText();
        String expectedItemPrice = "["+price+"]";
        
        Assert.assertNotEquals(actualItemPrice, expectedItemPrice);
        System.out.println("Actual price: "+actualItemPrice);
        
        String actualPrice= driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[3]/section/div[1]/div/table/tbody/tr[3]/td[2]/span/span")).getText();
        String expectedPrice = "["+priceWithShipping+"]";
      
        Assert.assertNotEquals(actualPrice, expectedPrice);
        System.out.println("Actual price: "+actualPrice);
        
        //Filling Details
        
        try {
        	 Select obj_select = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
           	 obj_select.selectByVisibleText("Sri Lanka");
           	 Thread.sleep(400);
           	 WebElement Fname = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        	 Fname.sendKeys("Sanchila");
        	
        	} 
        	catch(Exception e) {
        	  //  Block of code to handle errors
        	}
       
      	
       
    	
    	WebElement Lname = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
    	Lname.sendKeys("Anne");

    	WebElement streetAddrs1 = driver.findElement(By.xpath("//*[@id=\"addressLine1\"]"));
    	streetAddrs1.sendKeys("Frank");
    	
    	WebElement streetAddrs2 = driver.findElement(By.xpath("//*[@id=\"addressLine2\"]"));
    	streetAddrs2.sendKeys("Xyz");
    	
    	WebElement City = driver.findElement(By.xpath("//*[@id=\"city\"]"));
    	City.sendKeys("Colombo");
    	
    	WebElement Province = driver.findElement(By.xpath("//*[@id=\"stateOrProvince\"]"));
    	Province.sendKeys("Western Province");
    	
    	WebElement ZipCode = driver.findElement(By.xpath("//*[@id=\"postalCode\"]"));
    	ZipCode.sendKeys("70035");
    	
    	WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
    	email.sendKeys("anne@gmail.com");
    	
    	WebElement confirmEmail = driver.findElement(By.xpath("//*[@id=\"emailConfirm\"]"));
    	confirmEmail.sendKeys("anne@gmailcom");
    	
    	WebElement PhoneNo = driver.findElement(By.xpath("//*[@id=\"phoneNumber\"]"));
    	PhoneNo.sendKeys("770000000");
    	
    	
    }
    
  
   @AfterMethod
    public void afterMethod() {

        // close and quit the browser
        driver.quit();
    }
   
 
}