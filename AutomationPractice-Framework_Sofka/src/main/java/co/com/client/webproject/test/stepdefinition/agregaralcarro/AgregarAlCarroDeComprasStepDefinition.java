package co.com.client.webproject.test.stepdefinition.agregaralcarro;

import co.com.client.webproject.test.controllers.AddToCartController;
import co.com.client.webproject.test.controllers.CheckOutController;
import co.com.client.webproject.test.controllers.CreateAnAccountWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.page.CheckOutPage;
import co.com.client.webproject.test.page.DressesPage;
import co.com.client.webproject.test.stepdefinition.Setup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static co.com.client.webproject.test.helpers.Dictionary.SPACE_STRING;

public class AgregarAlCarroDeComprasStepDefinition extends Setup {
    private WebAction webAction;
    private List<List<String>> specifications;

    @Before
    public void setup(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el usuario se encuentra en la pagina de inicio del aplicativo")
    public void queElUsuarioSeEncuentraEnLaPaginaDeInicioDelAplicativo() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("ingresa al apartado de vestidos y selecciona sus preferencias")
    public void ingresaAlApartadoDeVestidosYSeleccionaSusPreferencias(DataTable dataTable) {
        AddToCartController addToCartController = new AddToCartController();
        addToCartController.setWebAction(webAction);
        addToCartController.dirigirseAlApartadoVestidos();
        specifications = dataTable.asLists(String.class);
        addToCartController.añadirVestidoAlCarrito(specifications);

    }

    @Entonces("debera de ver el carrito de compras con la cantidad de productos seleccionados {string}")
    public void deberaDeVerElCarritoDeComprasConLaCantidadDeProductosSeleccionados(String quantityExpected) {
        DressesPage dressesPage = new DressesPage(webAction.getDriver());
        String quantityObtained = dressesPage.getCartQuantityProducts().getText();
        Assert.Hard.thatString(quantityObtained).contains(quantityExpected);
        Report.reportInfo("El mensaje esperado es " + quantityExpected + SPACE_STRING +
                "El mensaje Obtenido fue " + quantityObtained);
        webAction.closeBrowser();
    }

    //@ScenarioName:CompletarCompra
    @Cuando("ingresa al apartado de vestidos y selecciona su articulo")
    public void ingresaAlApartadoDeVestidosYSeleccionaSuArticulo(DataTable dataTable) {
        AddToCartController addToCartController = new AddToCartController();
        addToCartController.setWebAction(webAction);
        addToCartController.dirigirseAlApartadoVestidos();
        specifications = dataTable.asLists(String.class);
        addToCartController.agregarVestidoAlCarritoParaComprar(specifications);
        CheckOutController checkOutController = new CheckOutController();
        checkOutController.setWebAction(webAction);
        checkOutController.goToProccedCheckOutSummary();

    }

    @Cuando("se registra en el aplicativo con sus credenciales y completa el proceso de checkout")
    public void seRegistraEnElAplicativoConSusCredencialesYCompletaElProcesoDeCheckout() {
        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
        CheckOutController checkOutController = new CheckOutController();
        checkOutController.setWebAction(webAction);
        checkOutController.completarProcesoDeCompra();
    }

    @Entonces("el sistema debera mostrarle el mensaje {string}")
    public void elSistemaDeberaMostrarleElMensaje(String messageExpected) {
        CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());
        String messageObtained = checkOutPage.getOrderCompleteMessage().getText();
        Assert.Hard.thatString(messageObtained).isEqualTo(messageExpected);
        Report.reportInfo("El mensaje esperado es " + messageExpected + SPACE_STRING +
                "El mensaje Obtenido fue " + messageObtained);
        webAction.closeBrowser();
    }

}
