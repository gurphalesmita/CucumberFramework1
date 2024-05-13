package com.vtiger.applicationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.PageAction;

public class LoginPage extends PageAction
{
	public WebDriver driver;//launch driver this driver is dead in this driver put the "new ChromeDriver" value.
	/*
	public void verifyTitle()
	{
		driver.getTitle();//getting the title of runtime application
	}
	*/
	// this is function and call the function reapete.
	
	/*String uid = "user_name";
	String pass = "user_password";
	String login = "Login";
	*/
	/*
	//as per design pttern rule seperate the this is locaters
	By uid = By.name("user_name"); 
	By pass = By.name("user_password");
	By login = By.name("Login");
	*/
	
	public LoginPage(WebDriver driver)//"LoginPage" is constructor and "Webdriver driver" is parameter.
	{
		super(driver);
		this.driver = driver;//under the constructor using the "this"
		//PageFactory.initElements(driver, LoginPage.class);"LoginPage.class" ke bdle hum "this" define krskte hai.
		
		PageFactory.initElements(driver, this);//pageFactory is a method,initilize the element jaise hum class ka object bnate hai vaise sare object identify hate hai
		
		//this is represent the current class.
	}
	
	@FindBy(name="user_name")// identify the element using "name" is id and "user_name" is expression and "@FindBy" is a annonation 
	WebElement tb_uid;// element name is "tb_uid" tb is textbox
	
	@FindBy(name="user_password")
	WebElement tb_pass;
	
	@FindBy(name="Login123")
	WebElement bt_login;//button
	
	@FindBy(name="login_theme")//this is selecttext locaters.
	WebElement dp_theme; //dp is dropdown
	
	//"driver.getTitle()" getting the title of runtime application and verify title expected and actual result.
	public boolean verifyTitle(String ExpectedTitle)
	{
	if(driver.getTitle().equals(ExpectedTitle))
	{
		return true;
		
	}
	else
	{
		return false;
	
	}
	}
	public void login(String userid, String pwd)// userid and pwd is a parameter.
	{
		setUsername(userid);
		setPassword(pwd);
		clickLogin();
		
		
	}
	public void login(String userid, String pwd,String theme)// userid and pwd is a parameter.
	{
		setUsername(userid);
		setPassword(pwd);
		selectTheme(theme);//call the function.
		clickLogin();
		
		
	}
	public void setUsername(String userid)//getting data from login function
	{
		//tb_uid.clear();
		setText(tb_uid, userid,userid+"has been entered successfully in username field");//tb_uid is a element and userid is data
		
		
	}
	public void setPassword(String pwd)//getting data from login function
	{
		//tb_pass.clear();
		//tb_pass.sendKeys("pwd");
		setText(tb_pass, pwd,pwd+"has been entered successfully in username field");
	}
	public void clickLogin()
	{
		clickElement(bt_login,"login button click succesfully");
		//bt_login.click();
		
		
	}
	public void selectTheme(String theme)
	{
		
		selectText(dp_theme,theme,theme+"selected from theme dropdown");//this is function
		
		
	}
}
	
	
		
	
	


