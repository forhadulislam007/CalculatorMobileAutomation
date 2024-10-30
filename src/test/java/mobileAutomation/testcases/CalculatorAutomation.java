package mobileAutomation.testcases;

import io.appium.java_client.android.AndroidDriver;
import mobileAutomation.elements.Elements;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import static mobileAutomation.elements.Elements.clickDigit;
import static mobileAutomation.elements.Elements.clickButtonAdd;
import static mobileAutomation.elements.Elements.clickButtonEquals;
import static mobileAutomation.elements.Elements.clickButtonMinus;
import static mobileAutomation.elements.Elements.clickButtonDivide;
import static mobileAutomation.elements.Elements.clickButtonMultiply;

public class CalculatorAutomation {
    AndroidDriver driver;
    private Elements elements;
    ExtentReports extent;
    ExtentTest test;


    @BeforeClass
    public void setUp() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("build/ExtentReports/extentReport.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Calculator Automation Report");
        sparkReporter.config().setReportName("Automation Test Results - Calculator App");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:udid", "R7KRB0067MP");
        capabilities.setCapability("appium:platformVersion", "13");
        capabilities.setCapability("appium:appPackage", "com.bng.calculator");
        capabilities.setCapability("appium:appActivity", "com.bng.calc.MainActivity");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:autoGrantPermissions", "true");
        capabilities.setCapability("appium:selectedElementSearchInProgress", "true");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);

        try {
            URI uri = new URI("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(uri.toURL(), capabilities);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            Elements Elements = new Elements(driver);
            Elements.setDriver(driver);

        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void sleep(long millis) {
        try { Thread.sleep(millis); } catch (InterruptedException ignored) {}
    }


    @Test(priority = 1)
    public void additionTest() {
        test = extent.createTest("Addition Test", "Verifies addition operation with sample numbers");
        test.assignCategory("Functional");

        clickDigit(1);
        clickDigit(4);
        clickButtonAdd();
        clickDigit(9);
        clickButtonEquals();

        String result = elements.getResultText();
        if (result.equals("23")) {
            test.pass("Addition test passed with result: " + result);
        } else {
            test.fail("Addition test failed. Expected result: 23, but got: " + result);
        }

        sleep(2000);

    }


    @Test(priority = 2)
    public void minusTest() {
        test = extent.createTest("Minus Test", "Verifies minus operation with sample numbers");
        test.assignCategory("Functional");

        clickDigit(7);
        clickButtonMinus();
        clickDigit(4);
        clickButtonEquals();

        String result = elements.getResultText();
        if (result.equals("3")) {
            test.pass("Addition test passed with result: " + result);
        } else {
            test.fail("Addition test failed. Expected result: 3, but got: " + result);
        }

        sleep(2000);
    }

    @Test(priority = 3)
    public void multiplyTest() {
        test = extent.createTest("Multiply Test", "Verifies multiply operation with sample numbers");
        test.assignCategory("Functional");

        clickDigit(5);
        clickButtonMultiply();
        clickDigit(6);
        clickButtonEquals();

        String result = elements.getResultText();
        if (result.equals("30")) {
            test.pass("Addition test passed with result: " + result);
        } else {
            test.fail("Addition test failed. Expected result: 30, but got: " + result);
        }

        sleep(2000);
    }

    @Test(priority = 4)
    public void divideTest() {
        test = extent.createTest("Divide Test", "Verifies divide operation with sample numbers");


        clickDigit(7);
        clickDigit(5);
        clickButtonDivide();
        clickDigit(5);
        clickButtonEquals();

        String result = elements.getResultText();
        if (result.equals("15")) {
            test.pass("Addition test passed with result: " + result);
        } else {
            test.fail("Addition test failed. Expected result: 15, but got: " + result);
        }

        sleep(2000);
    }


    @AfterClass
    public void tearDown() {
        extent.flush();
        if (driver != null) driver.quit();
    }
}
