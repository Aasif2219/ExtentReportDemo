package com.orangehrm.utilities;


import org.testng.ITestNGListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager implements ITestNGListener{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	


	public static void setExtent(){
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
//		htmlReporter.config().setDocumentTitle("Automation Report");
//		htmlReporter.config().setReportName("Functional Report");
//		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "LoaclHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Aasif");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	public static void endReport() {
		extent.flush();
	}

}
