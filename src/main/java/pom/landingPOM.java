package pom;

import driver.driver;
import pages.landingpage;

public class landingPOM {

    driver Driver = null;
    landingpage lp = null;

    public landingPOM(driver Driver) {
        this.Driver = Driver;
        lp = new landingpage(Driver);
    }

    public void btnIngresar(String usuario, String contrasena, String captcha)
    {
        lp.inputUsuario(usuario);
        lp.inputContrasena(contrasena);
        lp.inputCaptcha(captcha);

        Driver.implicitwait();
        lp.Iniciar();
    }


}