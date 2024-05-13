package com.vtiger.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.stepdefinitions.BaseDefinition;

public class PageAction
{
	private WebDriver driver;
	WebDriverWait wait;//globally define the wait,we have to access easily
	//private WebElement eml;
	
	public PageAction(WebDriver driver)
	{
		this.driver = driver; //this is represent the current class.
		wait = new WebDriverWait(driver,Duration.ofSeconds(0));//this is wait object"driver"and "Duration.ofSeconds(20)" is two parameter. this is explicit  wait 
	}
	
	public String getScreenshot()
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddmmyyhhmmss");
		String fileName = ft.format(d);
		String path = System.getProperty(("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png");
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File ScrFile = ts.getScreenshotAs(OutputType.FILE);
		//move image file to new destination
		File DestFile = new File(path);
		//copy file at destination
		try
		{
			FileUtils.copyFile(ScrFile,DestFile);
		}catch(IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}
	
	public void validate_Expected_Actual_Tēxt(String exp, String act, String msg)
	{
		if(exp.equals(act))
		{
			BaseDefinition.logger.pass(msg);
		}
		else
		{
			BaseDefinition.logger.fail("comparison failed beacuse expected text is "+exp+" and actual was "+act+" "<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}

	
	public void setText(WebElement elm, String value, String msg)//this is method overloading 
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(value);//stored the value in yhe sendkeys.
		BaseDefinition.logger.pass(msg);//call the logger from BaseDefinition class and print the message
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			BaseDefinition.logger.fail("step falied due to error "+e.getMessage()+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	
	public void setText(By elm, String value)//this is method overloading, support the different parameter using "BY" through
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(elm)));
		driver.findElement(elm).clear();
		driver.findElement(elm).sendKeys(value);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void setText(String elm, String value)//this is method overloading,this is String format
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elm))));
		driver.findElement(By.xpath(elm)).clear();
		driver.findElement(By.xpath(elm)).sendKeys(value);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
		
		public void clickElement(WebElement elm, String msg)
		{
			try
			{
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			elm.click();
			BaseDefinition.logger.pass(msg);//call the logger from BaseDefinition class
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			BaseDefinition.logger.fail("step falied due to error "+e.getMessage()+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
		}
		
			public void clickExits(WebElement elm)//tis is element exit method overloading using this method visible of the element.
			{
				try
				{
				wait.until(ExpectedConditions.visibilityOf(elm));//explixit wait
				elm.isDisplayed();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
	}
			
			public void selectText(WebElement elm, String value,String msg)//this is method overloading,this code is select the value of deopdown llist
			{
				try
				{
				wait.until(ExpectedConditions.visibilityOf(elm));
				Select sel = new Select(elm);
				sel.selectByVisibleText(value);
				elm.sendKeys(value);
				BaseDefinition.logger.pass(msg);//call the logger from BaseDefinition class
				}
				catch (Exception e) 
				{
					e.printStackTrace();
					BaseDefinition.logger.fail("step falied due to error "+e.getMessage()+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
				}
			}

}
