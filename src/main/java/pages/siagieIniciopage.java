package pages;

import driver.driver;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class siagieIniciopage {

    public driver Driver = null;

    @FindBy(id="lnkCambiarIE")
    WebElement linkCambiarIE;

    @FindBy(id = "txtCodMod")
    WebElement inputCodMod;

    @FindBy(id = "btnBuscar")
    WebElement btnBuscar;

    @FindBy(xpath = "//tr[@class='noTextSelection']")
    WebElement selectIE;

    @FindBy(xpath = "//span[contains(text(),'Seleccionar')]")
    WebElement btnSeleccionarIE;

    @FindBy(id="imbMenu_2")
    WebElement mnuMatricula;

    @FindBy(className = "siagie_slogan")
    WebElement imagenMinisterio;

    @FindBy(id="imbSubMenu_2")
    WebElement mnuSubGestionTraslado;

    @FindBy(id="imgsubitem_2_0")
    WebElement mnuIngreso;

    @FindBy(xpath = "//span[@class='subitem_etiqueta' and contains(text(),'Ingreso')]")
    WebElement selIngreso;


    public siagieIniciopage(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

    public boolean checkElementsLinkText() {
        boolean response = this.Driver.missingElement(linkCambiarIE);
        return response;
    }

    public boolean checkElementsSloganMinedu() {
        boolean response = this.Driver.missingElement(imagenMinisterio);
        return response;
    }

    public void mnuMatricula() {
        mnuMatricula.click();
    }

    public void linkMenuIngreso() {

        Actions act = new Actions(Driver.returnDriver());
        System.out.println("se muestra: " + mnuSubGestionTraslado.isDisplayed());
        act.moveToElement(mnuSubGestionTraslado).perform();

        //System.out.println("submenu1: " + selIngreso.isDisplayed());
        mnuIngreso.click();

    }

    public void btnCambiarIE() {
        linkCambiarIE.click();
    }

    public void inputCodMod(String codigo) {
        inputCodMod.clear();
        inputCodMod.sendKeys(codigo);
    }

    public void btnBuscarIE() {
        btnBuscar.click();
        Driver.implicitwait();
    }

    public void SeleccionIE() {
        selectIE.click();
        btnSeleccionarIE.click();
    }

}
