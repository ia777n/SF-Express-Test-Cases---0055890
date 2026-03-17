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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')
WebUI.navigateToUrl('https://sf.ekonek.com/login')

WebUI.setText(findTestObject('Page_e-Konek Apps - SF Status Uploader/input_Username'), GlobalVariable.username)
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/input_Password'))
WebUI.setEncryptedText(findTestObject('Page_e-Konek Apps - SF Status Uploader/input_Password'), GlobalVariable.password)

WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/button_Login'))

// Wait for the nav icon to be visible and clickable BEFORE clicking
WebUI.waitForElementVisible(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_text-4xl inline-block mx-10 false transition'), 30)
WebUI.waitForElementClickable(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_text-4xl inline-block mx-10 false transition'), 30)
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_text-4xl inline-block mx-10 false transition'))

// Wait for QUERY link to appear BEFORE clicking it
WebUI.waitForElementVisible(findTestObject('Page_e-Konek Apps - SF Status Uploader/a_QUERY'), 80)
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/a_QUERY'))

// Wait for the SweetAlert2 popup to fully disappear before proceeding
WebUI.waitForElementNotPresent(findTestObject('Page_e-Konek Apps - SF Status Uploader/div_LoadingOKNoCancel'), 120)

// Wait for the next nav element to be ready before clicking
WebUI.waitForElementVisible(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_inline-block mx-10 false transition ease-in-'), 30)
WebUI.waitForElementClickable(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_inline-block mx-10 false transition ease-in-'), 30)
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/svg_inline-block mx-10 false transition ease-in-'))

// Enter a non-HAWB criteria input
String searchInput = '308'
WebUI.waitForElementVisible(findTestObject('Page_e-Konek Apps - SF Status Uploader/input_HAWB'), 30)
WebUI.setText(findTestObject('Page_e-Konek Apps - SF Status Uploader/input_HAWB'), searchInput)

WebUI.waitForElementClickable(findTestObject('Page_e-Konek Apps - SF Status Uploader/button_Filter'), 30)
WebUI.click(findTestObject('Page_e-Konek Apps - SF Status Uploader/button_Filter'))

// Wait for loading to finish
WebUI.waitForElementNotPresent(findTestObject('Page_e-Konek Apps - SF Status Uploader/div_LoadingOKNoCancel'), 120)

// Verify system does not return results based on non-HAWB criteria
WebDriver driver = DriverFactory.getWebDriver()

List<String> hawbResults = driver.findElements(By.xpath("//div[@id='cell-1-undefined']"))
                                 .collect { it.getText().trim() }
                                 .findAll { it != '' }

boolean hasNoRecordsMessage = driver.findElements(By.xpath(
    "//*[contains(text(),'There are no records to display')]")).size() > 0

if (hasNoRecordsMessage && hawbResults.isEmpty()) {
    println "PASS: No records returned for input '${searchInput}'."

} else if (!hawbResults.isEmpty()) {
    // Only pass if ALL returned HAWBs exactly match the input
    List<String> wrongMatches = hawbResults.findAll { it != searchInput }

    if (!wrongMatches.isEmpty()) {
        WebUI.closeBrowser()
        assert false, "FAIL: Results returned that do not exactly match '${searchInput}': ${wrongMatches}"
    } else {
        println "PASS: All results exactly match input '${searchInput}'."
    }

} else {
    WebUI.closeBrowser()
    assert false, "FAIL: No response from system."
}
