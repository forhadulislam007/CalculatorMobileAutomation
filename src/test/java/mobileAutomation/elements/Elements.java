package mobileAutomation.elements;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Elements {
    private static AndroidDriver driver;

    public Elements(AndroidDriver driver) {
        this.driver = driver;
    }

//    private static By button1 = By.id("btn_1");
//    private static By button9 = By.id("btn_9");
//    private static By button4 = By.id("btn_4");
//    private static By button5 = By.id("btn_5");
//    private static By button6 = By.id("btn_6");
//    private static By button7 = By.id("btn_7");

    public static void clickDigit(int digit) {
        driver.findElement(By.id("btn_" + digit)).click();
    }

    public static void setDriver(AndroidDriver driverInstance) {
        driver = driverInstance;
    }

    private static By buttonAdd = By.id("plus");
    private static By buttonminus = By.id("minus");
    private static By buttondivi = By.id("divi");
    private static By buttonmultiply = By.id("multi");


    private static By buttonEquals = By.id("equal");

    private static By resultView = By.id("formula");

//    public static void clickButton9() {
//        driver.findElement(button9).click();
//    }
//
//    public static void clickButton4() {
//        driver.findElement(button4).click();
//    }
//
//    public static void clickButton5() {
//        driver.findElement(button5).click();
//    }
//
//    public static void clickButton6() {
//        driver.findElement(button6).click();
//    }
//
//    public static void clickButton7() {
//        driver.findElement(button7).click();
//    }
//
//    public static void clickButton1() {
//        driver.findElement(button1).click();
//    }

    public static void clickButtonAdd() {
        driver.findElement(buttonAdd).click();
    }

    public static void clickButtonMinus() {
        driver.findElement(buttonminus).click();
    }

    public static void clickButtonDivide() {
        driver.findElement(buttondivi).click();
    }

    public static void clickButtonMultiply() {
        driver.findElement(buttonmultiply).click();
    }

    public static void clickButtonEquals() {
        driver.findElement(buttonEquals).click();
    }

    public static String getResultText() {
        return driver.findElement(resultView).getText();
    }
}
