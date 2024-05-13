package com.viger.Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectExample 
{
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		//driver.get("http://localhost:100");
		//driver.findElement(By.name("login_theme")).sendKeys("orange");
		//WebElement elm = driver.findElement(By.name("login_theme"));
		//Select sel = new Select(elm);//select is amethod and elm is a constructor.
		/*
		sel.selectByIndex(0);
		Thread.sleep(2000);
		sel.selectByVisibleText("orange");//VisibleText this line work as sendkeys
		Thread.sleep(2000);
		sel.selectByValue("blue");
		*/
		driver.get("file:///D:/Selenium_Batch24/multiselecteddropsown.html");
		Select s = new Select(driver.findElement(By.name("country")));
		s.selectByVisibleText("India");
		s.selectByVisibleText("Pakistan");
		s.selectByVisibleText("US");
		s.deselectByValue("Pakistan");//delselect the perticular value.
		
		List<WebElement> ls = s.getOptions();//print list of all count country
		System.out.println("size="+ls.size());
		
		System.out.println(s.getFirstSelectedOption().getText());//visible bydefault selected value in webpage.
		System.out.println(s.getAllSelectedOptions().toString());//how many option selected in webpage.
	    System.out.println(s.isMultiple());//in the dropdown available multiple options or not
	}
	

}	
