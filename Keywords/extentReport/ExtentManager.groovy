package extentReport

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest


public class ExtentManager {
	private static ExtentReports extent
public static ThreadLocal<ExtentReports> extentTestThread = new ThreadLocal<ExtentReports>()

	// 1. Quản lý việc tạo file (Giống vai trò Manager chính)
	public static synchronized ExtentReports getExtentReports() {
		if (extent == null) {
			// Code khởi tạo HTML Reporter ở đây
			
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Reports/ExtentReport.html")
			// Cấu hình thêm cho report đẹp hơn
			htmlReporter.config().setDocumentTitle("Katalon Automation Report")
			htmlReporter.config().setReportName("Functional Testing")
			
			extent = new ExtentReports()
			extent.attachReporter(htmlReporter)
		}
		return extent
	}

	// 2. Quản lý việc lấy log (Giống vai trò Report Manager)
	public static ExtentTest getTest() {
		return extentTestThread.get()
	}
	
	// Hàm thiết lập log cho luồng hiện tại
	public static void setTest(ExtentTest test) {
		extentTestThread.set(test)
	}
	
	// Hàm xóa log khi xong (tránh tràn bộ nhớ)
	static void removeTest() {
		extentTestThread.remove()
	}

}
