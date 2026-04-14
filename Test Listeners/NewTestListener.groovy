import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.reporter.ExtentSparkReporter
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.keyword.KeywordContext
import io.cucumber.java.AfterStep
import io.cucumber.java.Scenario
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import extentReport.ExtentReportManager as ExtentReport

class NewTestListener {
	
	
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		ExtentReport.initReport()
	}

	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		// Tạo một mục mới trong báo cáo cho mỗi Test Case
		//ExtentReport.stest = ExtentReport.extent.createTest(testCaseContext.getTestCaseId())
		
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		
	}

	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		// Lệnh QUAN TRỌNG NHẤT: Xuất dữ liệu ra file vật lý
		//ExtentReport.flush()
	}
}