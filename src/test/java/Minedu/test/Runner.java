package Minedu.test;

import driver.driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions
public class Runner {


    String url = "http://sistemas13.minedu.gob.pe/siagie2ppt/";
    public static driver Driver = null;

    // HOOKS
    @Before
    public void setUp() throws InterruptedException {

        Driver = new driver(3);
        Driver.goto_url(url);

    }

    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            //byte[] screen= Session.getInstance().getDriver().getScreenshotAs(OutputType.BYTES);
            byte[] screen= Driver.screenShotAs();
            scenario.attach(screen,"image/png","Movile Failed Step");
        }
        Driver.teardown();
    }

}
