package helper

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
import internal.GlobalVariable
import extentReport.ExtentReportManager as ExtentReport
import com.aventstack.extentreports.Status
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import utils.TestContext as TestContext

public class WebUIandLog {
	
	// Khởi tạo node Given, when, then , and
	public static void setNode(String stepName) {
		ExtentReport.setNode(stepName)
	}
	
	
	//Action click
	public static void clickWithReport(TestObject to, String elementName) {
		try {
	
			WebUI.waitForElementClickable(to, 10)
			WebUI.click(to)
			ExtentReport.logStatus(Status.INFO,"Đã click thành công vào: <b>" + elementName + "</b>")
			
		} catch (Exception e) {
			ExtentReport.logStatus(Status.FAIL,"Không thể click vào: <b>" + elementName + "</b>. Lỗi " + e.message)	
		}
	}
	

	//Action navigate
	
	public static void navigateWithReport(String url) {
		try {
			WebUI.navigateToUrl(url)
		
			ExtentReport.logStatus(Status.INFO,"Navigate tới URL: <b>" + url + "</b>." )
		} catch (Exception e) {
			ExtentReport.logStatus(Status.FAIL,"Lỗi khi navigate: " + e.getMessage())
			throw e
		}
	}
	
	//Action sendKey
	public static void sendKeysWithReport(TestObject to, String text, String elementName ) {
	
		try {
			WebUI.setText(to, text)
			ExtentReport.logStatus(Status.INFO, "Nhập thành công text [<b>" + text + "</b>] vào đối tượng "+ "<b>" +elementName+"</b>")
		} catch (Exception e) {
			ExtentReport.logStatus(Status.FAIL, "Thất bại khi nhập vào: " + to.getObjectId() + ". Lỗi: " + e.getMessage())
			throw e
		}
	}
	
	//Action EncryptedText
	public static void setEncryptedTextWithReport(TestObject to, String encryptedText,String elementName) {
		
		try {
			// Thực hiện lệnh gốc của Katalon
			WebUI.setEncryptedText(to, encryptedText)
			
			// Log hành động vào Extent Report với mật khẩu đã được che
			ExtentReport.logStatus(Status.INFO, "Nhập thành công mật khẩu (Encrypted) với giá trị: <b>********</b> vào: [<b>" + elementName + "</b>] ")
			
		} catch (Exception e) {
			ExtentReport.logStatus(Status.FAIL, "Thất bại khi nhập mật khẩu vào: " + to.getObjectId() + ". Lỗi: " + e.getMessage())
			throw e
		}
	}
}
