package com.reporting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.reusable.Reusable;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends Reusable {
	public static void generateJVMreport(String jsonFile) throws IOException {
		String path = System.getProperty("user.dir");

		File file=new File(path+getPropertyValue("jvmReportPath"));

		Configuration configuration=new Configuration(file,"PetStore");

		configuration.addClassifications("System Name", "Hp Inspiron");
		configuration.addClassifications("Processor", "intel i3");
		configuration.addClassifications("OS", "Windows11");

		List<String> jsonFiles=new ArrayList<String>();

		jsonFiles.add(jsonFile);
	
		ReportBuilder reportBuilder =new  ReportBuilder(jsonFiles,configuration);

		reportBuilder.generateReports();

	}

}
