package utilities;

import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.util.List;

public class responsive {


    driver Driver =null;
    public responsive(driver driver)
    {
    this.Driver = driver;
    }

    public void getdimesion()
    {
        Point point;
        Dimension dimension;

        List<WebElement> elementsList = Driver.returnDriver().findElements(By.xpath("//some/xpath"));

        for (WebElement element : elementsList)
        {
            point = element.getLocation();
            dimension = element.getSize();
            System.out.println("Element name: " + element.getTagName());
            System.out.println("Element size: " + dimension.height + "x" + dimension.width);
            System.out.println("Element location: " + point.x + ":" + point.y);
        }

    }
}
