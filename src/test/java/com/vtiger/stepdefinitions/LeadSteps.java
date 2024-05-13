package com.vtiger.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.When;

public class LeadSteps extends BaseDefinition
{
	
	@When("user click on new lead link")
	public void click_new_lead1()
	{
		driver.findElement(By.linkText("New Lead")).click();	
	}
	@When("fill all mandatory fields and click on save button")
	public void fill_mandatory_lead_form()
	{
		
		driver.findElement(By.name("lastname")).sendKeys(dt.get(TCName).get("LatName"));
		driver.findElement(By.name("company")).sendKeys(dt.get(TCName).get("Company"));
		driver.findElement(By.name("button")).click();
	}
	@When("lead should be created successfully")//validate code
	public void lead_created_successfully()
	{

		driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals("abc");
		driver.findElement(By.xpath("//td[text()='Company:']/following::td[1]")).getText().equals("eclerx");
		
	}
	@When("user creats multiple leads with {string} and {string} verified")
	public void user_creats_multiple_leads_with_and_verified(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		List<Map<String,String>> dt = dataTable.asMaps();//getting data from dataTable using this code.
		for(Map<String,String> m : dt)
		{
			
		driver.findElement(By.linkText("New Lead")).click();	
		driver.findElement(By.name("lastname")).sendKeys(m.get("lastname"));
		driver.findElement(By.name("company")).sendKeys(m.get("company"));
		driver.findElement(By.name("button")).click();
		
		//driver.findElement(By.xpath("//td[text()='First Name:']/following::td[1]")).getText().equals("xyz");
		driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals("abc");
		driver.findElement(By.xpath("//td[text()='Company:']/following::td[1]")).getText().equals("eclerx");
	}
	}
	    
	
	@When("click on logout button")
	public void click_on_logout_button() 
	{
		driver.findElement(By.linkText("Logout")).click();
	
	}

}
