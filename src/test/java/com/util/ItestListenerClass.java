package com.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

	public class ItestListenerClass implements ITestListener  {
		static WebDriver driver;
		
		public void onTestStart(ITestResult result) {
			
			System.out.println("Test Method start");
		
		}

		public void onTestSuccess(ITestResult result) {
			
			System.out.println("Test Method success");
		
		}

		public void onTestFailure(ITestResult result) {
			
			TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
			File file = takesscreenshot.getScreenshotAs(OutputType.FILE);
			File destfile = new File("./AllScreenshots/"+result+".png");
			
			try {
				FileUtils.copyFile(file, destfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		public void onTestSkipped(ITestResult result) {
			
			System.out.println("Test Method skipped");
			
		}

		public void onTestFailedWithTimeout(ITestResult result) {
			
			System.out.println("Test Method fail with timeout");

		}

		public void onStart(ITestContext context) {
			
			System.out.println("Testing has started");
		
		}

		public void onFinish(ITestContext context) {
			
			System.out.println("Testing has finished");
		
		}


	}
