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



class Demo_Select_Step {

	@When("Người dùng bấm select")
	public void ngườiDùngBấmSelect() {
		WebUI.click(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/input_Demo account_form-control'))
		
		WebUI.setText(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/input_Username_username'), 'John Doe')
		
		WebUI.click(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/span_Demo account_glyphicon glyphicon-lock'))
		
		WebUI.setEncryptedText(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/input_Password_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')
		
		WebUI.click(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/button_Login'))
		
		WebUI.click(findTestObject('Login_Demo/Page_Demo_Select/select_Facility'))
		
		WebUI.selectOptionByValue(findTestObject('Object Repository/Login_Demo/Page_Demo_Select/select_Facility'), 'Tokyo CURA Healthcare Center',
			false)
		
	
	}

 
}