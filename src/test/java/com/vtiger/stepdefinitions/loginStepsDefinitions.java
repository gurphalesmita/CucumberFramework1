package com.vtiger.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.applicationpages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepsDefinitions extends BaseDefinition
{
	@Before//hooks
	public void getScenarioName(Scenario scenario)
	{
		 TCName = scenario.getName();
		 initiation();
		 logger = extent.createTest(TCName);//print the TCName in the report.
		 
	}
	@After//hooks
	public void CloseApp()
	{
		extent.flush();//save the report.
		driver.quit();
	}
	
	//public LoginPage lp;

	@Given("user should be on login page")
	public void user_should_be_on_login_page()
	{
		
//		if(driver==null)
//		driver = new ChromeDriver();
//		driver.get("http://localhost:100");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//dynamic wait
		launchApp();//launch the application on browser
		lp = new LoginPage(driver);
		
	}
	
	@When("user enters valid credentials")
	public void user_enters_valid_credentials() 
	{
		//driver.findElement(By.name("user_name")).sendKeys("admin");
		//driver.findElement(By.name("user_password")).sendKeys("admin");
		lp.setUsername(prop.getProperty("userid"));
		lp.setPassword(prop.getProperty("password"));
	    
	}
	@When("click on login button")
	public void click_on_login_button() 
	{
		//driver.findElement(By.name("Login")).click();
		lp.clickLogin();
	    
	}
	
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() 
	{
		driver.findElement(By.linkText("Home")).isDisplayed();
	  
	}

	@Then("user can click logout link")
	public void user_can_click_logout_link() 
	{
		driver.findElement(By.linkText("Logout")).click();
	    
	}


@When("user enters invalid credentials")
public void user_enters_invalid_credentials()
{
	//driver.findElement(By.name("user_name")).sendKeys("admin123");
	//driver.findElement(By.name("user_password")).sendKeys("admin456");
	lp.setUsername("admin123");
	lp.setPassword("admin234");
    
}
@When("user can validate error message on login page")
public void user_can_validate_error_message_on_login_page()
{
	driver.findElement(By.xpath("//*[contains(text(),'You must specify')]")).isDisplayed();
	
}

@When("user enters userid as {string} and password as {string} credentials")
public void user_enters_userid_as_and_password_as_credentials(String uid, String pwd) 
{
	
	lp.setUsername(uid);
	lp.setPassword(pwd);
	
}





}

