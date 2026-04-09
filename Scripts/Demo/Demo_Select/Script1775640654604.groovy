import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import extentReport.ExtentReportManager as ExtentReport

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/a_CURA Healthcare_menu-toggle'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/a_Login'))

WebUI.click(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/input_Demo account_form-control'))

WebUI.setText(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/input_Username_username'), 'John Doe')

WebUI.click(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/span_Demo account_glyphicon glyphicon-lock'))

WebUI.setEncryptedText(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/input_Password_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('Object Repository/Login_Demo/Page_Dashboard_Login/button_Login'))

WebUI.click(findTestObject('Login_Demo/Page_Demo_Select/select_Facility'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Login_Demo/Page_Demo_Select/select_Facility'), 'Tokyo CURA Healthcare Center', 
    false)

WebUI.sendKeys(findTestObject('Object Repository/Login_Demo/Page_Demo_Select/select_Facility'), Keys.chord(Keys.ENTER))

ExtentReport.logInfo("${message}")

WebUI.verifyOptionPresentByValue(findTestObject('Object Repository/Login_Demo/Page_Demo_Select/select_Facility'), 'Tokyo CURA Healthcare Center', false, 0)

