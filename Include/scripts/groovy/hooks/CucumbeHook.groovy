package hooks

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.Scenario
import internal.GlobalVariable

import cucumber.api.java.AfterStep
import extentReport.ExtentReportManager as ExtentReportManager
import com.aventstack.extentreports.Status

public class CucumbeHook {

	@Before
	def beforeScenario(Scenario scenario) {
		// Khởi tạo Scenario trong Extent Report
		ExtentReportManager.initReport()
		ExtentReportManager.createScenario(scenario.getName())
		ExtentReportManager.logStep(Status.INFO, "Start scenario: " + scenario.getName())
	}

	@AfterStep
	def afterStep(Scenario scenario) {
		String keyword = utils.CucumberUtils.currentStepKeyword
		String name = utils.CucumberUtils.currentStepName
		
		String fullStepName = keyword + name
		
		// Lấy tên của Step vừa chạy (Katalon 8.6.9 hỗ trợ lấy qua reflection hoặc nội dung kịch bản)

		String status = scenario.getStatus().toString().toUpperCase()

		switch (status) {
			case "PASSED":
				ExtentReportManager.logStep(Status.PASS, "BƯỚC: " + stepName)
				break

			case "FAILED":
				String screenshotPath = WebUI.takeScreenshot()
				ExtentReportManager.logStep(Status.FAIL, "LỖI TẠI: " + stepName, screenshotPath)
				break

			case "SKIPPED":
			// Ghi nhận các bước bị bỏ qua để báo cáo không bị "mất dấu"
				ExtentReportManager.logStep(Status.SKIP, "BỎ QUA: " + stepName)
				break

			default:
				ExtentReportManager.logStep(Status.INFO, "TRẠNG THÁI KHÁC: " + stepName)
				break
		}


	}

	@After
	def afterScenario(Scenario scenario) {
		ExtentReportManager.logStep(Status.INFO, "End scenario: " + scenario.getStatus())
		// WebUI.closeBrowser()
		// Đừng gọi Log.flush() ở đây nếu bạn chạy nhiều Scenario trong 1 Suite

		ExtentReportManager.flush()
	}
}

