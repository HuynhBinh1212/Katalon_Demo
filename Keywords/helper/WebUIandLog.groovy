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
import extentReport.ExtentReportManager
import extentReport.ExtentReportManager as ExtentReport
import com.kms.katalon.core.util.KeywordUtil


public class WebUIandLog {
	
	//Action click
	public static void clickAndLog(TestObject to, String elementName) {
		try {
	
			WebUI.waitForElementClickable(to, 10)
			WebUI.click(to)
			ExtentReport.logPass( "Đã click thành công vào: <b>" + elementName + "</b>")
			
		} catch (Exception e) {
			ExtentReport.logFail("Không thể click vào: <b>" + elementName + "</b>. Lỗi tại xpath : " + e.message)
			KeywordUtil.markFailed("Không thể click vào " + elementName+ to.getObjectId() + ". Chi tiết: " + e.getMessage())
			
		}
	}

}
