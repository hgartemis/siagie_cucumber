package Minedu.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.landingpage;
import pages.siagieIniciopage;
import pages.trasladopage;
import pom.landingPOM;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;


public class StepTraslados {

    private static final String ORIGINAL            = "ÁáÉéÍíÓóÚúÑñÜü";
    private static final String REPLACEMENT         = "AaEeIiOoUuNnUu";

    String mainWindow = null;
    Set<String> allwindows = null;
    String posicionEnTablaAlumno = "";

    landingpage LpTest = new landingpage(Runner.Driver);
    //LoginScreen LoTest = new LoginScreen(Runner.Driver);

    landingPOM LpPOM = new landingPOM(Runner.Driver);
    siagieIniciopage sIp = new siagieIniciopage(Runner.Driver);
    trasladopage tras = new trasladopage(Runner.Driver);


    @Given("el usuario ingresa a login siagie")
    public void elUsuarioIngresaASiagie() {
    }

    @Given("el tester selecciona el boton de seleccion de IEs")
    public void elTesterSeleccionaElBotonDeSeleccionDeIE() {

        LpTest.inputUsuario("19100733");
        LpTest.inputContrasena("2021Siagie@");
        LpTest.inputCaptcha("abc");

        Runner.Driver.implicitwait();
        LpTest.Iniciar();

        sIp.btnCambiarIE();
    }

    @And("ingresar {} en {} en TextBox")
    public void ingresarUsuarioEnEnTextBox(String valor, String control) {
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

    @And("hace click en boton Iniciar")
    public void haceClickEnEnBoton() {
        Runner.Driver.implicitwait();
        LpTest.Iniciar();


    }

    @And("hacer click en boton Cambiar de IE")
    public void hacerClickenBotonCambiarIE() {
        Runner.Driver.implicitwait();
        sIp.btnCambiarIE();
    }

    @And("ingresa el {}, {} y {} e ingresa a siagie")
    public void ingresaElUsuarioContrasenaYCaptcha(String usuario, String contrasena, String captcha) {
        LpTest.inputUsuario(usuario);
        LpTest.inputContrasena(contrasena);
        LpTest.inputCaptcha(captcha);

        Runner.Driver.implicitwait();
        LpTest.Iniciar();

        sIp.btnCambiarIE();
    }

    @When("escribe el {} en {}")
    public void escribeElCodigoModularEnTextboxCodMod(String valor, String control) {
        sIp.inputCodMod(valor);
        sIp.btnBuscarIE();
    }

    @And("y selecciona el resultado de la busquedas")
    public void ySeleccionaElResultadoDeLaBusqueda() {

        Runner.Driver.implicitwait();
        sIp.SeleccionIE();

        Runner.Driver.implicitwait();

    }

    @Given("EL tester selecciona en el menu la opcion matric")
    public void elTesterSeleccionaenelMenuLaOpcionMatricula() {

        Runner.Driver.implicitwait();
        sIp.mnuMatricula();

    }

    @When("se dirige a la opcion traslado y seguidamente ingresos")
    public void seDirigealaOpcionTrasladoySeguidamenteIngreso() {

        //Runner.Driver.returnDriver().manage().window().maximize();
        Runner.Driver.implicitwait();

        sIp.linkMenuIngreso();

    }

    @Then("en el formulario de gestion de traslado selecciona {}")
    public void enElFormularioDeGestionDeTrasladoSeleccionaAnioDestino(String anio) {

        Runner.Driver.implicitwait();

        mainWindow = Runner.Driver.returnDriver().getWindowHandle();
        allwindows = Runner.Driver.returnDriver().getWindowHandles();

        tras.SeleccionVentana(mainWindow, allwindows);

        tras.seleccionAnioDestino(anio);
        Runner.Driver.implicitwait();

    }

    @And("selecciona el boton agregar")
    public void seleccionaElBotonAgregar() {
        tras.botonAgregar();
        Runner.Driver.implicitwait();
    }

    @And("selecciona el check de acepto las condiciciones")
    public void seleccionaElCheckDeAceptoLasCondiciciones() {
        tras.setChkAceptoCondiciones();

    }

    @And("doy click en boton proceder")
    public void doyClickEnBotonProceder() {
        tras.BtnProcederTraslado();
        Runner.Driver.implicitwait();
    }

    @And("selecciono {}, ingreso el {} en textbox")
    public void seleccionoTipoTrasladoIngresoElIEOrigenEnTextbox(String tipo, String IEOrigen) {
        tras.seleccionTipo(tipo);
        tras.setInputIEOrigen(IEOrigen);
        Runner.Driver.implicitwait();
    }

    @And("doy click en boton Buscar")
    public void doyClickEnBotonBuscar() {
        tras.BtnBuscarIE();
        Runner.Driver.implicitwait();
    }

    @And("ingreso el {} del alumno en el textbox {}")
    public void ingresoElDocDelAlumnoEnElTextbox(String valor, String control) {
        switch (control) {
            case "dni":
                tras.seleccionTipoDoc("2");
                tras.setInputDocAlumno(valor);
                break;
            case "codigo":
                tras.seleccionTipoDoc("E");
                tras.setInputDocAlumno(valor);
                break;
        }

        Runner.Driver.implicitwait();
    }

    @And("ingreso el {} anio de estudio")
    public void ingresoElUltimoAnioDeEstudio(String anio) {
        tras.seleccionUltimoAnio(anio);
    }

    @And("ingreso el {} grado de estudio")
    public void ingresoElUltimoGradoDeEstudio(String grado) {
        tras.seleccionUltimoGrado(grado);
    }

    @And("doy click en boton validar")
    public void doyClickEnBotonValidar() {
        tras.BtnValidar();
        Runner.Driver.implicitwait();
    }

    @And("registro la fecha actual de traslado")
    public void registroLaFechaActualDeTraslado() {
        tras.setFechaTraslado();
    }

    @And("ingreso la {} de traslado")
    public void ingresoLaResolucionDeTraslado(String res) {
        tras.setInputResolucion(res);
    }

    @And("en declaracion jurada le doy check de recepcion")
    public void enDeclaracionJuradaLeDoyCheckDeRecepcion() {
        tras.setCheckDeclaracionJurada();
        Runner.Driver.scroll(100);
    }

    @And("doy click en algunos de los documentos del estudiante")
    public void doyClickenAlgunosDocumentosDelEstudiante() {
        tras.setCheckCopiaDNI();
        tras.setCheckFichaUnicaMatricula();
        Runner.Driver.scroll(100);
    }

    @And("le doy click en Grabar y proceder con el traslado")
    public void leDoyClickEnGrabarYProcederConElTraslado() {
        tras.BtnGrabar();
    }

    @And("finalmente valido si el mensaje es: {}")
    public void finalmenteValidoSiElMensajeEsMensaje(String msgEsperado) {

        Runner.Driver.implicitwait();
        Assert.assertEquals(msgEsperado, tras.msgError());

    }

    @And("finalmente valido si la alerta es: {}")
    public void finalmenteValidoSiLaAlertaEsMensaje(String msgEsperado) {

        Assert.assertEquals(msgEsperado, tras.msgAlert());
        Runner.Driver.implicitwait();

    }

    @And("selecciono {} en control {}")
    public void seleccionoTipoTraslado(String valor, String control) {
        switch (control) {
            case "traslado":
                tras.seleccionTipoConstancia(valor);
                break;
            case "constancia":
                tras.seleccionEstadoConstancia(valor);
                break;
        }
    }

    @And("doy click en buscar constancia de traslado")
    public void doyClickEnBuscarConstanciaDeTraslado() {
        tras.BtnBuscarConstancia();
        Runner.Driver.implicitwait();
    }

    @And("busco el {} del alumno en el resultado")
    public void buscoElCodigoDelAlumnoEnElResultado(String codigo) {

        posicionEnTablaAlumno = tras.buscarCodigoAlumno(codigo);
        //System.out.println("posicion: " + posicionEnTablaAlumno);
        Runner.Driver.implicitwait();
    }

    @And("doy en el click en el boton de estado")
    public void doyEnElClickEnElBotonDeEstado() {

        tras.botonEstadoAlumno(posicionEnTablaAlumno).click();
        Runner.Driver.implicitwait();

    }

    @And("valido el boton en solicitud y confirmo {} de la constancia")
    public void validoElBotonRechazoEnSolicitudYConfirmoEstadoDeLaConstancia(String estado)  {

        switch (estado) {
            case "rechazo":
                Assert.assertEquals(tras.CheckElementoControlEstadoRechazar(), true);
                tras.BtnEstadoRechazar();
                break;
            case "matricula":
                Assert.assertEquals(tras.CheckElementoControlEstadoMatricular(), true);
                tras.BtnEstadoMatricular();

                Runner.Driver.implicitwait();
                tras.setFechaTrasladoConfirma();

                Runner.Driver.implicitwait();
                tras.BtnAceptarPrevio();

                Runner.Driver.implicitwait();

                String resul = stripAccents(Runner.Driver.returnDriver().switchTo().alert().getText());
                String esperado = stripAccents("¿Está seguro de matricular al estudiante?");

                Runner.Driver.returnDriver().switchTo().alert().accept();

                Assert.assertEquals(esperado, resul);
                Runner.Driver.implicitwait();

                break;
        }

        Runner.Driver.implicitwait();

    }

    public static String stripAccents(String str) {
        if (str == null) {
            return null;
        }
        char[] array = str.toCharArray();
        for (int index = 0; index < array.length; index++) {
            int pos = ORIGINAL.indexOf(array[index]);
            if (pos > -1) {
                array[index] = REPLACEMENT.charAt(pos);
            }
        }
        return new String(array);
    }

}

