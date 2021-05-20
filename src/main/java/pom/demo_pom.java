package pom;

import driver.driver;
import pages.landingpage;

public class demo_pom {

    driver Driver = null;
    landingpage lp = null;

    public demo_pom(driver Driver) {
        this.Driver = Driver;
        lp = new landingpage(Driver);
    }

}
