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

WebUI.openBrowser('')
WebUI.navigateToUrl('https://sf.ekonek.com/login')

WebUI.setText(findTestObject('Page_e-Konek Apps - SF Status Uploader/input_Username'), 'NMM_User')
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/input_Password'))
WebUI.setEncryptedText(findTestObject('Page_e-Konek Apps - SF Status Uploader/input_Password'), 'IMrpfjBbSL8n+osp8It7RQ==')

WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/button_Login'))

// Wait for the nav icon to be visible and clickable BEFORE clicking
WebUI.waitForElementVisible(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_text-4xl inline-block mx-10 false transition'), 30)
WebUI.waitForElementClickable(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_text-4xl inline-block mx-10 false transition'), 30)
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_text-4xl inline-block mx-10 false transition'))

//Wait for QUERY link to appear BEFORE clicking it (moved wait to before the click)
WebUI.waitForElementVisible(findTestObject('Page_e-Konek Apps - SF Status Uploader/a_QUERY'), 80)
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/a_QUERY'))

// Wait for the SweetAlert2 popup to fully disappear before proceeding
WebUI.waitForElementNotPresent(findTestObject('Page_e-Konek Apps - SF Status Uploader/div_LoadingOKNoCancel'), 120)

// Wait for the next nav element to be ready before clicking
WebUI.waitForElementVisible(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_inline-block mx-10 false transition ease-in-'), 30)
WebUI.waitForElementClickable(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_inline-block mx-10 false transition ease-in-'), 30)
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_inline-block mx-10 false transition ease-in-'))

WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/button_Filter'))
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/button_Filter'))
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/button_Filter'))
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/button_Filter'))
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/button_Filter'))

WebUI.delay(3)



