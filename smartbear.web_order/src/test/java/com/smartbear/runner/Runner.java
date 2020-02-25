package com.smartbear.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.smartbear.utilities.DriverFactory;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
		plugin= {
				"html:target/cucumber_report",
				"rerun:target/rerun.txt"
				
		},
		features = {"src/test/resources/Features"},
		glue = {"com.smartbear.steps"}
//		,tags= {"@wip"}
	//	,dryRun = true
		
			
		)
public class Runner extends DriverFactory{
@AfterClass
public static void after() {
	closeDriver();
}

}
