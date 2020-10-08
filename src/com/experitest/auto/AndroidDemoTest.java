package com.experitest.auto;


import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



public class AndroidDemoTest extends BaseTest {
	protected AndroidDriver<AndroidElement> driver = null;
	private String testName = "Unititled";
	 int count=0;
	JsonArray jarray = new JsonArray();
	@Test
	public void setUp() throws Exception{
		dc.setCapability("testName", testName);  
        dc.setCapability(MobileCapabilityType.UDID, "PDAGAA48C1801900");      
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zhiliaoapp.musically");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.ss.android.ugc.aweme.splash.SplashActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
        Thread.sleep(5000);
	}
	
	@Test
	public void test() throws InterruptedException, IOException{

        Thread.sleep(5000);
        horizontalSwipeByPercentage (0.2,0.8 ,0.2 );
		
	}
	
	  @Test
	public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) throws InterruptedException, IOException {
	    System.out.println(count);
	  
		if(count<100){  
		  count++;
		  Dimension size = driver.manage().window().getSize();
	      int anchor = (int) (size.height * anchorPercentage);
	      int startPoint = (int) (size.width * startPercentage);
	      int endPoint = (int) (size.width * endPercentage);

	      String text = driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).getText();
          Thread.sleep(1500);
          driver.findElement(By.xpath("//*[@id='csq']")).click();
          driver.findElement(By.xpath("//*[@id='cse' and (./preceding-sibling::* | ./following-sibling::*)[@text='Copy link']]")).click();
  	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@id='bsd']]")));
  	      driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@id='bsd']]")).click();
         
          new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ah6']")));
          driver.findElement(By.xpath("//*[@id='ah6']")).click();
          
          String result  = driver.findElement(By.xpath("//*[@id='clipboard_paste_chip_text']")).getText();
          Thread.sleep(1500);
          
          JsonObject jobject = new JsonObject();
          jobject.addProperty("title",text );
          jobject.addProperty("result",result );
          jarray.add(jobject);
          
          
          
  
          new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='com.zhiliaoapp.musically:id/km']")));
          driver.findElement(By.xpath("//*[@resource-id='com.zhiliaoapp.musically:id/km']")).click();
          
          new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //*[@class='android.widget.ImageView' and ./parent::*[@id='bse']]")));
          driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@id='bse']]")).click();
          Thread.sleep(1500);                     
	      new TouchAction(driver).press(PointOption.point(233, 752)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(378))).moveTo(PointOption.point(201, 12)).release().perform();     
	      horizontalSwipeByPercentage (0.2,0.8 ,0.2 );
	      
		}
		else{
			Report data = new Report();
			 System.out.println(jarray);
	        data.report(jarray);
	      
			
		}
	    
	  }



}
