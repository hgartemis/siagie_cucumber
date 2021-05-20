package ManageSiagie;

import ControlSelenium.Button;
import ControlSelenium.TextBox;
import driver.driver;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class LoginScreen {

    public driver Driver = null;
    public Map<String, TextBox> textboxMap = new HashMap<>();
    public Map<String, Button> buttonMap = new HashMap<>();

    public LoginScreen(driver driver) {
        this.Driver = driver;
        System.out.println("aca");
        textboxMap.put("usuario",new TextBox(By.id("txtUsuario"), this.Driver));
        textboxMap.put("contrasena",new TextBox(By.id("txtFraseSecreta"), this.Driver));
        textboxMap.put("captcha", new TextBox(By.id("txtCaptcha"), this.Driver));
        buttonMap.put("Iniciar",new Button(By.className("btn-enviar"), this.Driver));
    }

}
