package hooks

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import extentReport.ExtentReportManager
import io.cucumber.java.After
import io.cucumber.java.AfterStep
import io.cucumber.java.Before
import io.cucumber.java.BeforeStep
import io.cucumber.java.Scenario
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.Status
import utils.CucumberUtils as CucumberUtils
import utils.ScenarioContext as ScenarioContext
import utils.TestContext as TestContext
import com.aventstack.extentreports.markuputils.ExtentColor
import com.aventstack.extentreports.markuputils.Markup
import com.aventstack.extentreports.markuputils.MarkupHelper


public class CucumbeHook {
//Chạy khi chạy cucumber có kịch bản 
	@Before
	void beforeScenario(Scenario scenario) {
		
		// Trình duyệt sẽ mở trước khi bắt đầu mỗi Scenario
        WebUI.openBrowser('')
        WebUI.maximizeWindow()

		// Khởi tạo Scenario trong Extent Report
		ExtentReportManager.createScenario(scenario.getName())
		
		ExtentReportManager.logInfo("--------Start scenario: " + scenario.getName())
	}

	@BeforeStep
	void beforeStep(Scenario scenario) {
		
	}
	
	@AfterStep
	void afterStep(Scenario scenario) {
		ExtentReportManager.clearNode()
		if (scenario.isFailed()) {
			ExtentReportManager.getNode().skip("Step này không thực thi vì lỗi phía trước.")
			TestContext.clear()
		}
		
	}

	@After
	void afterScenario(Scenario scenario) {
		// Đóng trình duyệt sau khi Scenario kết thúc
		WebUI.closeBrowser()
		//MarkupHelper.createLabel("FEATURE: " + featureName.toUpperCase(), ExtentColor)
		if("FAILED".equals(scenario.getStatus().name())) {
			ExtentReportManager.logInfo(MarkupHelper.createLabel("--------Scenario: ", ExtentColor.RED))
		} else {
			Markup messageSuccess = MarkupHelper.createLabel("Kết quả: " + scenario.getStatus().name(), ExtentColor.BLUE)
			ExtentReportManager.logInfo(messageSuccess)
		}
		
		ExtentReportManager.unload()
	}
}

