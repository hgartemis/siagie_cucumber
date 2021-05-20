package pages;

import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class landingpage {

    public driver Driver = null;

    @FindBy(className = "logo_siagie")
    WebElement SiagieLogo;

    @FindBy(className = "principal_menu")
    WebElement MineduLogo;

    @FindBy(xpath = "//div[contains(text(),'Sistema de Informaci')]")
    WebElement InformativeText;

    @FindBy(xpath = "//div[contains(text(),'Derechos Reservados')]")
    WebElement InformativeFooterText;

    @FindBy(id = "lnkManual")
    WebElement linkManual;

    @FindBy(id = "txtUsuario")
    WebElement inputUsuario;

    @FindBy(id = "txtFraseSecreta")
    WebElement inputContrasena;

    @FindBy(id = "txtCaptcha")
    WebElement inputCaptcha;

    @FindBy(className = "btn-enviar")
    WebElement AcceptBtn;

    @FindBy(xpath = "//a[contains(text(),'He olvidado mi contrase')]")
    WebElement linkOlvideContra;

    @FindBy(xpath = "//p[@class='validationMessageFromServer']")
    WebElement msg;



    public landingpage(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
        //Driver.implicitwait();



    }

    public boolean checkElementsSimonLogo() {
        boolean response = this.Driver.missingElement(SiagieLogo);
        return response;
    }

    public boolean checkElementsMineduLogo() {
        boolean response = this.Driver.missingElement(MineduLogo);
        return response;
    }

    public boolean checkElementsInformativeText() {
        boolean response = this.Driver.missingElement(InformativeText);
        return response;
    }

    public boolean checkElementsManualText() {
        boolean response = this.Driver.missingElement(linkManual);
        return response;
    }

    public boolean checkElementsOlvideContrasenaText() {
        boolean response = this.Driver.missingElement(linkOlvideContra);
        return response;
    }

    public boolean checkElementsFooterText() {
        boolean response = this.Driver.missingElement(InformativeFooterText);
        return response;
    }

    public boolean checkElementsSiagieBtn() {
        boolean response = this.Driver.missingElement(AcceptBtn);
        return response;
    }

    public void inputUsuario(String usuario) {
        inputUsuario.clear();
        inputUsuario.sendKeys(usuario);
    }

    public void inputContrasena(String contrasena) {
        inputContrasena.clear();
        inputContrasena.sendKeys(contrasena);
    }

    public void inputCaptcha(String captcha) {
        inputCaptcha.clear();
        inputCaptcha.sendKeys(captcha);
    }

    public void Iniciar() {
        AcceptBtn.click();
        Driver.implicitwait1();
    }

    public String msg() {

        return msg.getAttribute("innerHTML");
    }

}
