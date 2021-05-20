package ControlSelenium;

import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class Control {

    protected WebElement control;
    protected By locator;
    protected driver Driver;

    public Control(By locator, driver driver){

        this.locator= locator;
        this.Driver = driver;
    }

    protected void findControl() throws MalformedURLException {
        this.control =Driver.returnDriver().findElement(this.locator);
        //Session.getInstance().getDriver().findElement(this.locator);
    }

    public void click() throws MalformedURLException {
        this.findControl();
        this.control.click();
    }

    public String getText() throws MalformedURLException {
        this.findControl();
        return this.control.getText();
    }

    public boolean isControlDisplayed(){
        try {
            this.findControl();
            return this.control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
