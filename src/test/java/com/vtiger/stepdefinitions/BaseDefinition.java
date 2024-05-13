package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.applicationpages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDefinition //this is parent class.
{
	public static WebDriver driver;
	public LoginPage lp;
	
	public Properties prop;
	public static Map<String,Map<String,String>> dt;
	public static  String TCName;
	public static ExtentReports extent;
	public static ExtentTest logger;//using logger object writing test in ExtenntTest.
	
	
	public void initiation()//firstly read the property file and launch tha app.
	{
		//if(driver==null)
		if(extent==null)
		createExtentReport();
		readproperties();
		dt = readExcelData(System.getProperty("user.dir")+"/src/test/resources/Data/testData.xlsx","Sheet1");//call/read readExcelData() method//stored data in dt
		System.out.println(dt);
		//System.exit(0);
		
	}
	private void createextentreport() {
		// TODO Auto-generated method stub
		
	}
	public void launchApp()//launchapp function
	{
		if(prop.getProperty("browser").equals("firefox"))//key is browser
		{
			WebDriverManager.firefoxdriver().setup();//this line automatically download chromedriver exe file and set the path. 
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
			else if(prop.getProperty("browser").equals("headless"))
			{
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--headless=new");
				driver = new ChromeDriver(option);//option as a costructor in the chromedriver.
			}
		
		else
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();//launch the browser
		}
		driver.get(prop.getProperty("AppUrl"));//dynamic "URL"
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitwait"))));//dynamic 
}
	public void readproperties()//initiation read this file
	{
		 prop = new Properties(); //this is class read the properties
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/settings.properties");//file path
		prop.load(fis);//load the file in the property
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public Map<String, Map<String, String>> readExcelData(String file, String Sheet) //read xlfile data 
    {
    	Map<String,Map<String,String>> dt = new HashMap<>();
    	try
    	{
    	
    	Fillo fillo=new Fillo();
    	Connection connection=fillo.getConnection(file);
    	String strQuery="Select * from "+Sheet;
    	Recordset recordset=connection.executeQuery(strQuery);
    	 int rowcount = recordset.getCount();
    	 System.out.println("row count="+rowcount);
    	 List<String> lst = recordset.getFieldNames();
    	 int clmcount = lst.size();//column ki size return krta hai lst.
    	while(recordset.next()){
    	//System.out.println(recordset.getField("Details"));
    	Map<String,String> rowdata =  new HashMap<>();
    	for(int i=0;i<clmcount; i++)
    	{
    		rowdata.put(lst.get(i),recordset.getField(lst.get(i)));
    	}
    	dt.put(recordset.getField("TCName"), rowdata);
    	}
    	
    	
    	recordset.close();
    	connection.close();
    }
    	
    catch(Exception e)
	{
		e.printStackTrace();
	}
    return dt;
}
    
    public void createExtentReport()//generate extent report.
    {
    	Date d = new Date();
    	DateFormat ft = new SimpleDateFormat("ddmmyyhhmmss");
    	String FileName = ft.format(d);
    	ExtentHtmlReporter	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+FileName+".html");
    			//create an object of extent Reports
    	extent = new ExtentReports();
    	extent.attachReporter(htmlReporter);
    	extent.setSystemInfo("User Name" , "Smita G");
    	htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
    	  //Name of the report
    	htmlReporter.config().setReportName("Name of the Report comes here");
    	  //Dark Theme
    	htmlReporter.config().setTheme(Theme.DARK);
    	
    }
    
    
    

}
