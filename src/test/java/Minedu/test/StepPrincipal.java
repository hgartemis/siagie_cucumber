package Minedu.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.landingpage;
import pages.siagieIniciopage;
import pages.trasladopage;

import java.util.Set;

public class StepPrincipal {

    String mainWindow = null;
    Set<String> allwindows =null;

    landingpage LpTest = new landingpage(Runner.Driver);
    siagieIniciopage sIp = new siagieIniciopage(Runner.Driver);
    trasladopage tras = new trasladopage(Runner.Driver);

    @Given("el tester selecciona el boton de seleccion de IE")
    public void elTesterSeleccionaElBotonDeSeleccionDeIE() {
        //LpTest.inputUsuario("19100733");
        //LpTest.inputContrasena("2021Siagie@");
        //LpTest.inputCaptcha("abc");
    }

    @And("ingresa su {} en textbox {}")
    public void ingresaSuUsuarioEnTextboxUsuario(String valor, String control) {
            switch (control){
                case "usuario":
                    LpTest.inputUsuario(valor);
                    break;
                case "contrasena":
                    LpTest.inputContrasena(valor);
                    break;
                case "captcha":
                    LpTest.inputCaptcha(valor);
                    break;
            }
    }

    @And("da click en boton iniciar")
    public void daClickEnBotonIniciar() {
        Runner.Driver.implicitwait();
        LpTest.Iniciar();

    }

    @When("se posiciona en cambio de IE y escribe el {} en textbox {}")
    public void escribeElCodigoModularEnTextboxCodMod(String valor, String control) {

        sIp.btnCambiarIE();
        sIp.inputCodMod(valor);
        sIp.btnBuscarIE();
    }

    @And("y selecciona el resultado de la busqueda")
    public void ySeleccionaElResultadoDeLaBusqueda() {

        Runner.Driver.implicitwait();
        sIp.SeleccionIE();

        Runner.Driver.implicitwait();

    }

    @Then("finalmente se valida en formulario principal el {} seleccionado")
    public void finalmenteSeValidaEnFormularioPrincipalElIESeleccionada(String valor) throws InterruptedException {

        Thread.sleep(1000);

        WebDriverWait explicitWait= new WebDriverWait(Runner.Driver.returnDriver(),15);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'" + valor + "')]")));

        Assert.assertEquals( Runner.Driver.returnDriver().findElement(By.xpath("//span[contains(text(),'" + valor + "')]")).getText(), "OFICINA - " + valor + " - 0");

        Runner.Driver.implicitwait();

    }

    @Given("EL tester selecciona en el menu la opcion matricula")
    public void elTesterSeleccionaenelMenuLaOpcionMatricula() {

        Runner.Driver.implicitwait();
        sIp.mnuMatricula();

    }

    @When("se dirige a la opcion traslado y seguidamente ingreso")
    public void seDirigealaOpcionTrasladoySeguidamenteIngreso() {

        //Runner.Driver.returnDriver().manage().window().maximize();
        Runner.Driver.implicitwait();

        sIp.linkMenuIngreso();

    }

    @Then("finalmente valido si se encuentra en el formulario de traslados")
    public void finalmenteValidaSiSeEncuentraEnElFormulario() {

       Runner.Driver.implicitwait();

       mainWindow = Runner.Driver.returnDriver().getWindowHandle();
       allwindows = Runner.Driver.returnDriver().getWindowHandles();

       tras.SeleccionVentana(mainWindow, allwindows);

        Assert.assertEquals(tras.CheckElementoInformativoSede(), true);
        Assert.assertEquals(tras.CheckElementoInformativoTipo(), true);

    }



}
