package extentReport

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.reporter.configuration.Theme
import java.text.SimpleDateFormat
import java.util.Date
import com.aventstack.extentreports.Status
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.aventstack.extentreports.markuputils.MarkupHelper as MarkupHelper
import com.aventstack.extentreports.markuputils.CodeLanguage as CodeLanguage
import groovy.json.JsonOutput as JsonOutput
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.aventstack.extentreports.reporter.ExtentSparkReporter
import com.kms.katalon.core.configuration.RunConfiguration
import com.aventstack.extentreports.MediaEntityBuilder
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ExtentReportManager {
	 public static ExtentReports extent
	 public static ExtentTest stest

	// Khởi tạo Report
	static void initReport() {

		if (extent == null) {
			String reportPath = RunConfiguration.getProjectDir() + "/Reports/ExtentReport.html"
			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath)

			extent = new ExtentReports()
			extent.attachReporter(spark)

		}
	}
	

	// Tạo node cho từng Scenario
	static void createScenario(String scenarioName) {
		stest = extent.createTest(scenarioName)
	
	}
	

	
	// Log thông tin bình thường (Dùng cho các bước trung gian)
	 static void logInfo(String message) {
		stest.log(Status.INFO, message)
	}

	// Log khi bước đó thành công
	 static void logPass(String message) {
		stest.log(Status.PASS, message)
	}
	
	// Log khi bước đó thành công
	 static void logFail(String message) {
		stest.log(Status.FAIL, message)
	}


	// Tạo node con cho từng Step

	static void logStep(Status status, String stepName, String screenshotPath = null) {
		if (screenshotPath != null) {
			stest.log(status, stepName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build())
		} else {
			stest.log(status, stepName)
		}
	}

	static void flush() {
		extent.flush()
	}
//
}
