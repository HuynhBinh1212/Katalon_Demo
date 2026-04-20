package steps
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
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
import extentReport.ExtentReportManager as ExtentReportManager
import helper.WebUIandLog as WebUIandLog


class Login_Demo_Step {
	

	@Then("verify")
	public void verify() {
		WebUIandLog.setNode("Verify giá trị")
		
	}

	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	
	@When("User log with user and pass")
	public void userLogWithUserAndPass() {
		
		WebUIandLog.setNode("When user login with user and pass")
		
		WebUIandLog.clickWithReport(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/input_Demo account_form-control'),"Account")
		
		WebUIandLog.sendKeysWithReport(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/input_Username_username'), 'John Doe','Account')
		
		WebUIandLog.clickWithReport(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/span_Demo account_glyphicon glyphicon-lock'),"Password")
		
		WebUIandLog.setEncryptedTextWithReport(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/input_Password_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM', 'Password')
		
		WebUIandLog.clickWithReport(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/button_Login'),"Login")
		
	}

}