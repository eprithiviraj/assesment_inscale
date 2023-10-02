package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reporting.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun=false,plugin= {"pretty","json:src/test/resources/Reports/reporting.json"},
features= "src/test/resources", glue="com.stepdefinition",monochrome=true)

	
public class StepRunner {
	@AfterClass
	public static void jvmReport() throws IOException {
		Reporting.generateJVMreport("/Users/PRITHIVIRAJ/eclipse-workspace4/Petstore/src/test/resources/Reports/reporting.json");	
	}

}
