package driver;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class driver {

    public Properties p = null;
    public Properties p1 = null;
    public Properties p2 = null;
    public static WebDriver driver;
    public FileReader reader = null;

    public WebDriver returnDriver() {
        return driver;
    }

    public void setupClass(int i) {

        switch(i) {
            case 1:
                System.setProperty("webdriver.chrome.driver","src\\main\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case 2:
                System.setProperty("webdriver.gecko.driver","src\\main\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case 3:
                System.setProperty("webdriver.edge.driver","src\\main\\resources\\drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void setupTest(int i) {
        switch(i) {
            case 1:
                driver = new ChromeDriver();
                break;
            case 2:
                driver = new FirefoxDriver();
                break;
            case 3:
                driver = new EdgeDriver();
                break;
            default:
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void setupTest(int x, int y) {
        driver = new ChromeDriver();
        Dimension dimension = new Dimension(x, y);
        driver.manage().window().setSize(dimension);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public driver(int i ,int x, int y)
    {
        setupClass(i);
        setupTest(x,y);
        initiateLocators();
     //   initiateReport();
        initiateVariables();
        PageFactory.initElements(this.driver, this);

    }

    public driver(int i) {
        setupClass(i);
        //setupTest(i);
        //initiateLocators();
     //   initiateReport();
        //initiateVariables();

        PageFactory.initElements(this.driver, this);
    }

    public void initiateVariables() {
        try {
            String prop_path = System.getProperty("user.dir") + System.getProperty("file.separator") + "env/variables.properties";
            FileReader readeri = new FileReader(prop_path);
            reader = readeri;
            p = new Properties();
            p.load(reader);
        } catch (Exception e) {
            System.out.println("el archivo de variables del sitio no se cargo de manera adecuada");
            e.printStackTrace();
        }
    }

    public void initiateReport() {
        try {
            String prop_path = System.getProperty("user.dir") + System.getProperty("file.separator") + "env/reportConfig.properties";
            FileReader readeri = new FileReader(prop_path);
            reader = readeri;
            p1 = new Properties();
            p1.load(reader);
        } catch (Exception e) {
            System.out.println("el archivo de reporte no se inicializo de manera adecuada");
            e.printStackTrace();
        }
    }

    public void initiateLocators() {
        try {
            String prop_path = System.getProperty("user.dir") + System.getProperty("file.separator") + "env/locators.properties";
            FileReader readeri = new FileReader(prop_path);
            reader = readeri;
            p2 = new Properties();
            p2.load(reader);
        } catch (Exception e) {
            System.out.println("el archivo de locators no se inicializo de manera adecuada");
            e.printStackTrace();
        }
    }


    public void explicitWait(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
        //wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void explicitWaitDep(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void customWait_xpath(By minedupath) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(presenceOfElementLocated(minedupath));
    }

    public void customWait_clickable(By minedupath) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(elementToBeClickable(minedupath));
    }


    public void send_keys(By mineduElement, String mineduInput) {
        driver.findElement(mineduElement).sendKeys(mineduInput);

    }

    public void goto_url(String url_address) throws InterruptedException {
        driver.get(url_address);
        Thread.sleep(6000);
    }


    public void click(By mineduPath) {
        driver.findElement(mineduPath).click();
    }

    public void switchWindows()
    {
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
// Perform the click operation that opens new window
// Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
// Perform the actions on new window
// Close the new window, if that window no more required
//   driver.close();
// Switch back to original browser (first window)
        //    driver.switchTo().window(winHandleBefore);
    }

    public void implicitwait() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
    }

    public void implicitwait1() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
        }
    }


    public void submit(By form) {
        driver.findElement(form).submit();
    }

    public Properties return_Prop() {

        return p;
    }


    public boolean missingImageElement(WebElement ImageElement) {
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageElement);
        return ImagePresent;
    }

    public boolean missingElement(WebElement Element) {
        Boolean response = null;
        response = Element.isDisplayed() && Element.isEnabled();
        return response;
    }


    public String takeScreenshot(String methodName) throws IOException {

        //File tmpFile = new File("" + Paths.get(System.getProperty("java.io.tmpdir"), methodName + ".png"));
        Date d = new Date();
        String fileName =  methodName + d.toString().replace(":", "_").replace(" ", "_") + ".png"; //getScreenshotname(methodName);
        String directory = System.getProperty("user.dir") + "\\screenshots\\";

        new File(directory).mkdir();
        String path = directory + fileName;

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(path));
        return path;

    }

    public byte[] screenShotAs() {
        byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screen;
    }

    public void scroll(int x) {
        ((JavascriptExecutor) driver).executeScript("scroll(0," + x + ")");

    }
    public WebElement findby(String xpath)
    {
       return driver.findElement(By.xpath(xpath));
    }


    public void superwait() {
        implicitwait();
        implicitwait();
        implicitwait();
        implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();
        implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();
        implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();implicitwait();

    }

    public void longexplicitWait(WebElement element) {

            WebDriverWait wait = new WebDriverWait(driver,600);
            wait.until(ExpectedConditions.visibilityOf(element));

    }
    public String timestamp()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        return timestamp.toString();
    }
}