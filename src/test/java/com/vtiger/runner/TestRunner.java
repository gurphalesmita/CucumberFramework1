package com.vtiger.runner;

import org.junit.runner.RunWith;

import org.junit.runners.Suite.SuiteClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/Features/", 
		glue = "com.vtiger.stepdefinitions",
		dryRun = false,
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
				     "junit:target/cucumber-reports/Cucumber.xml",
				        "html:target/cucumber-reports.html"},
		tags = "@test3"
		
		
		
		)
public class TestRunner 
{

}
