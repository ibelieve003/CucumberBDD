package com.org.runner;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import commonutils.Configure;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import testlisteners.TestListener;

@CucumberOptions(
		plugin = {
				"pretty",
				"html:reports/cucumber-html-report/cucumber.html"
		},

        features = {"classpath:features"},
        glue = {"classpath:stepDefs"},
        tags = ("@java")
)

@Listeners(TestListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@BeforeSuite
	public void beforeSuite() {
		Configure.setEnvVars();
	}
	
	@BeforeTest
	public void beforeTest() {
		Configure.initBrowserSesion();
	}
}