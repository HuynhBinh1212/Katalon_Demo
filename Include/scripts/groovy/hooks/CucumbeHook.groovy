package hooks

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import extentReport.ExtentReportManager
import io.cucumber.java.After
import io.cucumber.java.AfterStep
import io.cucumber.java.Before
import io.cucumber.java.BeforeStep
import io.cucumber.java.Scenario
import com.aventstack.extentreports.Status
import utils.CucumberUtils as CucumberUtils
import utils.ScenarioContext as ScenarioContext


public class CucumbeHook {
//Chạy khi chạy cucumber có kịch bản 
	@Before
	void beforeScenario(Scenario scenario) {
		// Reset context trước khi bắt đầu scenario mới
		
		// Khởi tạo Scenario trong Extent Report
	
		//ExtentReportManager.initReport()
		ExtentReportManager.createScenario(scenario.getName())
		
		ExtentReportManager.logStep(Status.INFO, "Start scenario: " + scenario.getName())
	}

	@BeforeStep
	void beforeStep(Scenario scenario) {
		
		
	}
	
	@AfterStep
	void afterStep(Scenario scenario) {
		String keyword = CucumberUtils.currentStepKeyword
		String stepName = CucumberUtils.currentStepName
		
		String fullStepName = keyword+" : "+ stepName

		println(fullStepName)
		
		String status = scenario.getStatus().toString().toUpperCase()

		switch (status) {
			case "PASSED":
				ExtentReportManager.logStep(Status.PASS, fullStepName)
				break

			case "FAILED":
				String screenshotPath = WebUI.takeScreenshot()
				ExtentReportManager.logStep(Status.FAIL, "LỖI TẠI: " + fullStepName, screenshotPath)
				break

			case "SKIPPED":
			//
				ExtentReportManager.logStep(Status.SKIP, fullStepName)
				break

			default:
				ExtentReportManager.logStep(Status.INFO, fullStepName)
				break
		}
	}

	@After
	void afterScenario(Scenario scenario) {
		
		ExtentReportManager.logStep(Status.INFO, "End scenario: " + scenario.getStatus())
		
		// Giải phóng bộ nhớ sau khi xong
		
		ExtentReportManager.flush()
		 ScenarioContext.clear();
		 
	}
}

