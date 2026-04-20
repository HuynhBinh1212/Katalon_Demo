package extentReport

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.reporter.configuration.Theme
import java.text.SimpleDateFormat
import java.util.Date
import com.aventstack.extentreports.Status
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.aventstack.extentreports.markuputils.MarkupHelper as MarkupHelper
import com.aventstack.extentreports.markuputils.CodeLanguage
import com.aventstack.extentreports.markuputils.ExtentColor
import com.aventstack.extentreports.markuputils.Markup
import groovy.json.JsonOutput as JsonOutput
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.aventstack.extentreports.reporter.ExtentSparkReporter
import com.kms.katalon.core.configuration.RunConfiguration
import com.aventstack.extentreports.MediaEntityBuilder
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel
import com.aventstack.extentreports.gherkin.model.*

public class ExtentReportManager {
	 private static ExtentReports extent
	 // Sử dụng ThreadLocal để cô lập ExtentTest cho từng luồng
	 private static ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>()
	 private static ThreadLocal<ExtentTest> stepNode = new ThreadLocal<ExtentTest>()
	 private static int scenarioCount = 0
	 
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
		scenarioCount++;
		// Định dạng tên Scenario kèm STT: "01. Login Success"
		String formattedName = String.format("%02d. %s", scenarioCount, scenarioName)
		ExtentTest stest = extent.createTest(formattedName)
		extentTestThread.set(stest) // Lưu vào ThreadLocal
				 
	}
	
	
	// Hàm lấy đối tượng test hiện tại của thread đó
	static ExtentTest getTest() {
		return extentTestThread.get()
	}
	
	
	
	static void setNode(String stepName) {
		if (extentTestThread.get() == null) return

		// Mặc định là 'And' nếu không tìm thấy từ khóa
		Class<? extends IGherkinFormatterModel> keyword = And.class
		String lowerStep = stepName.toLowerCase()

		// Logic tự động nhận diện từ khóa
		if (lowerStep.startsWith("Given")) {
			keyword = Given.class
		} else if (lowerStep.startsWith("When")) {
			keyword = When.class
		} else if (lowerStep.startsWith("Then")) {
			keyword = Then.class
		} else if (lowerStep.startsWith("And")) {
			keyword = And.class
		}

		// Tạo node với từ khóa đã nhận diện
		ExtentTest node = extentTestThread.get().createNode(keyword, stepName)
		stepNode.set(node)
	}
	
	// Hàm lấy đối tượng test hiện tại của thread đó
	static ExtentTest getNode() {
		return stepNode.get()
	}
	
	
	
	// Log thông tin bình thường (Dùng cho các bước trung gian)
	//1. Log INFO: Dùng cho các hành động (Click, Set text, Navigate)
	 static void logInfo(String message) {
		getTest().log(Status.INFO, message)
	}
	// THÊM HÀM NÀY ĐỂ HỖ TRỢ LABEL
	public static void logInfo(Markup markup) {
		getTest().info(markup);
	}

	// Log khi bước đó thành công
	
	 static void logPass(String message) {
		getTest().log(Status.PASS, message)
	}
	
	// Log khi bước đó thành công
	 static void logFail(String message) {
		getTest().log(Status.FAIL, message)
	}
	
	// 4. Log đặc biệt với Nhãn Màu (Markup)
	static void logHighlight(String message, ExtentColor color) {
		if (getTest()!= null) {
			getTest().info(MarkupHelper.createLabel(message, color))
		}
	}
	
	// Log sự kiện FAIL + Chụp ảnh
	static void logFail(String message, String screenshotPath) {
		if (getNode()!= null) {
			getNode().fail(message,
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build())
		}
	}

	//Đính kèm hình ảnh vào extent report
	static void addScreenshot(String screenshotPath) {
		try {
			// Lấy step hiện tại từ ThreadLocal và đính kèm ảnh
			getNode().log(Status.INFO, "Hình ảnh minh chứng: ",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build())
		} catch (Exception e) {
			getNode().log(Status.WARNING, "Không thể đính kèm hình ảnh: " + e.getMessage())
		}
	}
	
	static void logStatus(Object status, String message) {
	
	if (getNode()== null) return
		switch (status) {
			case Status.INFO:
			case "INFO":
				getNode().log(Status.INFO,message)
				break
				
			case Status.WARNING:
			case "WARN":
				// Log Warning với nhãn màu Cam cho nổi bật
				getNode().log(Status.WARNING, message)
				break
				
			case Status.PASS:
			case "PASS":
				getNode().log(Status.PASS, message)
				break
				
			case Status.FAIL:
			case "FAIL":
				String xpath = WebUI.takeScreenshot()
				getNode().log(Status.FAIL, message, MediaEntityBuilder.createScreenCaptureFromPath(xpath).build())
				break

			default:
				getNode().log(Status.INFO, message)
				break
		}
	}
	
	static void flush() {
		extent.flush()
	}
	
	static void clearNode() {
		
			if(getNode()!=null) {
				stepNode.remove()
			}
		
		}
	
	// Quan trọng: Giải phóng ThreadLocal sau khi chạy xong để tránh rò rỉ bộ nhớ
	static void unload() {
		if(getNode()!=null) {
			stepNode.remove()
		}
		
		if(getTest()!=null) {
			extentTestThread.remove()
		}
	
	}
//
}
