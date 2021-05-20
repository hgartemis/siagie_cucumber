package pages;

import driver.driver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class trasladopage {

    public driver Driver = null;

    @FindBy(xpath="//h2[contains(text(),'de Traslado de estudiante')]")
    WebElement informativoTipo;

    @FindBy(xpath = "//span[@id='ctl00_lblNombreTipoSede']")
    WebElement informativoSede;

    @FindBy(id = "ctl00_ContentPlaceMain_ddlTipoConstancia")
    WebElement cboTipoConst;

    @FindBy(id = "ctl00_ContentPlaceMain_ddlEstadoConstancia")
    WebElement cboEstadoConst;

    @FindBy(id = "ctl00_ContentPlaceMain_ddlAnioDestino")
    WebElement cboAnio;

    @FindBy(id = "ctl00_ContentPlaceMain_btnBuscarConstanciaVacante")
    WebElement btnBuscarConstancia;

    @FindBy(id = "ctl00_ContentPlaceMain_btnLimpiar")
    WebElement btnLimpiar;

    @FindBy(id = "ctl00_ContentPlaceMain_imbAgregar")
    WebElement btnAgregar;

    @FindBy(id = "ctl00_ContentPlaceMain_imbSalir")
    WebElement btnSalir;

    @FindBy(id = "chkHeLeido")
    WebElement chkAceptoCondiciones;

    @FindBy(id = "btnConfirmarCondicionesTraslado")
    WebElement btnProcederTraslado;

    @FindBy(id = "btnConfirmarCondicionesTraslado")
    WebElement btnCanceloTraslado;

    @FindBy(id = "dllTipoDeTraslado")
    WebElement cboTipoTraslado;

    @FindBy(id = "txtIEOrigenTraslado")
    WebElement inputIEOrigen;

    @FindBy(id = "btnBuscarIETraslado")
    WebElement btnBuscarIE;

    @FindBy(id = "dllTipoDocEstudianteTraslado")
    WebElement cboTipoDoc;

    @FindBy(id = "dllTipoDocEstudianteTraslado")
    WebElement cboTipoEstudiante;

    @FindBy(id = "txtNumeroDocEstudianteTraslado")
    WebElement inputDocAlumno;

    @FindBy(id="ddlUltimoAnioEstudioTraslado")
    WebElement cboUltimoAnio;

    @FindBy(id = "ddlUltimoGradoEstudioTraslado")
    WebElement cboUltimadoGrado;

    @FindBy(id = "dtpFechaTraslado")
    WebElement fechaTraslado;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[1]/a")
    WebElement diaActivo;

    @FindBy(id = "txtNumeroResolucionIeOrigen")
    WebElement inputResolucion;

    @FindBy(id = "btnValidarInformacionTraslado")
    WebElement btnValidar;

    @FindBy(id = "chkDeclaracionJurada")
    WebElement chkDeclaracionJ;

    @FindBy(id = "chkCopiaDNI")
    WebElement chkCopiaDNI;

    @FindBy(id = "chkFichaUnicaMatricula")
    WebElement chkFichaUnicaMatricula;

    @FindBy(id = "btnGrabarTraslado")
    WebElement btnGrabarTraslado;

    @FindBy(id = "alertify-logs")
    WebElement msgAlert;

    @FindBy(id = "alertify-cerrar")
    WebElement btnCerrar;

    @FindBy(xpath = "//b[contains(text(), 'Atenci')]/b")
    WebElement msgError;

    @FindBy(id = "ctl00_ContentPlaceMain_btnEstadoAprobadoMatricular")
    WebElement btnEstadoMatricular;

    @FindBy(id = "ctl00_ContentPlaceMain_btnEstadoAprobadoRechazar")
    WebElement btnEstadoRechazar;

    @FindBy(id = "ctl00_ContentPlaceMain_btnEstadoAprobadoCancelar")
    WebElement btnEstadoCancelar;

    @FindBy(xpath = "//table[@id='ctl00_ContentPlaceMain_gvConstanciaVacantes']/tbody")
    WebElement tableConstancia;

    @FindBy(id = "ctl00_ContentPlaceMain_txtFecTraslado")
    WebElement inputFechaTrasladoConfirma;

    @FindBy(id = "ctl00_ContentPlaceMain_ddlTipoMatricula")
    WebElement cboTipoMatricula;

    @FindBy(id = "ctl00_ContentPlaceMain_ddlTipoMatricula")
    WebElement cboTipoMatriculaPrevia;

    @FindBy(id = "ctl00_ContentPlaceMain_btnAceptarPrevio")
    WebElement btnAceptarPrevio;

    @FindBy(id = "ctl00_ContentPlaceMain_btnAprobar")
    WebElement btnAceptarAprobar;

    //ctl00_ContentPlaceMain_UdpAprobar


    public trasladopage(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

    public boolean CheckElementoInformativoSede()
    {
        //System.out.println("sede: " + informativoSede.isDisplayed());
        boolean response = this.Driver.missingElement(informativoSede);
        return response;
    }

    public boolean CheckElementoInformativoTipo()
    {
        //System.out.println("infoTipo: "+ informativoTipo.isDisplayed());

        boolean response = this.Driver.missingElement(informativoTipo);
        return response;
    }

    public boolean CheckElementoControlTipoConst() {
        return this.Driver.missingElement(cboTipoConst);
    }

    public boolean CheckElementoControlEstadoConst() {
        return this.Driver.missingElement(cboEstadoConst);
    }

    public boolean CheckElementoControlAnioDestino() {
        return this.Driver.missingElement(cboAnio);
    }

    public boolean CheckElementoControlBuscar() {
        return this.Driver.missingElement(btnBuscarConstancia);
    }

    public boolean CheckElementoControlLimpiar() {
        return this.Driver.missingElement(btnLimpiar);
    }

    public void seleccionTipoConstancia(String tipo) {
        Select tipCons = new Select(cboTipoConst);
        tipCons.selectByVisibleText(tipo);
    }

    public void seleccionEstadoConstancia(String estado) {
        Select estCons = new Select(cboEstadoConst);
        estCons.selectByVisibleText(estado);
    }

    public void seleccionAnioDestino(String anio) {
        Select destino = new Select(cboAnio);
        destino.selectByValue(anio);
    }

    public void botonAgregar() {
        btnAgregar.click();
    }

    public WebElement botonEstadoAlumno(String posicion) {

        WebElement ctrl = null;
        List<WebElement> lista = tableConstancia.findElements(By.tagName("tr"));

        for (int i = 0; i < lista.size(); i++) {

            if (String.valueOf(i).equals(posicion)) {
                List<WebElement> cols = lista.get(i).findElements(By.tagName("td"));
                ctrl = cols.get(8).findElement(By.tagName("input"));
                break;
            }

        }

        return ctrl;

    }

    public String buscarCodigoAlumno(String codigo) {

        String posicion = "";
        List<WebElement> lista = tableConstancia.findElements(By.tagName("tr"));
        //System.out.println("filas: " + lista.size());
        for (int i = 0; i < lista.size(); i++) {

            if (i > 0) {

                List<WebElement> cols = lista.get(i).findElements(By.tagName("td"));
                //System.out.println("cols: " + cols.size());
                if (cols.size() > 0 ) {

                    String valor = cols.get(0).getText().toLowerCase();
                    if (valor.equals(codigo.toLowerCase())) {

                        posicion = String.valueOf(i);
                        break;

                    }
                }
                //for (int j = 0; j < cols.size(); j++) {
                //    System.out.println("col: " + cols.get(j).getText());
                //}
            }
        }

        return posicion;

    }

    public void setChkAceptoCondiciones() {
        chkAceptoCondiciones.click();
    }

    public void BtnProcederTraslado() {
        btnProcederTraslado.click();
    }

    public void seleccionTipo(String tipoT) {
        Select tipo = new Select(cboTipoTraslado);
        tipo.selectByVisibleText(tipoT);
    }

    public void setInputIEOrigen(String ieOrigen) {
        inputIEOrigen.sendKeys(ieOrigen);
    }

    public void BtnBuscarIE() {
        btnBuscarIE.click();
    }
    public void BtnBuscarConstancia() { btnBuscarConstancia.click();}

    public void seleccionTipoDoc(String tipoDoc) {
        Select tip = new Select(cboTipoDoc);
        tip.selectByValue(tipoDoc);
    }

    public void setInputDocAlumno(String dni) {
        inputDocAlumno.sendKeys(dni);
        cboUltimadoGrado.click();
    }

    public void seleccionUltimoAnio(String ano) {
        Select anio = new Select(cboUltimoAnio);
        anio.selectByValue(ano);
    }

    public void seleccionUltimoGrado(String grado) {
        Select ultimo = new Select(cboUltimadoGrado);
        //ultimo.selectByVisibleText(grado);
        ultimo.selectByValue(grado);
    }

    public void BtnValidar() {
        btnValidar.click();
    }

    public void setFechaTraslado() {
        fechaTraslado.click();
        diaActivo.click();
    }

    public void setInputResolucion(String res) {
        inputResolucion.sendKeys(res);
    }

    public void setCheckDeclaracionJurada() {
        chkDeclaracionJ.click();
    }

    public void setCheckCopiaDNI() {
        chkCopiaDNI.click();
    }

    public void setCheckFichaUnicaMatricula() {
        chkFichaUnicaMatricula.click();
    }

    public void BtnGrabar() {        btnGrabarTraslado.click();    }

    public void BtnEstadoMatricular() { btnEstadoMatricular.click(); }
    public void BtnEstadoRechazar() { btnEstadoRechazar.click(); }
    public void BtnEstadoCancelar() { btnEstadoCancelar.click(); }

    public void setFechaTrasladoConfirma() {

        Date fecha = new Date();
        String f = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
        System.out.println("fecha: " + f);
        inputFechaTrasladoConfirma.sendKeys(f);

    }

    public void BtnAceptarPrevio() {
        btnAceptarPrevio.click();
    }

    public void BtnAceptarAprobar() {
        btnAceptarAprobar.click();
    }

    public boolean CheckElementoControlEstadoMatricular() {
        return this.Driver.missingElement(btnEstadoMatricular);
    }
    public boolean CheckElementoControlEstadoRechazar() {
        return this.Driver.missingElement(btnEstadoRechazar);
    }
    public boolean CheckElementoControlEstadoCancelar() {
        return this.Driver.missingElement(btnEstadoCancelar);
    }

    public String msgError() {

        String resul = "";
        try {

            if (msgError.isDisplayed()) {
                resul = msgError.getText();
            } else {
                resul ="no displaya";
            }

        } catch (Exception e) {
            resul = "exception";
        }
        return resul;

    }

    public String msgAlert() {

        String resul = "";
        if (msgAlert.isDisplayed()) {
            resul = msgAlert.getText();
        }

        return resul;
    }

    public void BtnCerrar() {
        btnCerrar.click();
    }

    public void SeleccionVentana(String mainWindow, Set<String> allwindows) {

        Iterator<String> iterator = allwindows.iterator();

        System.out.println("Count of windows:"+allwindows.size());

        while (iterator.hasNext()) {

            String childWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {

                Driver.returnDriver().switchTo().window(childWindow);


            }
        }

    }

}
