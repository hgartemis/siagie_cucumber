package utilities;

import driver.driver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class utilities {

    public void press()
    {}

    public void signOut(driver drv) {
      //      drv.signout();
    }

    public static String formatAmountDoubleToStringWithoutDecimals (double amount ){
        NumberFormat formatter = new DecimalFormat("#0.00");
        String formattedAmount = formatter.format(amount).replace(".", "");

        return formattedAmount;
    }

    public static String formatAmountDoubleToString (double amount ){
        NumberFormat formatter = new DecimalFormat("#0.00");
        String formattedAmount = formatter.format(amount);//.replace(".", "");

        return formattedAmount;
    }

    public static boolean isValidEmailAddress(String email) {
        Pattern p = Pattern.compile("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern p = Pattern.compile("^([0-9\\-]?)*$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }

    public static boolean verifyIfElementHasFocus( WebDriver driver,WebElement element){
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
        if(Boolean.valueOf(element.getAttribute("aria-selected")) || element.getAttribute("class").contains("brandedGradient")){
            return true;
        }else{
            return false;
        }
    }

    public static boolean verifyIfElementDoesntHaveFocus(WebDriver driver,WebElement element){
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
        if(!Boolean.valueOf(element.getAttribute("aria-selected"))){
            return true;
        }else{
            return false;
        }
    }
    public static void waitUntilWebElementHasTextInside(WebDriver driver, WebElement element) {

        Function<WebDriver, Boolean> waitForElementHasText = new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                if (element.getAttribute("innerText").length() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        new WebDriverWait(driver, 30).until(waitForElementHasText);
    }




}
