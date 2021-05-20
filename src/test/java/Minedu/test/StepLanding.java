package Minedu.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.landingpage;
import pages.siagieIniciopage;
import pom.landingPOM;

public class StepLanding {

    landingpage LpTest = null;
    landingPOM LpPOM = null;
    siagieIniciopage sIp = null;

    @Given("El usuario se encuentra en la pagina inicial")
    public void elUsuarioSeEncuentraEnLaPaginaInicial() {

        LpTest = new landingpage(Runner.Driver);
        LpPOM = new landingPOM(Runner.Driver);
        sIp = new siagieIniciopage(Runner.Driver);

    }

    @When("entonces valida cada uno de los controles")
    public void entoncesValidaCadaUnoDeLosControles() {
        Runner.Driver.implicitwait();
    }

    @Then("finalmente se confirma la existencia de cada uno")
    public void seConfirmaLaExistenciaDeCadaUno() {
        Assert.assertEquals(LpTest.checkElementsSimonLogo(), true);
        Assert.assertEquals(LpTest.checkElementsMineduLogo(), true);
        Assert.assertEquals(LpTest.checkElementsInformativeText(), true);
        Assert.assertEquals(LpTest.checkElementsManualText(), true);
        Assert.assertEquals(LpTest.checkElementsOlvideContrasenaText(), true);
        Assert.assertEquals(LpTest.checkElementsFooterText(), true);
        Assert.assertEquals(LpTest.checkElementsSiagieBtn(), true);
    }

    @When("escribo mi {} en textbox {}")
    public void escriboMiUsuarioEnTextboxUsuario(String valor, String control) {

        switch (control) {
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

    @Then("se deberia mostrar {} de validacion")
    public void seDeberiaMostrarMensajedevalidacion(String mensaje) {

        Runner.Driver.implicitwait();
        LpTest.Iniciar();

        Assert.assertEquals(LpTest.msg(),mensaje);


    }

    @Then("se deberia poder ingresar a la aplicacion")
    public void seDeberiaPoderIngresarALaAplicacion() {

        Runner.Driver.implicitwait();
        LpTest.Iniciar();

        Assert.assertEquals(sIp.checkElementsSloganMinedu(), true);
        Assert.assertEquals(sIp.checkElementsLinkText(), true);

    }
}
