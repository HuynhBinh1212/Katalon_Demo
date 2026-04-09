import com.aventstack.extentreports.Status
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import extentReport.ExtentReportManager as ExtentReport
import cucumber.api.java.AfterStep
import cucumber.api.java.Before
import cucumber.api.Scenario
import com.aventstack.extentreports.Status
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


class NewTestListener {
	
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		//ExtentReport.initReport()
	}

   @BeforeTestCase
	def beforeTestCase(Scenario scenario) {
		// Tạo một node test cho mỗi Test Case
		//ExtentReport.createScenario(scenario.getName())
		
	}

	@AfterStep
    def afterStep(Scenario scenario) {
        // Lấy tên của Step vừa chạy (Katalon 8.6.9 hỗ trợ lấy qua reflection hoặc nội dung kịch bản)
//        String status = scenario.getStatus().toUpperCase()
//        
//        if (scenario.isFailed()) {
//            // Nếu lỗi: Chụp ảnh màn hình và log Fail
//            String path = WebUI.takeScreenshot()
//            ExtentReport.logStep(Status.FAIL, "Step thất bại: " + scenario.getName(), path)
//        } else {
//            // Nếu Pass: Log trạng thái thành công
//            ExtentReport.logStep(Status.PASS, "Hoàn thành bước trong kịch bản")
//        }
    }

	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		//ExtentReport.flush()
	}
}