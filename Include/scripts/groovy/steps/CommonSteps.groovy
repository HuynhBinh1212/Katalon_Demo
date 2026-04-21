package steps
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.aventstack.extentreports.reporter.ExtentReporter
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import helper.WebUIandLog as WebUIandLog
import extentReport.ExtentReportManager as ExtentReportManager

class CommonSteps {
	@Given("Người dùng đi đến URL")
	public void UsernavigateURL() {
			
		WebUIandLog.setNode("Người dùng đi đến URL")
		
		//WebUI.openBrowser('')
		
		WebUIandLog.navigateWithReport('https://katalon-demo-cura.herokuapp.com/')
		
		WebUIandLog.clickWithReport(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/a_CURA Healthcare_menu-toggle'),"Toggle")
		
		WebUIandLog.clickWithReport(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/a_Login'),"Login")
		
	}

	@Given("Người dùng đi đến URL RLOS")
	public void ngườiDùngĐiĐếnURLRLOS() {
	
		WebUIandLog.navigateWithReport("http://172.27.5.5:31523/")
		
	}

	@When("Nhập username")
	public void nhậpUsername() {
		
		WebUIandLog.sendKeysWithReport(findTestObject('Object Repository/RLOS/Page_Log in to App Portal/input_Username or email_username'), 'namnp', "Username")
		
	}

	@When("Bấm nút Login")
	public void bấmNútLogin() {
		WebUI.click(findTestObject('Object Repository/RLOS/Page_Log in to App Portal/input_Password_kc-login'))
	}

	@When("Nhập password")
	public void nhậpPassword() {
		WebUI.setEncryptedText(findTestObject('Object Repository/RLOS/Page_Log in to App Portal/input_Password_password'), 'Uvyjv8f4jBwgsuBcD5HE0Q==')
		WebUI.maximizeWindow()
	}

	@Then("Verify kết quả")
	public void verifyKếtQuả() {
		WebUI.delay(5)
	}
	
	
	
	
	
	
	
	
}